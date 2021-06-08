package com.mario.backend.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mario.backend.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>, SearchCategoryRepository {
	
	@Query(value = "select p "
//	@Query(value = "select p.nome, p.preco, p.productIdentifier, p.descricao "
			+ "from product p "
			+ "join category c on p.category.id = c.id "
			+ "where c.id = :categoryId ")
	public List<Product> getProductByCategory(@Param("categoryId") long categoryId);
	
	public Product findByProductIdentifier(String productIdentifier);
}
