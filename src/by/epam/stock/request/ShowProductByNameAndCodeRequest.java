package by.epam.stock.request;

public class ShowProductByNameAndCodeRequest extends Request {
	private String path;
	private String name;
	private Integer code;

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

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public ShowProductByNameAndCodeRequest() {

	}

}
