package com.mario.backend.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mario.backend.product.dto.ProductDTO;

import lombok.Data;


@Data // gera os gets e sets da classe
@Entity(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private Float preco;
	private String descricao;
	private String productIdentifier;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	// get e sets
	
	public static Product convertToProduct(ProductDTO productDTO) {
		
		Product product = new Product();
		
		product.setNome(productDTO.getNome());
		product.setPreco(productDTO.getPreco());
		product.setDescricao(productDTO.getDescricao());
		product.setProductIdentifier(productDTO.getProductIdentifier());
		
		if (productDTO.getCategory() != null) {
			product.setCategory(Category.convertToCategory(productDTO.getCategory()));
		}
		return product;
	}
}
