package stock.dto;

import java.util.List;

public class StocksPricesDto {

	private List<StockPrice> prices;

	public StocksPricesDto(List<StockPrice> prices) {
		super();
		this.prices = prices;
	}

	public List<StockPrice> getPrices() {
		return prices;
	}

	public void setPrices(List<StockPrice> prices) {
		this.prices = prices;
	}
	
	
}
