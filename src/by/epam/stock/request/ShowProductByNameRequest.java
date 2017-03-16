package by.epam.stock.request;

public class ShowProductByNameRequest extends Request {
	private String path;
	private String name;

	public ShowProductByNameRequest() {

	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
