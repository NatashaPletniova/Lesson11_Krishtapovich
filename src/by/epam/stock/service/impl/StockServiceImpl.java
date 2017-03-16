package by.epam.stock.service.impl;
import java.util.Comparator;

import by.epam.stock.bean.entity.Product;
import by.epam.stock.bean.entity.Stock;
import by.epam.stock.dao.ProductDAO;
import by.epam.stock.dao.exeption.DAOException;
import by.epam.stock.dao.impl.DAOFactory;
import by.epam.stock.service.StockService;
import by.epam.stock.service.exeption.ServiceException;
import java.util.Date;

public class StockServiceImpl implements StockService {

	@Override
	public Stock getDataFromFile(String path) throws ServiceException {
		if (path == null || "".equals(path)) {
			throw new ServiceException("Invalid parameters");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ProductDAO productDAO = daoObjectFactory.getProductDAO();
		Stock productList = null;
		try {
			productList = new Stock(productDAO.getDataFromFile(path).getStock());

		} catch (DAOException e) {
			throw new ServiceException("Ошибка во время получения данных", e);
		}

		return productList;

	}

	public Stock getSortedDataFromFile(String path, Comparator<Product> comparator) throws ServiceException {

		if (path == null || "".equals(path) || comparator == null) {
			throw new ServiceException("Invalid parameters");
		}
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ProductDAO productDAO = daoObjectFactory.getProductDAO();
		Stock productList = null;
		try {
			productList = new Stock(productDAO.getSortedDataFromFile(path, comparator).getStock());

		} catch (DAOException e) {
			throw new ServiceException("Ошибка во время получения данных", e);
		}

		return productList;

	}

	public Stock showProductByName(String path, String name) throws ServiceException {
		if (path == null || "".equals(path)) {
			throw new ServiceException("Invalid path parameter");
		}

		if (name == null || "".equals(name)) {
			throw new ServiceException("Invalid name parameter");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ProductDAO productDAO = daoObjectFactory.getProductDAO();
		Stock productList = null;

		try {
			productList = new Stock(productDAO.showProductByName(path, name).getStock());

		} catch (DAOException e) {
			throw new ServiceException("Ошибка во время поиска по имени", e);
		}

		return productList;

	}

	public Stock showProductByCode(String path, Integer code) throws ServiceException {

		if (path == null || "".equals(path)) {
			throw new ServiceException("Invalid path parameter");
		}

		if (code == null || code <= 0) {
			throw new ServiceException("Invalid code parameter");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ProductDAO productDAO = daoObjectFactory.getProductDAO();
		Stock productList = null;

		try {
			productList = new Stock(productDAO.showProductByCode(path, code).getStock());

		} catch (DAOException e) {
			throw new ServiceException("Ошибка во время поиска по коду", e);
		}

		return productList;
	}

	public Stock showProductByAnnotation(String path, String annotation) throws ServiceException {

		if (path == null || "".equals(path)) {
			throw new ServiceException("Invalid path parameter");
		}

		if (annotation == null || "".equals(annotation)) {
			throw new ServiceException("Invalid annotation parameter");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ProductDAO productDAO = daoObjectFactory.getProductDAO();
		Stock productList = null;

		try {
			productList = new Stock(productDAO.showProductByAnnotation(path, annotation).getStock());

		} catch (DAOException e) {
			throw new ServiceException("Ошибка во время поиска по аннотации", e);
		}

		return productList;

	}

	public Stock showProductByProductDate(String path, Date productDate) throws ServiceException {

		if (path == null || "".equals(path)) {
			throw new ServiceException("Invalid path parameter");
		}

		if (productDate == null) {
			throw new ServiceException("Invalid productDate parameter");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ProductDAO productDAO = daoObjectFactory.getProductDAO();
		Stock productList = null;

		try {
			productList = new Stock(productDAO.showProductByProductDate(path, productDate).getStock());

		} catch (DAOException e) {
			throw new ServiceException("Ошибка во время поиска по дате производства", e);
		}

		return productList;
	}

	public Stock showProductByNameAndCode(String path, String name, Integer code) throws ServiceException {

		if (path == null || "".equals(path)) {
			throw new ServiceException("Invalid path parameter");
		}

		if (name == null || "".equals(name)) {
			throw new ServiceException("Invalid name parameter");
		}

		if (code == null || code <= 0) {
			throw new ServiceException("Invalid code parameter");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ProductDAO productDAO = daoObjectFactory.getProductDAO();
		Stock productList = null;

		try {
			productList = new Stock(productDAO.showProductByNameAndCode(path, name, code).getStock());

		} catch (DAOException e) {
			throw new ServiceException("Ошибка во время поиска по наименованию и коду", e);
		}

		return productList;

	}

	public Stock showProductByAnnotationContain(String path, String annotation) throws ServiceException {

		if (path == null || "".equals(path)) {
			throw new ServiceException("Invalid path parameter");
		}

		if (annotation == null || "".equals(annotation)) {
			throw new ServiceException("Invalid annotation parameter");
		}
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ProductDAO productDAO = daoObjectFactory.getProductDAO();
		Stock productList = null;

		try {
			productList = new Stock(productDAO.showProductByAnnotationContain(path, annotation).getStock());

		} catch (DAOException e) {
			throw new ServiceException("Ошибка во время поиска вхождения слова в аннотацию", e);
		}

		return productList;

	}

	public void addProduct(String path, String name, Integer code, Date productDate, String annotation)
			throws ServiceException {

		if (path == null || "".equals(path)) {
			throw new ServiceException("Invalid path parameter");
		}

		if (name == null || "".equals(name)) {
			throw new ServiceException("Invalid name parameter");
		}

		if (code == null || code <= 0) {
			throw new ServiceException("Invalid code parameter");
		}

		if (annotation == null || "".equals(annotation)) {
			throw new ServiceException("Invalid annotation parameter");
		}

		if (productDate == null) {
			throw new ServiceException("Invalid productDate parameter");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ProductDAO productDAO = daoObjectFactory.getProductDAO();

		try {

			productDAO.addProduct(path, name, code, productDate, annotation);

		} catch (DAOException e) {
			throw new ServiceException("Ошибка во время нового продукта", e);
		}

	}

}
