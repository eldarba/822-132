package d.functional.interfaces;

import java.util.function.Predicate;

public class Demo2Predicate {

	public static void main(String[] args) {

		Predicate<Integer> greaterThan100 = x -> x > 100;

		System.out.println(greaterThan100.test(500));
		System.out.println(greaterThan100.test(30));

		System.out.println("===================");
		// create a predicate that gets a Car objects and tests if it is over speeding
		// (120)
		// create Car class
		// add speed attribute
		// add get / set

		Car car1 = new Car(102, 2021, 100);
		Car car2 = new Car(200, 1980, 30);

		// the speedTest predicate:
		Predicate<Car> tester = car -> car.getSpeed() <= Car.MAX_SPEED;

		// the test:
		System.out.println(tester.test(car1));
		System.out.println(tester.test(car2));

		boolean isNumberEven = car1.testTheCar(car -> car.getNumber() % 2 == 0);
		System.out.println(car1 + ", is number even? " + isNumberEven);

	}

}

class Car {

	public static final int MAX_SPEED = 120;

	private int number;
	private int year;
	private int speed;

	public Car(int number, int year, int speed) {
		super();
		this.number = number;
		this.year = year;
		this.speed = speed;
	}

	// higher order method (can get lambda as an argument)
	public boolean testTheCar(Predicate<Car> predicate) {
		return predicate.test(this);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Car [number=" + number + ", year=" + year + ", speed=" + speed + "]";
	}

}
