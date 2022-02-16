package stock.service;


import stock.dto.FigiesDto;
import stock.dto.StocksDto;
import stock.dto.StocksPricesDto;
import stock.dto.TickersDto;
import stock.model.Stock;


public interface StockService {

	public Stock getStockByTicker(String ticker);
	public StocksDto getStocksByTickers(TickersDto tickers);
	public StocksPricesDto getPrices(FigiesDto figiesDto);

}
