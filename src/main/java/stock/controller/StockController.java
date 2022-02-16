package stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stock.model.Stock;
import stock.service.StockService;

@RestController
@RequestMapping
public class StockController {

	private final StockService stockService;
	
	@Autowired
	public StockController(StockService stockService) {
		super();
		this.stockService = stockService;
	}


	@GetMapping("/stocks/{ticker}")
	public Stock getStock(@PathVariable("ticker") String ticker) {
		return stockService.getStockByTicker(ticker);
	}
}
