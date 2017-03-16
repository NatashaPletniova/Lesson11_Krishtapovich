package by.epam.stock.command.impl;

import by.epam.stock.bean.entity.Stock;
import by.epam.stock.command.Command;
import by.epam.stock.request.Request;
import by.epam.stock.request.Response;
import by.epam.stock.request.ShowProductByNameAndCodeRequest;
import by.epam.stock.service.StockService;
import by.epam.stock.service.exeption.ServiceException;
import by.epam.stock.service.impl.ServiceFactory;

public class ShowProductByNameAndCodeCommand implements Command {

	@Override
	public Response execute(Request request) {
		Stock productList = null;
		ShowProductByNameAndCodeRequest showProductByNameAndCodeRequest = null;

		if (request instanceof ShowProductByNameAndCodeRequest) {
			showProductByNameAndCodeRequest = (ShowProductByNameAndCodeRequest) request;
		}

		String path = showProductByNameAndCodeRequest.getPath();
		Integer code = showProductByNameAndCodeRequest.getCode();
		String name = showProductByNameAndCodeRequest.getName();

		Response response = new Response();
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StockService stockService = serviceFactory.getServiceFactory();

		try {
			productList = stockService.showProductByNameAndCode(path, name, code);
			response.setErrorStatus(false);
			response.setProducts(productList);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
		}

		return response;

	}

}
