package com.mario.backend.shopping.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mario.backend.shopping.dto.ShopReportDTO;
import com.mario.backend.shopping.model.Shop;

public class ReportRepositoryImpl implements ReportRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	// a implementação das consultas vai aqui
	
	@Override
	public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo) {
		
//		objeto para montar a consulta SQL
		StringBuilder sb = new StringBuilder();
		
		sb.append("select s ");
		sb.append("from shop s ");
		sb.append("where s.date >= :dataInicio ");
		
//		filtro dataFim
		if (dataFim != null) {
			sb.append("and s.date <= :dataFim ");
		}
		
//		filtro valorMinimo
		if (valorMinimo != null) {
			sb.append("and s.total <= :valorMinimo ");
		}
		
//		objeto do tipo Query
		Query query = entityManager.createQuery(sb.toString());
		
//		passar os valores dos filtros criados, com o método setParameter
		query.setParameter("dataInicio", dataInicio);
		
		if (dataFim != null) {
			query.setParameter("dataFim", dataFim);
		}
		if (valorMinimo != null) {
			query.setParameter("valorMinimo", valorMinimo);
		}
		
//		executar o método getResultList que retorna a lista de objetos que são retornados da consulta
//		return query.getResultList();

		List<Shop> myShop = query.getResultList();
		
		System.out.println("myShop2: " + myShop);
		
		return myShop;
	}
	
	@Override
	public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("select count(sp.id), sum(sp.total), avg(sp.total) ");
		sb.append("from shopping.shop sp ");
		sb.append("where sp.date >= :dataInicio ");
		sb.append("and sp.date <= :dataFim ");
		
		Query query = entityManager.createNativeQuery(sb.toString());
		
		query.setParameter("dataInicio", dataInicio);
		query.setParameter("dataFim", dataFim);
		
//		o resultado da consulta é pego, utilizando o método getSingleResult da classe Query
		
		System.out.println("result1: "+ query.getSingleResult());
		
		Object[] result = (Object[]) query.getSingleResult();
		
		System.out.println("result2: "+result);
		
//		Quando é retornado apenas um objeto, não é possível fazer a conversão direta para uma classe de entidade, como foi feito no método "getShopByFilters". 
//		Agora é preciso pegar cada um dos valores retornados e criar o objeto do tipo ShopReportDTO manualmente, pois esse é o objeto que será retornado no fim do método.
		
		ShopReportDTO shopReportDTO = new ShopReportDTO();
		
//		A consulta sempre retorna BigInteger para consultas com a função count e Double para consultas com as funções sum e avg
//		Por isso foi necessário fazer o cast para esses tipos antes de definir os valores no objeto shopReportDTO
		
		shopReportDTO.setCount(((BigInteger) result[0]).intValue());
		shopReportDTO.setTotal((Double) result[1]);
		shopReportDTO.setMean((Double) result[2]);
		
		return shopReportDTO;
	}
}


//@PersistenceContext - esse objeto faz a conexão com o banco de dados - como anteriormente estáva usando apenas
//consultas diretamente com o Spring Data, ainda não tínha-se precisado dele, porém, como tem que escrever a consulta
//nesse caso, precisa-se da conexão com o banco de dados diretamente.

// filtros dataFim e valorMinimo não são obrigatórios, por isso existe um if para verificar se eles devem
// fazer parte da consulta ou não



