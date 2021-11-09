package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import app.core.beans.Car;
import app.core.beans.Ship;

@ComponentScan
public class App3 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App3.class)) {
			Car c1 = ctx.getBean("car", Car.class);
			Car c2 = ctx.getBean("car", Car.class);
			c1.start();
			c2.start();

			Ship s1 = ctx.getBean(Ship.class);
			s1.start();
			s1.turnOff();
		}

	}

}
