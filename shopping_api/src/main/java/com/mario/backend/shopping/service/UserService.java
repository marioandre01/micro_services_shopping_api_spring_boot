package com.mario.backend.shopping.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.mario.backend.dto.UserDTO;
import com.mario.backend.exception.UserNotFoundException;

@Service
public class UserService {
	
	@Value("${USER_API_URL:http://localhost:8080}")
	private String userApiURL;
	
	public UserDTO getUserByCpf(String cpf, String key) {
		try {
			System.out.println("cpf: "+ cpf);
			System.out.println("key: "+ key);
			
			RestTemplate restTemplate = new RestTemplate();
			
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(userApiURL + "/user/cpf/" + cpf);
			
			builder.queryParam("key", key);
			
			System.out.println("builder: "+ builder.toUriString());
			
//			o método getForEntity da classe RestTemplate , faz a chamada para a user-api.
			ResponseEntity<UserDTO> response = restTemplate.getForEntity(builder.toUriString(), UserDTO.class);
			
			System.out.println("response: "+ response);
			
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

//para montar URIs mais complexas, existe uma classe do Spring bastante interessante, que é a UriComponentsBuilder . Com ela pode-se
//passar a URL básica, que no caso é a http://localhost:8081/user/{cpf} e depois passar uma lista de
//parâmetros, que serão adicionadas na URL. Essa classe montará a String com todos os parâmetros necessários de uma forma mais clara e simples.

