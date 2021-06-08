package com.mario.backend.product.dto;

import lombok.Data;

@Data // gera os gets e sets da classe
public class ProductByCategoryDTO {
	
	// relatório com a contagem, valor total e médio de todas as compras
	
	private String nome;
	private Float preco;
	private String descricao;
	private String productIdentifier;
		
	// gets and sets
}
