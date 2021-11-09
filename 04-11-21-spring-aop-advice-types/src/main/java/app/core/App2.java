package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.service.CalculatorBean;

public class App2 {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)) {

			CalculatorBean calc = ctx.getBean(CalculatorBean.class);
			calc.greet();
		} catch (ArithmeticException e) {
			System.out.println("App - Error: " + e);
		} catch (Exception e) {
			System.out.println("Some other error: " + e);
		}

	}

}
