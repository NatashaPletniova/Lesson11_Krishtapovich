package by.epam.stock.util.comparator;

import java.util.Comparator;

import by.epam.stock.bean.entity.Product;

public class ProductNameComparator implements Comparator<Product> {

	public int compare(Product obj1, Product obj2) {
		return obj1.getName().compareTo(obj2.getName());
	}

}
