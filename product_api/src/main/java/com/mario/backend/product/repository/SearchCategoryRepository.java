package com.mario.backend.product.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.mario.backend.product.dto.ProductByCategoryDTO;
import com.mario.backend.product.model.Product;

public interface SearchCategoryRepository {
	
//	public List<Product> getProductByCategory2(@Param("categoryId") long categoryId);
	public List<ProductByCategoryDTO> getProductByCategory2(@Param("categoryId") long categoryId);

}
