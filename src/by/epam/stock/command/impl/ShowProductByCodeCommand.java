package by.epam.stock.command.impl;

import by.epam.stock.bean.entity.Stock;
import by.epam.stock.command.Command;
import by.epam.stock.request.Request;
import by.epam.stock.request.Response;
import by.epam.stock.request.ShowProductByCodeRequest;
import by.epam.stock.service.StockService;
import by.epam.stock.service.exeption.ServiceException;
import by.epam.stock.service.impl.ServiceFactory;

public class ShowProductByCodeCommand implements Command {

	@Override
	public Response execute(Request request) {
		Stock productList = null;
		ShowProductByCodeRequest showProductByCodeRequest = null;

		if (request instanceof ShowProductByCodeRequest) {
			showProductByCodeRequest = (ShowProductByCodeRequest) request;
		}

		String path = showProductByCodeRequest.getPath();
		Integer code = showProductByCodeRequest.getCode();

		Response response = new Response();
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StockService stockService = serviceFactory.getServiceFactory();

		try {
			productList = stockService.showProductByCode(path, code);
			response.setErrorStatus(false);
			response.setProducts(productList);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
		}

		return response;

	}

}
