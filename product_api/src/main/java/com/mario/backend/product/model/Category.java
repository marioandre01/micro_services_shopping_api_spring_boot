package com.mario.backend.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mario.backend.product.dto.CategoryDTO;
import com.mario.backend.product.dto.ProductDTO;

import lombok.Data;

@Data // gera os gets e sets da classe
@Entity(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	// gets e sets
	
	public static Category convertToCategory(CategoryDTO categoryDTO) {
		
		Category category = new Category();
		
		category.setId(categoryDTO.getId());
		category.setNome(categoryDTO.getNome());
		
		return category;
	}
}
