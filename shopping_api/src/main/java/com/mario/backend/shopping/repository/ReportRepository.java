package com.mario.backend.shopping.repository;

import java.util.Date;
import java.util.List;

import com.mario.backend.shopping.dto.ShopReportDTO;
import com.mario.backend.shopping.model.Shop;


public interface ReportRepository {
	
//	retorna uma lista de compras que respeite os filtros passados
	public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);
	
//	retorna um relatório das compras para um período de tempo
	public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);
}
