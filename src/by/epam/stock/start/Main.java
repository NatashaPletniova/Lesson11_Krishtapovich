package by.epam.stock.start;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import by.epam.stock.bean.entity.Product;
import by.epam.stock.command.CommandName;
import by.epam.stock.controller.Controller;
import by.epam.stock.request.AddProductRequest;
import by.epam.stock.request.GetProductRequest;
import by.epam.stock.request.ShowSortedProductRequest;
import by.epam.stock.request.Response;
import by.epam.stock.request.ShowProductByAnnotationContainRequest;
import by.epam.stock.request.ShowProductByAnnotationRequest;
import by.epam.stock.request.ShowProductByCodeRequest;
import by.epam.stock.request.ShowProductByNameAndCodeRequest;
import by.epam.stock.request.ShowProductByNameRequest;
import by.epam.stock.request.ShowProductByProductDateRequest;
import by.epam.stock.util.comparator.ProductCodeComparator;
import by.epam.stock.util.comparator.ProductNameComparator;

public class Main {

	public static final String PATH = "D:\\NatashaPersonal\\JavaNata\\notes3.txt";
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd", Locale.US);

	public static void main(String[] args) {

		ProductNameComparator nameComparator = new ProductNameComparator();
		ProductCodeComparator codeComparator = new ProductCodeComparator();

		Date date = null;
		try {
			date = (Date) sdf.parse("2015 May 15");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Controller controller = new Controller();

		GetProductRequest request = new GetProductRequest();
		request.setCommandName(CommandName.GET_PRODUCT);
		request.setPath(PATH);

		Response response = controller.doAction(request);

		System.out.println("Все что есть в файле:");
		for (Product p : response.getProducts().getStock()) {
			System.out.println(p);
		}

		ShowSortedProductRequest request1 = new ShowSortedProductRequest();
		request1.setCommandName(CommandName.GET_SORTED_PRODUCT);
		request1.setPath(PATH);
		request1.setComparator(nameComparator);
		response = controller.doAction(request1);
		System.out.println("Все что есть в файле, отсортированное по наименованию:");
		for (Product p : response.getProducts().getStock()) {
			System.out.println("" + p);
		}

		request1.setComparator(codeComparator);
		response = controller.doAction(request1);
		System.out.println("Все что есть в файле, отсортированное по коду:");
		for (Product p : response.getProducts().getStock()) {
			System.out.println("" + p);
		}

		ShowProductByNameRequest request2 = new ShowProductByNameRequest();
		request2.setCommandName(CommandName.SHOW_PRODUCT_BY_NAME);
		request2.setPath(PATH);
		request2.setName("Стол");
		response = controller.doAction(request2);
		System.out.println("Все столы из файла:");
		for (Product p : response.getProducts().getStock()) {
			System.out.println("" + p);
		}

		ShowProductByCodeRequest request3 = new ShowProductByCodeRequest();
		request3.setCommandName(CommandName.SHOW_PRODUCT_BY_CODE);
		request3.setPath(PATH);
		request3.setCode(156);
		response = controller.doAction(request3);

		System.out.println("Все наименования с кодом 156:");
		for (Product p : response.getProducts().getStock()) {
			System.out.println("" + p);
		}

		ShowProductByAnnotationRequest request4 = new ShowProductByAnnotationRequest();
		request4.setCommandName(CommandName.SHOW_PRODUCT_BY_ANNOTATION);
		request4.setPath(PATH);
		request4.setAnnotation("Стол журнальный");
		response = controller.doAction(request4);
		System.out.println("Все столы журнальные из файла:");
		for (Product p : response.getProducts().getStock()) {
			System.out.println("" + p);
		}

		ShowProductByProductDateRequest request5 = new ShowProductByProductDateRequest();
		request5.setCommandName(CommandName.SHOW_PRODUCT_BY_PRODUCTDATE);
		request5.setPath(PATH);
		request5.setProductDate(date);
		;
		response = controller.doAction(request5);
		System.out.println("Все иделия, произведенные 2015 May 15:");
		for (Product p : response.getProducts().getStock()) {
			System.out.println("" + p);
		}

		ShowProductByNameAndCodeRequest request6 = new ShowProductByNameAndCodeRequest();
		request6.setCommandName(CommandName.SHOW_PRODUCT_BY_NAME_AND_CODE);
		request6.setPath(PATH);
		request6.setName("Стол");
		request6.setCode(156);
		System.out.println("Все столы с кодом 156:");
		response = controller.doAction(request6);
		for (Product p : response.getProducts().getStock()) {
			System.out.println("" + p);
		}

		ShowProductByAnnotationContainRequest request7 = new ShowProductByAnnotationContainRequest();
		request7.setCommandName(CommandName.SHOW_PRODUCT_BY_ANNOTATION_CONTAIN);
		request7.setPath(PATH);
		request7.setAnnotation("Стол");
		response = controller.doAction(request7);
		System.out.println("Все аннотации со словом стол:");
		for (Product p : response.getProducts().getStock()) {
			System.out.println("" + p);
		}

		AddProductRequest request8 = new AddProductRequest();
		request8.setCommandName(CommandName.ADD_PRODUCT);
		request8.setPath(PATH);
		request8.setName("Шкаф");
		request8.setCode(123);
		request8.setProductDate(date);
		request8.setAnnotation("Шкаф универсальный");

		response = controller.doAction(request8);

		AddProductRequest request9 = new AddProductRequest();
		request9.setCommandName(CommandName.ADD_PRODUCT);
		request9.setPath(PATH);
		request9.setName("Кресло");
		request9.setCode(193);
		try {
			request9.setProductDate((Date) sdf.parse("2017 Apr 10"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request9.setAnnotation("Кресло качалка");

		response = controller.doAction(request9);

		request.setCommandName(CommandName.GET_PRODUCT);
		request.setPath(PATH);
		response = controller.doAction(request);

		System.out.println("Все что есть в файле:");
		for (Product p : response.getProducts().getStock()) {
			System.out.println(p);
		}
	}
}
