package com.mario.backend.user.convert;

import com.mario.backend.dto.UserDTO;
import com.mario.backend.user.model.User;

public class DTOConvert {
	
	public static UserDTO convertToUserDTO(User user) {
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setNome(user.getNome());
		userDTO.setEndereco(user.getEndereco());
		userDTO.setCpf(user.getCpf());
		userDTO.setEmail(user.getEmail());
		userDTO.setTelefone(user.getTelefone());
		userDTO.setDataCadastro(user.getDataCadastro());
		userDTO.setKey(user.getKey());
		
		return userDTO;
	}
}
