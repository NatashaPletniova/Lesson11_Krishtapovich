package by.epam.stock.service.impl;

import by.epam.stock.service.StockService;



public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	private final StockService stockService = new StockServiceImpl();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public StockService getServiceFactory() {
		return stockService;
	}

}