package by.epam.stock.bean.entity;
import java.util.ArrayList;
import java.util.List;

public class Stock {
private List<Product> stock  = new ArrayList<>();

public Stock() {

}

public Stock(List<Product> stock ) {
	this.stock = stock;

}

@Override
public String toString() {
	return "Stock [stock=" + stock + "]";
}

public List<Product> getStock() {
	return stock;
}

public void setStock(List<Product> stock) {
	this.stock = stock;
}
	
}

	

