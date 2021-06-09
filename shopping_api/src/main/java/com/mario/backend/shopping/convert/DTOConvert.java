package com.mario.backend.shopping.convert;

import java.util.stream.Collectors;

import com.mario.backend.dto.ItemDTO;
import com.mario.backend.dto.ShopDTO;
import com.mario.backend.shopping.model.Item;
import com.mario.backend.shopping.model.Shop;

public class DTOConvert {
	
	public static ItemDTO convertToItemDTO(Item item) {
		
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setProductIdentifier(
		item.getProductIdentifier());
		itemDTO.setPrice(item.getPrice());
		
		return itemDTO;
	}
	
	public static ShopDTO convertToShopDTO(Shop shop) {
		ShopDTO shopDTO = new ShopDTO();
		shopDTO.setUserIdentifier(shop.getUserIdentifier());
		shopDTO.setTotal(shop.getTotal());
		shopDTO.setDate(shop.getDate());
		shopDTO.setItems(shop
		.getItems()
		.stream()
		.map(DTOConvert::convertToItemDTO)
		.collect(Collectors.toList()));
		
		return shopDTO;
	}
}
