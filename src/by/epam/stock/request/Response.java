package by.epam.stock.request;

//import java.util.List;

import by.epam.stock.bean.entity.Stock;

public class Response {
	private boolean errorStatus;
	private String errorMessage;
	private String simpleMessage;
	// private List<Product> products;
	private Stock products;

	public Response() {

	}

	public boolean isErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(boolean errorStatus) {
		this.errorStatus = errorStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getSimpleMessage() {
		return simpleMessage;
	}

	public void setSimpleMessage(String simpleMessage) {
		this.simpleMessage = simpleMessage;
	}

	public Stock getProducts() {
		return products;
	}

	public void setProducts(Stock products) {
		this.products = products;
	}

}
