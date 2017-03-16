package by.epam.stock.dao.impl;

public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	
	private final DealWithProductDAO productDAO = new DealWithProductDAO();

	private DAOFactory(){}
	
	public static DAOFactory getInstance(){
	return instance;
	}

	public DealWithProductDAO getProductDAO() {
		return productDAO;
	}

}
