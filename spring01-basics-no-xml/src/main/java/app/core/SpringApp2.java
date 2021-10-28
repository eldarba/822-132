package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import app.core.beans.Car;

@ComponentScan
public class SpringApp2 {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringApp2.class);

		Car c1 = ctx.getBean(Car.class);
		Car c2 = ctx.getBean(Car.class);

		ctx.close();

	}

}
