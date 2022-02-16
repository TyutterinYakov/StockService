package stock.dto;

public class StockPrice {

	private String figi;
	private Double price;
	
	public StockPrice(String figi, Double price) {
		super();
		this.figi = figi;
		this.price = price;
	}

	public String getFigi() {
		return figi;
	}

	public void setFigi(String figi) {
		this.figi = figi;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
