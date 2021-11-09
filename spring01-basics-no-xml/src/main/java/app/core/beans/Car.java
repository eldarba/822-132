package app.core.beans;

import org.springframework.stereotype.Component;

@Component
public class Car {

	private int number;
	private int speed;

	{
		System.out.println("Car created");
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Car [number=" + number + ", speed=" + speed + "]";
	}

}
