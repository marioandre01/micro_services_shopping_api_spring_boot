package com.mario.backend.shopping.model;

import javax.persistence.Embeddable;

import com.mario.backend.shopping.dto.ItemDTO;

import lombok.Data;

// @Embeddable , indicando que ela pode ser embutida em uma entidade. 
//Uma classe com a anotação @Embeddable não tem vida própria, ela sempre depende de uma entidade, isto é, de uma
//classe que tenha a anotação @Entity

@Data // gera os gets e sets da classe
@Embeddable
public class Item {
	
	private String productIdentifier;
	private Float price;
	
	// gets and sets
	
	public static Item convertToItem(ItemDTO itemDTO) {
		
		Item item = new Item();
		
		item.setProductIdentifier(
		itemDTO.getProductIdentifier());
		item.setPrice(itemDTO.getPrice());
		
		return item;
	}
}
