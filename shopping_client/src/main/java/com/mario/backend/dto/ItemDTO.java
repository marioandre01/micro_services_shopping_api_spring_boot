package com.mario.backend.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//import com.mario.backend.shopping.model.Item;

import lombok.Data;

@Data // gera os gets e sets da classe
public class ItemDTO {
	
//	@NotBlank e @NotNull validarão se os campos possuem valores válidos quando for salvo um novo produto
//	@NotBlank - verifica se uma String é diferente de nulo e não é vazia
//	@NotNull - deve ser utilizada para campos de outros tipos como o Float
	
	@NotBlank
	private String productIdentifier;
	
	@NotNull
	private Float price;
	
	// get and sets
	
}
