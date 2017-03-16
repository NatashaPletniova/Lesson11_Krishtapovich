package by.epam.stock.service;

import java.util.Comparator;
import java.util.Date;
import by.epam.stock.bean.entity.Product;
import by.epam.stock.bean.entity.Stock;
import by.epam.stock.service.exeption.ServiceException;

public interface StockService {
	
	Stock getDataFromFile(String path) throws ServiceException;
	Stock getSortedDataFromFile (String path, Comparator<Product> comparator) throws ServiceException;
    Stock showProductByName(String path, String name) throws ServiceException;
    Stock showProductByCode(String path, Integer code) throws ServiceException;
    Stock showProductByAnnotation(String path, String annotation) throws ServiceException;
    Stock showProductByProductDate(String path, Date productDate) throws ServiceException;
    Stock showProductByNameAndCode(String path, String name, Integer code) throws ServiceException;
    Stock showProductByAnnotationContain(String path, String annotation) throws ServiceException;
    void addProduct(String path, String name, Integer code, Date productDate, String annotation) throws ServiceException;

}
