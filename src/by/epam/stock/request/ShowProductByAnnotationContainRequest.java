package by.epam.stock.request;

public class ShowProductByAnnotationContainRequest extends Request {
	private String path;
	private String annotation;

	public ShowProductByAnnotationContainRequest() {

	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

}
