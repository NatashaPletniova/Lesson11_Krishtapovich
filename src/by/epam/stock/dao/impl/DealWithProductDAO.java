package by.epam.stock.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import by.epam.stock.bean.entity.Product;
import by.epam.stock.bean.entity.Stock;
import by.epam.stock.dao.ProductDAO;
import by.epam.stock.dao.exeption.DAOException;

public class DealWithProductDAO implements ProductDAO {

	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd", Locale.US);

	public final static String EMPTY_STRING = "";
	public final static String COLUMN_SEPARATOR = ";";
	public final static String PRODUCT_SEPARATOR = "|";
	public final static char LINE_SEPARATOR = '\n';
	public final static int PRODUCT_NAME = 0;
	public final static int PRODUCT_CODE = 1;
	public final static int PRODUCT_DATE = 2;
	public final static int PRODUCT_ANNOTATION = 3;

	@Override
	public Stock getDataFromFile(String path) throws DAOException {

		Stock productList = new Stock();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String sCurrentLine;
			String sLine = EMPTY_STRING;
			String[] s;
			Date date = null;
			Product tempProduct = null;

			while ((sCurrentLine = br.readLine()) != null) {
				if (!sCurrentLine.equals(PRODUCT_SEPARATOR)) {
					sLine = sLine + sCurrentLine;
				} else {
					tempProduct = new Product();
					s = sLine.split(COLUMN_SEPARATOR);
					tempProduct.setName(s[PRODUCT_NAME]);
					tempProduct.setCode(Integer.valueOf(s[PRODUCT_CODE]));
					date = (Date) sdf.parse(s[PRODUCT_DATE]);
					tempProduct.setProductDate(date);
					tempProduct.setAnnotation(s[PRODUCT_ANNOTATION]);
					sLine = EMPTY_STRING;
					productList.getStock().add(tempProduct);
				}

			}

		} catch (IOException | ParseException ex) {
			throw new DAOException("Failed obtaining data.", ex);
		}
		return productList;

	}

	@Override
	public Stock showProductByName(String path, String name) throws DAOException {

		Stock productList = new Stock();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String sCurrentLine;
			String sLine = EMPTY_STRING;
			String[] s;
			Date date = null;
			Product tempProduct = null;

			while ((sCurrentLine = br.readLine()) != null) {
				if (!sCurrentLine.equals(PRODUCT_SEPARATOR)) {
					sLine = sLine + sCurrentLine;
				} else {
					tempProduct = new Product();
					s = sLine.split(COLUMN_SEPARATOR);
					if (s[PRODUCT_NAME].equals(name)) {
						tempProduct.setName(s[PRODUCT_NAME]);
						tempProduct.setCode(Integer.valueOf(s[PRODUCT_CODE]));
						date = (Date) sdf.parse(s[PRODUCT_DATE]);
						tempProduct.setProductDate(date);
						tempProduct.setAnnotation(s[PRODUCT_ANNOTATION]);
						productList.getStock().add(tempProduct);
					}
					sLine = EMPTY_STRING;
				}

			}

		} catch (IOException | ParseException ex) {
			throw new DAOException("Failed in search by name.", ex);
		}
		return productList;

	}

	@Override
	public Stock showProductByCode(String path, Integer code) throws DAOException {
		Stock productList = new Stock();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String sCurrentLine;
			String sLine = EMPTY_STRING;
			String[] s;
			Date date = null;
			Product tempProduct = null;

			while ((sCurrentLine = br.readLine()) != null) {
				if (!sCurrentLine.equals(PRODUCT_SEPARATOR)) {
					sLine = sLine + sCurrentLine;
				} else {
					tempProduct = new Product();
					s = sLine.split(COLUMN_SEPARATOR);
					if (Integer.valueOf(s[PRODUCT_CODE]).equals(code)) {
						tempProduct.setName(s[PRODUCT_NAME]);
						tempProduct.setCode(Integer.valueOf(s[PRODUCT_CODE]));
						date = (Date) sdf.parse(s[PRODUCT_DATE]);

						tempProduct.setProductDate(date);
						tempProduct.setAnnotation(s[PRODUCT_ANNOTATION]);
						productList.getStock().add(tempProduct);
					}
					sLine = EMPTY_STRING;
				}

			}

		} catch (IOException | ParseException ex) {
			throw new DAOException("Failed in search by code.", ex);
		}
		return productList;

	}

	@Override
	public Stock showProductByAnnotation(String path, String annotation) throws DAOException {

		Stock productList = new Stock();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String sCurrentLine;
			String sLine = EMPTY_STRING;
			String[] s;
			Date date = null;
			Product tempProduct = null;

			while ((sCurrentLine = br.readLine()) != null) {
				if (!sCurrentLine.equals(PRODUCT_SEPARATOR)) {
					sLine = sLine + sCurrentLine;
				} else {
					tempProduct = new Product();
					s = sLine.split(COLUMN_SEPARATOR);
					if (s[PRODUCT_ANNOTATION].equals(annotation)) {
						tempProduct.setName(s[PRODUCT_NAME]);
						tempProduct.setCode(Integer.valueOf(s[PRODUCT_CODE]));
						date = (Date) sdf.parse(s[PRODUCT_DATE]);
						tempProduct.setProductDate(date);
						tempProduct.setAnnotation(s[PRODUCT_ANNOTATION]);
						productList.getStock().add(tempProduct);
					}
					sLine = EMPTY_STRING;
				}

			}

		} catch (IOException | ParseException ex) {
			throw new DAOException("Failed in search by annotation.", ex);
		}
		return productList;

	}

	@Override
	public Stock showProductByProductDate(String path, Date productDate) throws DAOException {

		Stock productList = new Stock();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String sCurrentLine;
			String sLine = EMPTY_STRING;
			String[] s;
			Date date = null;
			Product tempProduct = null;

			while ((sCurrentLine = br.readLine()) != null) {
				if (!sCurrentLine.equals(PRODUCT_SEPARATOR)) {
					sLine = sLine + sCurrentLine;
				} else {
					tempProduct = new Product();
					s = sLine.split(COLUMN_SEPARATOR);

					if ((sdf.parse(s[PRODUCT_DATE]).equals(productDate))) {
						tempProduct.setName(s[PRODUCT_NAME]);
						tempProduct.setCode(Integer.valueOf(s[PRODUCT_CODE]));
						date = (Date) sdf.parse(s[PRODUCT_DATE]);
						tempProduct.setProductDate(date);
						tempProduct.setAnnotation(s[PRODUCT_ANNOTATION]);
						productList.getStock().add(tempProduct);
					}
					sLine = EMPTY_STRING;
				}

			}

		} catch (IOException | ParseException ex) {
			throw new DAOException("Failed in search by productDate.", ex);
		}
		return productList;
	}

	@Override
	public Stock showProductByNameAndCode(String path, String name, Integer code) throws DAOException {

		Stock productList = new Stock();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String sCurrentLine;
			String sLine = EMPTY_STRING;
			String[] s;
			Date date = null;
			Product tempProduct = null;

			while ((sCurrentLine = br.readLine()) != null) {
				if (!sCurrentLine.equals(PRODUCT_SEPARATOR)) {
					sLine = sLine + sCurrentLine;
				} else {
					tempProduct = new Product();
					s = sLine.split(COLUMN_SEPARATOR);
					if ((Integer.valueOf(s[PRODUCT_CODE]).equals(code)) && (s[PRODUCT_NAME].equals(name))) {
						tempProduct.setName(s[PRODUCT_NAME]);
						tempProduct.setCode(Integer.valueOf(s[PRODUCT_CODE]));
						date = (Date) sdf.parse(s[PRODUCT_DATE]);

						tempProduct.setProductDate(date);
						tempProduct.setAnnotation(s[PRODUCT_ANNOTATION]);
						productList.getStock().add(tempProduct);
					}
					sLine = EMPTY_STRING;
				}

			}

		} catch (IOException | ParseException ex) {
			throw new DAOException("Failed in search by name and code.", ex);
		}
		return productList;

	}

	@Override
	public Stock getSortedDataFromFile(String path, Comparator<Product> comparator) throws DAOException {

		Stock productList = new Stock();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String sCurrentLine;
			String sLine = EMPTY_STRING;
			String[] s;
			Date date = null;
			Product tempProduct = null;

			while ((sCurrentLine = br.readLine()) != null) {
				if (!sCurrentLine.equals(PRODUCT_SEPARATOR)) {
					sLine = sLine + sCurrentLine;
				} else {
					tempProduct = new Product();
					s = sLine.split(COLUMN_SEPARATOR);
					tempProduct.setName(s[PRODUCT_NAME]);
					tempProduct.setCode(Integer.valueOf(s[PRODUCT_CODE]));
					date = (Date) sdf.parse(s[PRODUCT_DATE]);
					tempProduct.setProductDate(date);
					tempProduct.setAnnotation(s[PRODUCT_ANNOTATION]);
					sLine = EMPTY_STRING;
					productList.getStock().add(tempProduct);
				}

			}

			Collections.sort(productList.getStock(), comparator);

		} catch (IOException | ParseException ex) {
			throw new DAOException("Failed obtaining sorted data.", ex);
		}
		return productList;

	}

	@Override
	public Stock showProductByAnnotationContain(String path, String annotation) throws DAOException {
		Stock productList = new Stock();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String sCurrentLine;
			String sLine = EMPTY_STRING;
			String[] s;
			Date date = null;
			Product tempProduct = null;

			while ((sCurrentLine = br.readLine()) != null) {
				if (!sCurrentLine.equals(PRODUCT_SEPARATOR)) {
					sLine = sLine + sCurrentLine;
				} else {
					tempProduct = new Product();
					s = sLine.split(COLUMN_SEPARATOR);
					if (s[PRODUCT_ANNOTATION].contains(annotation)) {
						tempProduct.setName(s[PRODUCT_NAME]);
						tempProduct.setCode(Integer.valueOf(s[PRODUCT_CODE]));
						date = (Date) sdf.parse(s[PRODUCT_DATE]);
						tempProduct.setProductDate(date);
						tempProduct.setAnnotation(s[PRODUCT_ANNOTATION]);
						productList.getStock().add(tempProduct);
					}
					sLine = EMPTY_STRING;
				}

			}

		} catch (IOException | ParseException ex) {
			throw new DAOException("Failed in search with annotation contains.", ex);
		}
		return productList;

	}

	@Override
	public void addProduct(String path, String name, Integer code, Date productDate, String annotation)
			throws DAOException {

		try {
			StringBuffer strbuff = new StringBuffer();
			strbuff.append(name + COLUMN_SEPARATOR);
			strbuff.append(LINE_SEPARATOR);
			strbuff.append(code.intValue() + COLUMN_SEPARATOR);
			strbuff.append(LINE_SEPARATOR);
			strbuff.append(sdf.format(productDate) + COLUMN_SEPARATOR);
			strbuff.append(LINE_SEPARATOR);
			strbuff.append(annotation + COLUMN_SEPARATOR);
			strbuff.append(LINE_SEPARATOR);
			strbuff.append(PRODUCT_SEPARATOR);

			File file = new File(path);
			PrintWriter printWriter = new PrintWriter(new FileWriter(file, true));
			printWriter.println(strbuff);
			printWriter.close();

		} catch (IOException ex) {
			throw new DAOException("Failed in add Product.", ex);
		}

	}

}
