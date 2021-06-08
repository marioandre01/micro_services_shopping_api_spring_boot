package com.mario.backend.product.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.repository.query.Param;

import com.mario.backend.product.dto.ProductByCategoryDTO;


public class SearchCategoryRepositoryImpl implements SearchCategoryRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	// a implementação das consultas vai aqui
	
	@Override
	public List<ProductByCategoryDTO> getProductByCategory2(@Param("categoryId") long categoryId){
		
//		objeto para montar a consulta SQL
		StringBuilder sb = new StringBuilder();
		
//		sb.append("select p ");
		sb.append("select p.nome, p.preco, p.productIdentifier, p.descricao ");
		sb.append("from product p ");
		sb.append("inner join category c on p.category.id = c.id ");
		sb.append("where c.id = :categoryId ");
		
//		objeto do tipo Query
		Query query = entityManager.createQuery(sb.toString());
		
//		passar os valores dos filtros criados, com o método setParameter
		query.setParameter("categoryId", categoryId);
		
//		executar o método getResultList que retorna a lista de objetos que são retornados da consulta
//		Se fazer o Select de todas as colunas da tabela, é retornado o os dados com o tipo da tabela, ex: Porduct e com isso ja é feito o mapeamento coma a variaveis definidas
//      Se fazer o select com só algumas colunas no retorno não vai ter o tipo do objeto, vai estar assim: [[Ljava.lang.Object;@13197a22, [Ljava.lang.Object;@711a6b30]
//		Dai tem que tratar isso usando DTO

//		Instancia uma lista do tipo roductByCategoryDTO
		List<ProductByCategoryDTO> retornoProductByCategory = new ArrayList<ProductByCategoryDTO>();
		
//		Para o numero de resultados da consulta, tratar eles e converter para o tipo ProductByCategoryDTO e adicionar na lista retornoProductByCategory
		for (int i=0; i < query.getResultList().size(); i++) {
			
//			Cria uma variavel do tipo Object(super class) e recebe cada valor da list e converet (casting) para o tipo object
			Object[] result = (Object[]) query.getResultList().get(i);
			
			ProductByCategoryDTO productByCategoryDTO = new ProductByCategoryDTO();
			
//			pega cada valor das variaveis na ordem de chamada da consulta e converte (casting) elas para o tipo que foi definidos para elas na classe Product
			productByCategoryDTO.setNome((String) result[0]);
			productByCategoryDTO.setPreco((Float) result[1]);
			productByCategoryDTO.setProductIdentifier((String) result[2]);
			productByCategoryDTO.setDescricao((String) result[3]);
		
//			adicona na lista 
			retornoProductByCategory.add(productByCategoryDTO);

		}

		return retornoProductByCategory;
		
	}
}
