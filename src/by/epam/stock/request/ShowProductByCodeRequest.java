package by.epam.stock.request;

public class ShowProductByCodeRequest extends Request {
	private String path;
	private Integer code;

	public ShowProductByCodeRequest() {

	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
