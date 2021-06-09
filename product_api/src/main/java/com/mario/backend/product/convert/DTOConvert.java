package com.mario.backend.product.convert;

import com.mario.backend.dto.CategoryDTO;
import com.mario.backend.dto.ProductDTO;
import com.mario.backend.product.model.Category;
import com.mario.backend.product.model.Product;

public class DTOConvert {
	
	public static CategoryDTO convertToCategoryDTO(Category category) {
		
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setNome(category.getNome());
		
		return categoryDTO;
	}
	
	public static ProductDTO convertToProductDTO(Product product) {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setNome(product.getNome());
		productDTO.setPreco(product.getPreco());
		
		if (product.getCategory() != null) {
			productDTO.setCategory(
			DTOConvert.convertToCategoryDTO(product.getCategory()));
		}
		return productDTO;
	}
}
