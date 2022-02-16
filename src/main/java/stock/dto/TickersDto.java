package stock.dto;

import java.util.List;


public class TickersDto {

	private List<String> tickers;

	
	public TickersDto() {
		super();
	}

	public TickersDto(List<String> tickers) {
		super();
		this.tickers = tickers;
	}

	public List<String> getTickers() {
		return tickers;
	}

	public void setTickers(List<String> tickers) {
		this.tickers = tickers;
	}
	
	
}
