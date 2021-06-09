package com.mario.backend.shopping.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.mario.backend.dto.UserDTO;
import com.mario.backend.exception.UserNotFoundException;

@Service
public class UserService {
	
	public UserDTO getUserByCpf(String cpf) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			String url = "http://localhost:8080/user/cpf/" + cpf;
			
//			o método getForEntity da classe RestTemplate , faz a chamada para a user-api.
			ResponseEntity<UserDTO> response = restTemplate.getForEntity(url, UserDTO.class);
			
			return response.getBody();
			
		} catch (HttpClientErrorException.NotFound e) {
			throw new UserNotFoundException();
		}
	}
}

//O método getForEntity responde com um objeto da classe ResponseEntity que possui diversas informações importantes,
//como o status da chamada (200 se tudo ocorrer bem ou 40x se algo der errado) e principalmente o corpo da requisição no método
//getBody . Veja que, internamente, o Spring já converteu o JSON para um objeto UserDTO , o que facilita bastante a implementação
//de clientes REST com esse framework.


