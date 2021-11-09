package d.functional.interfaces;

import java.util.function.Consumer;

public class Demo6Consumer {

	public static void main(String[] args) {

		Consumer<Integer> intConsumer = num -> {
			System.out.println("the number is: " + num);
		};

		intConsumer.accept(7);

		Consumer<Rectangle> rectangleConsumer = rectangle -> {
			int area = rectangle.getLength() * rectangle.getWidth();
			String msg = "the rectangle area is " + area;
			System.out.println(msg);
		};

		Rectangle r1 = new Rectangle(5, 9);
		Rectangle r2 = new Rectangle(10, 3);

		rectangleConsumer.accept(r1);
		rectangleConsumer.accept(r2);

	}

}

class Rectangle {
	private int length;
	private int width;

	public Rectangle(int length, int width) {
		super();
		this.length = length;
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
