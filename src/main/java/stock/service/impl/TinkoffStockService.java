package stock.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ru.tinkoff.invest.openapi.OpenApi;
import ru.tinkoff.invest.openapi.model.rest.MarketInstrumentList;
import ru.tinkoff.invest.openapi.model.rest.Orderbook;
import stock.dto.FigiesDto;
import stock.dto.StockPrice;
import stock.dto.StocksDto;
import stock.dto.StocksPricesDto;
import stock.dto.TickersDto;
import stock.exception.StockNotFoundException;
import stock.model.Currency;
import stock.model.Stock;
import stock.service.StockService;

@Service
public class TinkoffStockService implements StockService{

	private static final Logger logger = LoggerFactory.getLogger(TinkoffStockService.class);
	private final OpenApi openApi;
	
	@Async
	public CompletableFuture<MarketInstrumentList> getMarketInstrumentTicker(String ticker){
		var context = openApi.getMarketContext();
		return context.searchMarketInstrumentsByTicker(ticker);
	}
	
	@Autowired
	public TinkoffStockService(OpenApi openApi) {
		super();
		this.openApi = openApi;
	}

	@Override
	public Stock getStockByTicker(String ticker) throws StockNotFoundException {
		var cf = getMarketInstrumentTicker(ticker);
		var list = cf.join().getInstruments();
		if(list.isEmpty()) {
			throw new StockNotFoundException(String.format("Stock %S not found.", ticker));
		}
		var item = list.get(0);
		return new Stock(
				item.getTicker(),
				item.getFigi(),
				item.getName(),
				item.getType().getValue(),
				Currency.valueOf(item.getCurrency().getValue()),
				"TINKOFF");
	}
	
	@Override
	public StocksDto getStocksByTickers(TickersDto tickers) {
		List<CompletableFuture<MarketInstrumentList>> marketInstruments = new ArrayList<>();
		tickers.getTickers().forEach(ticker -> marketInstruments.add(getMarketInstrumentTicker(ticker)));
		List<Stock> stocks = marketInstruments.stream()
				.map(CompletableFuture::join)
				.map(mi -> {
					if(!mi.getInstruments().isEmpty()) {
						return mi.getInstruments().get(0);
					}
					return null;
				})
				.filter(el -> Objects.nonNull(el))
				.map(mi-> new Stock(
						mi.getTicker(),
						mi.getFigi(),
						mi.getName(),
						mi.getType().getValue(),
						Currency.valueOf(mi.getCurrency().getValue()),
						"TINKOFF"
				))
				.collect(Collectors.toList());
		return new StocksDto(stocks);
	}
	
//	public StockPrice getPrice(String figi) {
//		var orderBook = openApi.getMarketContext().getMarketOrderbook(figi, 0).join().get();
//		return new StockPrice(
//				figi,
//				orderBook.getLastPrice().doubleValue()
//				);
//	}
	
	@Async
	public CompletableFuture<Optional<Orderbook>> getOrderBookByFigi(String figi){
		var orderbook = openApi.getMarketContext().getMarketOrderbook(figi, 0);
		logger.info("Getting price {} from Tinkoff", figi);
		return orderbook;
		
	}
	
	public StocksPricesDto getPrices(FigiesDto figiesDto) {
		List<CompletableFuture<Optional<Orderbook>>> orderBooks = new ArrayList<>();
		figiesDto.getFigies().forEach(figi->orderBooks.add(getOrderBookByFigi(figi)));
		var listPrices = orderBooks.stream()
				.map(CompletableFuture::join)
				.map(oo->oo.orElseThrow(()-> new StockNotFoundException("Stock not found")))
				.map(orderbook -> new StockPrice(
						orderbook.getFigi(),
						orderbook.getLastPrice().doubleValue()
				))
				.collect(Collectors.toList());
		return new StocksPricesDto(listPrices);
	}

}
