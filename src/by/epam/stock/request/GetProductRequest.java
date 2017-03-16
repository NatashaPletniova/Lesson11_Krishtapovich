package by.epam.stock.request;

public class GetProductRequest extends Request{
	private String path;
	
	public GetProductRequest (){}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


}
