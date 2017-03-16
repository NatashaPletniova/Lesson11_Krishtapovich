package by.epam.stock.request;

import java.util.Comparator;

import by.epam.stock.bean.entity.Product;

public class ShowSortedProductRequest extends Request{
	private String path;
	private Comparator<Product> comparator;
	public ShowSortedProductRequest(){
		
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Comparator<Product> getComparator() {
		return comparator;
	}
	public void setComparator(Comparator<Product> comparator) {
		this.comparator = comparator;
	}

}
