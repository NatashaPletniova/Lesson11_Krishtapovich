package by.epam.stock.bean.entity;

import java.util.Date;

public class Product {

	
	//private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
	
	private String name;
	private Integer code;
	private Date productDate;
	private String annotation;
	
	public Product() {
	}

	public Product(String name, int code, Date productDate, String annotation) {
		this.name = name;
		this.code = code;
		this.productDate = productDate;
	}
	
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}



	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", code=" + code + ", productDate=" + productDate + ", annotation="
				+ annotation + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annotation == null) ? 0 : annotation.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((productDate == null) ? 0 : productDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (annotation == null) {
			if (other.annotation != null)
				return false;
		} else if (!annotation.equals(other.annotation))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (productDate == null) {
			if (other.productDate != null)
				return false;
		} else if (!productDate.equals(other.productDate))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Date getProductDate() {
		return productDate;
	}



	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

}
