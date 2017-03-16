package by.epam.stock.command.impl;

import by.epam.stock.request.ShowSortedProductRequest;
import by.epam.stock.request.Request;
import by.epam.stock.request.Response;
import by.epam.stock.service.StockService;
import by.epam.stock.service.exeption.ServiceException;
import by.epam.stock.service.impl.ServiceFactory;

import java.util.Comparator;

import by.epam.stock.bean.entity.Product;
import by.epam.stock.bean.entity.Stock;
import by.epam.stock.command.Command;

public class ShowSortedProductCommand implements Command {
	@Override
	public Response execute(Request request) {
		Stock productList = null;
		ShowSortedProductRequest showSortedProductRequest = null;

		if (request instanceof ShowSortedProductRequest) {
			showSortedProductRequest = (ShowSortedProductRequest) request;
		}

		String path = showSortedProductRequest.getPath();
		Comparator<Product> comparator = showSortedProductRequest.getComparator();
		Response response = new Response();
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StockService stockService = serviceFactory.getServiceFactory();

		try {
			productList = stockService.getSortedDataFromFile(path, comparator);
			response.setErrorStatus(false);
			response.setProducts(productList);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
		}

		return response;

	}

}
