package com.mario.backend.shopping.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mario.backend.shopping.dto.ShopDTO;
import com.mario.backend.shopping.dto.ShopReportDTO;
import com.mario.backend.shopping.model.Shop;
import com.mario.backend.shopping.repository.ShopRepository;

@Service
public class ShopService {
	
	@Autowired
	private ShopRepository shopRepository;
	
	
	public List<ShopDTO> getAll() {
		
		List<Shop> shops = shopRepository.findAll();
		
		return shops
			.stream()
			.map(ShopDTO::convertToShopDTO)
			.collect(Collectors.toList());
	}
	
	public List<ShopDTO> getByUser(String userIdentifier) {
		
		List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
		
		return shops
			.stream()
			.map(ShopDTO::convertToShopDTO)
			.collect(Collectors.toList());
	}
	
	public List<ShopDTO> getByDate(ShopDTO shopDTO) {
		
		List<Shop> shops = shopRepository.findAllByDateGreaterThan(shopDTO.getDate());
		
		return shops
			.stream()
			.map(ShopDTO::convertToShopDTO)
			.collect(Collectors.toList());
	}
	
	public ShopDTO findById(long ProductId) {
		
		Optional<Shop> shop = shopRepository.findById(ProductId);
		
		if (shop.isPresent()) {
			return ShopDTO.convertToShopDTO(shop.get());
		}
		
		return null;
	}
	
	public ShopDTO save(ShopDTO shopDTO) {
	
		shopDTO.setTotal(shopDTO.getItems()
			.stream()
			.map(x -> x.getPrice())
			.reduce((float) 0, Float::sum));
			
		Shop shop = Shop.convertToShop(shopDTO);
		shop.setDate(new Date());
		
		shop = shopRepository.save(shop);
		
		return ShopDTO.convertToShopDTO(shop);
	}
	
	public List<ShopDTO> getShopsByFilter(Date dataInicio, Date dataFim, Float valorMinimo) {
		
		List<Shop> shops = shopRepository.getShopByFilters(dataInicio, dataFim, valorMinimo);
		
		return shops.stream().map(ShopDTO::convertToShopDTO).collect(Collectors.toList());
	}
	
	public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
		
		return shopRepository.getReportByDate(dataInicio, dataFim);
	}
	
}
