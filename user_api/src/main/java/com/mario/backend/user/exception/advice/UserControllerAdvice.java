package com.mario.backend.user.exception.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mario.backend.dto.ErrorDTO;
import com.mario.backend.exception.UserNotFoundException;

// UserControllerAdvice - classe que será executada sempre que uma exceção for lançada. Para isso
// deve estar com a anotação @ControllerAdvice informando o pacote dos controllers da aplicação.

// basePackages - indica que ela deve verificar as exceções retornadas em todos os controllers.
// HttpStatus.NOT_FOUND - indica que deve ser retornado o erro 404 como status da resposta.

//A exceção UserNotFoundException.class na anotação @ExceptionHandler indica que esse método deve
//capturar esse tipo de exceções.

//@ResponseBody define que o retorno desse método será retornado no corpo da resposta.

@ControllerAdvice(basePackages = "com.mario.backend.user.controller")
public class UserControllerAdvice {
	
//	Captura da exceção UserNotFoundException no método handleUserNotFound
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public ErrorDTO handleUserNotFound(UserNotFoundException userNotFoundException) {
		
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
		errorDTO.setMessage("Usuário não encontrado.");
		errorDTO.setTimestamp(new Date());
		
		return errorDTO;
	}
	
}

//ex de resposta da exceção:

//{
//"status": 404,
//"message": "Usuário não encontrado.",
//"timestamp": "2019-10-18T17:33:45.996+0000"
//}

