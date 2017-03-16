package by.epam.stock.request;

public class ShowProductByAnnotationRequest extends Request {
	private String path;
	private String annotation;

	public ShowProductByAnnotationRequest() {
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
