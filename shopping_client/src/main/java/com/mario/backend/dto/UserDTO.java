package com.mario.backend.dto;

import java.util.Date;

//import com.mario.backend.user.model.User;
import lombok.Data;

@Data // gera os gets e sets da classe
public class UserDTO {
	
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private Date dataCadastro;
	private String key;
	
	//gets e sets

}
