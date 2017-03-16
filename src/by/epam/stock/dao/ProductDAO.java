package by.epam.stock.dao;

import java.util.Comparator;
import java.util.Date;

import by.epam.stock.bean.entity.Product;
import by.epam.stock.bean.entity.Stock;
import by.epam.stock.dao.exeption.DAOException;


public interface ProductDAO {

	Stock getDataFromFile(String path) throws DAOException;
	Stock getSortedDataFromFile (String path, Comparator<Product> comparator) throws DAOException;
    Stock showProductByName(String path, String name) throws DAOException;
    Stock showProductByCode(String path, Integer code) throws DAOException;
    Stock showProductByAnnotation(String path, String annotation) throws DAOException;
    Stock showProductByProductDate(String path, Date productDate) throws DAOException;
    Stock showProductByNameAndCode(String path, String name, Integer code) throws DAOException;
    Stock showProductByAnnotationContain(String path, String annotation) throws DAOException;
    
    void addProduct(String path, String name, Integer code, Date productDate, String annotation) throws DAOException;



}
