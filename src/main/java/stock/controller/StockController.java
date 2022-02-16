package stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stock.dto.FigiesDto;
import stock.dto.StocksDto;
import stock.dto.StocksPricesDto;
import stock.dto.TickersDto;
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
	
	@PostMapping("/stocks/getStocksByTickers")
	public StocksDto getStocksByTickers(@RequestBody TickersDto tickersDto) {
		return stockService.getStocksByTickers(tickersDto);
	}
	
	@PostMapping("/prices")
	public StocksPricesDto getPrices(@RequestBody FigiesDto figiesDto) {
		return stockService.getPrices(figiesDto);
	}
}
