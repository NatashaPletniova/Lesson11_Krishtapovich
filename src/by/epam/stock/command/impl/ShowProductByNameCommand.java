package by.epam.stock.command.impl;

import by.epam.stock.bean.entity.Stock;
import by.epam.stock.command.Command;
import by.epam.stock.request.Request;
import by.epam.stock.request.Response;
import by.epam.stock.request.ShowProductByNameRequest;
import by.epam.stock.service.StockService;
import by.epam.stock.service.exeption.ServiceException;
import by.epam.stock.service.impl.ServiceFactory;

public class ShowProductByNameCommand implements Command {
	@Override
	public Response execute(Request request) {
		Stock productList = null;
		ShowProductByNameRequest showSortedProductRequest = null;

		if (request instanceof ShowProductByNameRequest) {
			showSortedProductRequest = (ShowProductByNameRequest) request;
		}

		String path = showSortedProductRequest.getPath();
		String name = showSortedProductRequest.getName();

		Response response = new Response();
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StockService stockService = serviceFactory.getServiceFactory();

		try {
			productList = stockService.showProductByName(path, name);
			response.setErrorStatus(false);
			response.setProducts(productList);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
		}

		return response;

	}

}
