package com.mario.backend.shopping.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mario.backend.shopping.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>, ReportRepository {
	
//	recupera todas as compras de um usuário específico
	public List<Shop> findAllByUserIdentifier(String userIdentifier);
	
//	busca todas as compras que tenham um valor total maior do que o valor passado como parâmetro
	public List<Shop> findAllByTotalGreaterThan(Float total);

//	retorna todas as compras a partir de uma data específica
	public List<Shop> findAllByDateGreaterThan(Date date);
}

// padrões importantes para essas buscas
// o findAll , indica que a busca será por um ou mais resultados
// o By{Atributo} , que indica por qual atributo será feita a busca
// o GreaterThan , que faz um filtro de apenas valores maiores do que o passado como parâmetro serão buscados

// adicionardo um extends para essa a interface "ReportRepository". Isso serve para que os métodos que serão implementados as 
// consultas possam ser injetados sempre que se utilizar a "ShopRepository"






