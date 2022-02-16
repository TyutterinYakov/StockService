package stock.service;

import org.springframework.stereotype.Service;

import stock.model.Stock;


public interface StockService {

	public Stock getStockByTicker(String ticker);

}
