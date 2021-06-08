package com.mario.backend.shopping.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.mario.backend.shopping.model.Item;
import com.mario.backend.shopping.model.Shop;

import lombok.Data;

@Data // gera os gets e sets da classe
public class ShopDTO {
	
//	@NotBlank e @NotNull validarão se os campos possuem valores válidos quando for salvo um novo produto
//	@NotBlank - verifica se uma String é diferente de nulo e não é vazia
//	@NotNull - deve ser utilizada para campos de outros tipos como o Float
	
	@NotBlank
	private String userIdentifier;
	
//	@NotNull
	private Float total;
	
//	@NotNull
	private Date date;
	
	@NotNull
	private List<ItemDTO> items;
	
	// get and sets
	
	public static ShopDTO convertToShopDTO(Shop shop) {
		
		ShopDTO shopDTO = new ShopDTO();
		
		shopDTO.setUserIdentifier(shop.getUserIdentifier());
		shopDTO.setTotal(shop.getTotal());
		shopDTO.setDate(shop.getDate());

		shopDTO.setItems(shop
				.getItems()
				.stream()
				.map(ItemDTO::convertToItemDTO)
				.collect(Collectors.toList()));
		
		return shopDTO;
	}
}
