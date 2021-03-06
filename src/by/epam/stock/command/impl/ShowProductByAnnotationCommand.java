package by.epam.stock.command.impl;

import by.epam.stock.bean.entity.Stock;
import by.epam.stock.command.Command;
import by.epam.stock.request.Request;
import by.epam.stock.request.Response;
import by.epam.stock.request.ShowProductByAnnotationRequest;
import by.epam.stock.service.StockService;
import by.epam.stock.service.exeption.ServiceException;
import by.epam.stock.service.impl.ServiceFactory;

public class ShowProductByAnnotationCommand implements Command {
	@Override
	public Response execute(Request request) {
		Stock productList = null;
		ShowProductByAnnotationRequest showProductByAnnotationRequest = null;

		if (request instanceof ShowProductByAnnotationRequest) {
			showProductByAnnotationRequest = (ShowProductByAnnotationRequest) request;
		}
		String annotation = showProductByAnnotationRequest.getAnnotation();
		String path = showProductByAnnotationRequest.getPath();

		Response response = new Response();
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StockService stockService = serviceFactory.getServiceFactory();

		try {
			productList = stockService.showProductByAnnotationContain(path, annotation);
			response.setErrorStatus(false);
			response.setProducts(productList);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
		}

		return response;

	}

}
