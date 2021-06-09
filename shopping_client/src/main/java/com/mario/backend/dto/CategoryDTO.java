package com.mario.backend.dto;

import javax.validation.constraints.NotNull;

//import com.mario.backend.product.model.Category;

import lombok.Data;

@Data // gera os gets e sets da classe
public class CategoryDTO {

//	@NotBlank e @NotNull validarão se os campos possuem valores válidos quando for salvo um novo produto
//	@NotBlank - verifica se uma String é diferente de nulo e não é vazia
//	@NotNull - deve ser utilizada para campos de outros tipos como o Float
	
	@NotNull
	private Long id;
	
	private String nome;
	
	// gets e sets

}
