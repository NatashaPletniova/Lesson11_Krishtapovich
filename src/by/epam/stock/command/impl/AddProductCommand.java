package by.epam.stock.command.impl;

import java.util.Date;

import by.epam.stock.command.Command;
import by.epam.stock.request.AddProductRequest;
import by.epam.stock.request.Request;
import by.epam.stock.request.Response;
import by.epam.stock.service.StockService;
import by.epam.stock.service.exeption.ServiceException;
import by.epam.stock.service.impl.ServiceFactory;

public class AddProductCommand implements Command{
	
	private final static String addRow = "Product was added tothe stock.";
	
	@Override
	public Response execute(Request request) {
		AddProductRequest addProductRequest = null;
		
		if(request instanceof AddProductRequest){
			addProductRequest = (AddProductRequest)request;
		}
		
		String path = addProductRequest.getPath(); 
		String name = addProductRequest.getName();
		Integer code = addProductRequest.getCode();
		Date productDate = addProductRequest.getProductDate();
		String annotation = addProductRequest.getAnnotation();
		
		
		
		Response response = new Response();
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StockService stockService = serviceFactory.getServiceFactory();
		
		try {
			stockService.addProduct(path, name, code, productDate, annotation);
			response.setErrorStatus(false);
			response.setSimpleMessage(addRow);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
		}
	
		
		return response;
	}

}
