package com.mario.backend.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mario.backend.product.dto.ProductByCategoryDTO;
import com.mario.backend.product.dto.ProductDTO;
import com.mario.backend.product.model.Product;
import com.mario.backend.product.repository.ProductRepository;

import com.mario.backend.product.exception.ProductNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductDTO> getAll() {
		
		List<Product> products = productRepository.findAll();
		
		return products
		.stream()
		.map(ProductDTO::convertToProductDTO)
		.collect(Collectors.toList());
	}
	
//	public List<ProductDTO> getProductByCategoryId(Long categoryId) {
	public List<ProductByCategoryDTO> getProductByCategoryId(Long categoryId) {
		
//		List<Product> products = productRepository.getProductByCategory(categoryId);
		List<ProductByCategoryDTO> products = productRepository.getProductByCategory2(categoryId);
		
//		return products
//		.stream()
//		.map(ProductDTO::convertToProductDTO)
//		.collect(Collectors.toList());
		
		return products;
	}
	
	public ProductDTO findByProductIdentifier(String productIdentifier) {
		
		Product product = productRepository.findByProductIdentifier(productIdentifier);
		
		if (product != null) {
			return ProductDTO.convertToProductDTO(product);
		}
		
		return null;
	}
	
	public ProductDTO save(ProductDTO productDTO) {
		
		Product product = productRepository.save(Product.convertToProduct(productDTO));
		
		return ProductDTO.convertToProductDTO(product);
	}
	
	public ProductDTO delete(long ProductId) throws ProductNotFoundException {
		
//		Optional<T> - encapsula o retorno de métodos e informar se um valor do tipo <T> está presente ou ausente.
		Optional<Product> Product = productRepository.findById(ProductId);
		
//		isPresent​ - Se um valor estiver presente retorna true, se não, retorna false.
//		get​ - Se um valor estiver presente retorna o valor, caso contrário, lança NoSuchElementException.
		if (Product.isPresent()) {
			productRepository.delete(Product.get());
		}
		
		return null;
	}
}
