package app.core;

import javax.swing.JOptionPane;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.service.CalculatorBean;

public class App {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)) {

			CalculatorBean calc = ctx.getBean(CalculatorBean.class);
			int val = Integer.valueOf(JOptionPane.showInputDialog("enter divder"));
			String msg = calc.div(27, val);
			System.out.println(msg);
		} catch (ArithmeticException e) {
			System.out.println("App - Error: " + e);
		} catch (Exception e) {
			System.out.println("Some other error: " + e);
		}

	}

}
