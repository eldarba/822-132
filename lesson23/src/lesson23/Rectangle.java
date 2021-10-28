package lesson23;

import java.io.Serializable;

public class Rectangle implements Serializable {

	private static final long serialVersionUID = 2L;
	private int letngth;
	private int width;

	public Rectangle() {
	}

	public Rectangle(int letngth, int width) {
		super();
		this.letngth = letngth;
		this.width = width;
	}

	public Rectangle(int letngth, int width, String color) {
		super();
		this.letngth = letngth;
		this.width = width;
	}

	@Override
	public String toString() {
		return "Rectangle [letngth=" + letngth + ", width=" + width + "]";
	}

}
