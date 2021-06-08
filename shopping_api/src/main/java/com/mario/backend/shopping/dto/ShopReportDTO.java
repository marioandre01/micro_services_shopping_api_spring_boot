package com.mario.backend.shopping.dto;

import lombok.Data;

@Data // gera os gets e sets da classe
public class ShopReportDTO {
	
// relatório com a contagem, valor total e médio de todas as compras
	
	private Integer count;
	private Double total;
	private Double mean;
	
	// gets and sets
}
