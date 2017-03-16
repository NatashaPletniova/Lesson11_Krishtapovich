package by.epam.stock.command.impl;


import by.epam.stock.bean.entity.Stock;
import by.epam.stock.command.Command;
import by.epam.stock.request.GetProductRequest;
import by.epam.stock.request.Request;
import by.epam.stock.request.Response;
import by.epam.stock.service.StockService;
import by.epam.stock.service.exeption.ServiceException;
import by.epam.stock.service.impl.ServiceFactory;

public class GetProductCommand implements Command{
	
	@Override
	public Response execute(Request request) {
		Stock productList = null;
		GetProductRequest getProductRequest = null;
		
		if(request instanceof GetProductRequest){
			getProductRequest = (GetProductRequest)request;
		}
		
		String path = getProductRequest.getPath(); 
		Response response = new Response();
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StockService stockService = serviceFactory.getServiceFactory();
		
		try {
			productList =  stockService.getDataFromFile(path);
			response.setErrorStatus(false);
			response.setProducts(productList);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
		}
	
		
		return response;
	}

}
