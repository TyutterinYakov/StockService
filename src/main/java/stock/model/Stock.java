package stock.model;


public class Stock {

	private String ticker;
	private String figi;
	private String name;
	private String type;
	private Currency currency;
	private String source;
	
	public Stock(String ticker, String figi, String name, String type, Currency currency, String source) {
		super();
		this.ticker = ticker;
		this.figi = figi;
		this.name = name;
		this.type = type;
		this.currency = currency;
		this.source = source;
	}
	
	
	public Stock() {
		super();
	}


	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getFigi() {
		return figi;
	}
	public void setFigi(String figi) {
		this.figi = figi;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	
	
	
}
