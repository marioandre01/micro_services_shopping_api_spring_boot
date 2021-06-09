package com.mario.backend.shopping.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mario.backend.dto.ProductDTO;

@Service
public class ProductService {
	
	public ProductDTO getProductByIdentifier(String productIdentifier) {
		
			RestTemplate restTemplate = new RestTemplate();
			String url ="http://localhost:8081/product/" + productIdentifier;
			
			ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);
			
			return response.getBody();
	}
}
