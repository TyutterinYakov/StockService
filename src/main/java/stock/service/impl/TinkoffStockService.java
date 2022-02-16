package stock.service.impl;

import org.springframework.stereotype.Service;

import ru.tinkoff.invest.openapi.OpenApi;
import stock.model.Stock;
import stock.service.StockService;

@Service
public class TinkoffStockService implements StockService{

	private final OpenApi openApi;
	
	@Override
	public Stock getStockByTicker(String ticker) {
		return null;
	}

}
