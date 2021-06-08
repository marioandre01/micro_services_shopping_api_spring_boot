package com.mario.backend.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mario.backend.product.dto.ProductByCategoryDTO;
import com.mario.backend.product.dto.ProductDTO;
import com.mario.backend.product.exception.ProductNotFoundException;
import com.mario.backend.product.service.ProductService;

@RestController
public class productController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public List<ProductDTO> getProducts() {
		List<ProductDTO> produtos = productService.getAll();
		
		return produtos;
	}
	
	@GetMapping("/product/category/{categoryId}")
//	public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId) {
	public List<ProductByCategoryDTO> getProductByCategory(@PathVariable Long categoryId) {		
		
//		List<ProductDTO> produtos = productService.getProductByCategoryId(categoryId);	
		List<ProductByCategoryDTO> produtos = productService.getProductByCategoryId(categoryId);	
		
		return produtos;
	}
	
	@GetMapping("/product/{productIdentifier}")
	public ProductDTO findById(@PathVariable String productIdentifier) {
		
		return productService.findByProductIdentifier(productIdentifier);
	}
	
//	indica que quando a rota "/product" for chamada, as validações definidas na classe ProductDTO devem ser feitas
//	Se essa anotação não for adicionada, nenhuma validação será feita	
	@PostMapping("/product")
	public ProductDTO newProduct(@Valid @RequestBody ProductDTO productDTO) {
		
		return productService.save(productDTO);
	}
	
	@DeleteMapping("/product/{id}")
	public ProductDTO delete(@PathVariable Long id) throws ProductNotFoundException {
		return productService.delete(id);
	}
}
