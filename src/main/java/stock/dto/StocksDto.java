package stock.dto;

import java.util.List;

import stock.model.Stock;

public class StocksDto {

	List<Stock> stocks;

	
	
	public StocksDto() {
		super();
	}

	public StocksDto(List<Stock> stocks) {
		super();
		this.stocks = stocks;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	
}
