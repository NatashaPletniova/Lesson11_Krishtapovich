package by.epam.stock.request;

import java.util.Date;

public class ShowProductByProductDateRequest extends Request {

	private String path;
	private Date productDate;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

}
