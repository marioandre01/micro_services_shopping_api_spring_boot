package com.mario.backend.dto;

import java.util.Date;

import lombok.Data;

@Data // gera os gets e sets da classe
public class ErrorDTO {
	
	private int status;
	private String message;
	private Date timestamp;
	
	// get e sets
}
