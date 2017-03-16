package by.epam.stock.command.impl;

import java.util.Date;

import by.epam.stock.bean.entity.Stock;
import by.epam.stock.command.Command;
import by.epam.stock.request.Request;
import by.epam.stock.request.Response;
import by.epam.stock.request.ShowProductByProductDateRequest;
import by.epam.stock.service.StockService;
import by.epam.stock.service.exeption.ServiceException;
import by.epam.stock.service.impl.ServiceFactory;

public class ShowProductByProductDateCommand implements Command {
	@Override
	public Response execute(Request request) {
		Stock productList = null;
		ShowProductByProductDateRequest showProductByProductDateRequest = null;

		if (request instanceof ShowProductByProductDateRequest) {
			showProductByProductDateRequest = (ShowProductByProductDateRequest) request;
		}

		String path = showProductByProductDateRequest.getPath();
		Date productDate = showProductByProductDateRequest.getProductDate();

		Response response = new Response();
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StockService stockService = serviceFactory.getServiceFactory();

		try {
			productList = stockService.showProductByProductDate(path, productDate);
			response.setErrorStatus(false);
			response.setProducts(productList);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
		}

		return response;

	}

}
