package app.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Car {

	private int number;
	private int speed;
	@Autowired
	private Engine engine;

	{
		System.out.println("Car created");
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void start() {
		System.out.println("car is starting");
		this.engine.start();
	}

	public void turnOff() {
		System.out.println("car is turning off");
		this.engine.stop();
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
