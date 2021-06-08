package com.mario.backend.shopping.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.CreationTimestamp;

import com.mario.backend.shopping.dto.ShopDTO;

import lombok.Data;

@Data // gera os gets e sets da classe
@Entity(name="shop")
public class Shop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String userIdentifier;
	
	private float total;
	
//	@CreationTimestamp //gerar timestamp automaticamente
	private Date date;
	
//	@ElementCollection - mapea o relacionamento de uma coleção dependente, pois uma compra tem uma coleção de itens
//	fetch = FetchType.EAGER - indica que  os valores devem ser recuperados no BD(banco de dados) junto da entidade principal
	
//	@CollectionTable para definir qual é a tabela onde os itens estarão armazenados, no caso, a tabela shop_item
//	@JoinColumn define qual coluna da tabela shop_item será unida (join) à tabela shop , no caso a coluna shop_id
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "item", joinColumns = @JoinColumn(name = "shop_id"))
	private List<Item> items;
	
	// gets e sets
	
	public static Shop convertToShop(ShopDTO shopDTO) {
		
		Shop shop = new Shop();
		
		shop.setUserIdentifier(shopDTO.getUserIdentifier());
		shop.setTotal(shopDTO.getTotal());
		shop.setDate(shopDTO.getDate());
		
		shop.setItems(shopDTO
			.getItems()
			.stream()
			.map(Item::convertToItem)
			.collect(Collectors.toList()));
		
		return shop;
	}
}
