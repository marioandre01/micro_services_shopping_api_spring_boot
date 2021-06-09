package com.mario.backend.product.exception.advice;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mario.backend.dto.ErrorDTO;
import com.mario.backend.exception.CategoryNotFoundException;
import com.mario.backend.exception.ProductNotFoundException;

//UserControllerAdvice - classe que será executada sempre que uma exceção for lançada. Para isso
//deve estar com a anotação @ControllerAdvice informando o pacote dos controllers da aplicação.

//basePackages - indica que ela deve verificar as exceções retornadas em todos os controllers.
//HttpStatus.NOT_FOUND - indica que deve ser retornado o erro 404 como status da resposta.

//A exceção ProductNotFoundException.class na anotação @ExceptionHandler indica que esse método deve
//capturar esse tipo de exceções.

//@ResponseBody define que o retorno desse método será retornado no corpo da resposta.

@ControllerAdvice(basePackages = "com.mario.backend.product.controller")
public class ProductControllerAdvice {
	
//	Captura da exceção ProductNotFoundException no método handleUserNotFound
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductNotFoundException.class)
	public ErrorDTO handleUserNotFound(ProductNotFoundException userNotFoundException) {
		
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
		errorDTO.setMessage("Produto não encontrado.");
		errorDTO.setTimestamp(new Date());
		
		return errorDTO;
	}
	
//	Captura da exceção CategoryNotFoundException no método handleCategoryNotFound
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CategoryNotFoundException.class)
	public ErrorDTO handleCategoryNotFound(CategoryNotFoundException categoryNotFoundException) {
		
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
		errorDTO.setMessage("Categoria não encontrada.");
		errorDTO.setTimestamp(new Date());
		
		return errorDTO;
	}
	
//	Se não é informado um campo obrigatório na hora de salvar um novo produto.
//	Quando isso acontece, o Spring retorna o erro MethodArgumentNotValidException, por isso deve-se
// trata esse erro. Nesse caso retornar-se uma mensagem indicando quais campos possuem valores inválidos.
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorDTO processValidationError(MethodArgumentNotValidException ex) {
		
		ErrorDTO errorDTO = new ErrorDTO();
		
		errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
		BindingResult result = ex.getBindingResult();
		
		List<FieldError> fieldErrors = result.getFieldErrors();
		
		StringBuilder sb = new StringBuilder("Valor inválido para o(s) campo(s):");
		
		for (FieldError fieldError : fieldErrors) {
			sb.append(" ");
			sb.append(fieldError.getField());
		}
		
		errorDTO.setMessage(sb.toString());
		errorDTO.setTimestamp(new Date());
		
		return errorDTO;
	}
}

//ProductNotFoundException - resposta exibida para o usuário:
//{
//"status": 404,
//"message": "Produto não encontrado.",
//"timestamp": "2019-10-18T17:33:45.996+0000"
//}

//CategoryNotFoundException - resposta exibida para o usuário:
//{
//"status": 404,
//"message": "Categoria não encontrado.",
//"timestamp": "2019-10-18T17:33:45.996+0000"
//}

//se tentar salvar um produto sem alguns campos, por exemplo, o preço e o identificador do produto,
//como no seguinte JSON:
//{
//	"nome":"TV 2",
//	"category": {
//		
//	}
//}

// se obtem a seguinte resposta:
//{
//	"status": 400,
//	"message": "Valor inválido para o(s) campo(s): productIdentifier preco",
//	"timestamp": "2020-06-14T16:22:33.661+00:00"
//}
