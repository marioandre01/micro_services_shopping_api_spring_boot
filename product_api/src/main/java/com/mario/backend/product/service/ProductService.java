package com.mario.backend.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mario.backend.product.model.Product;
import com.mario.backend.product.repository.CategoryRepository;
import com.mario.backend.product.repository.ProductRepository;
import com.mario.backend.dto.ProductByCategoryDTO;
import com.mario.backend.dto.ProductDTO;
import com.mario.backend.exception.CategoryNotFoundException;
import com.mario.backend.exception.ProductNotFoundException;
import com.mario.backend.product.convert.DTOConvert;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<ProductDTO> getAll() {
		
		List<Product> products = productRepository.findAll();
		
		return products
		.stream()
		.map(DTOConvert::convertToProductDTO)
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
			return DTOConvert.convertToProductDTO(product);
		}
//		exceção para produto não encontrado
		throw new ProductNotFoundException();
	}
	
	public ProductDTO save(ProductDTO productDTO) {
		
//		existsById - método do Spring Data(jpa) - verifica se um determinado Id existe no banco de dados, retornando apenas true ou false
//		verifica se uma categoria existe antes de tentar cadastrar um produto
		Boolean existsCategory = categoryRepository.existsById(productDTO.getCategory().getId());
		
//		Se informar uma categoria que não existe, será retornado o erro CategoryNotFoundException
		if (!existsCategory) {
			throw new CategoryNotFoundException();
		}
		
		Product product = productRepository.save(Product.convertToProduct(productDTO));
		
		return DTOConvert.convertToProductDTO(product);
	}
	
	public ProductDTO delete(long ProductId) throws ProductNotFoundException {
		
//		Optional<T> - encapsula o retorno de métodos e informar se um valor do tipo <T> está presente ou ausente.
		Optional<Product> Product = productRepository.findById(ProductId);
		
//		isPresent​ - Se um valor estiver presente retorna true, se não, retorna false.
//		get​ - Se um valor estiver presente retorna o valor, caso contrário, lança NoSuchElementException.
		if (Product.isPresent()) {
			productRepository.delete(Product.get());
		}
		
//		exceção para produto não encontrado
		throw new ProductNotFoundException();
	}
}
