package app.core.service;

import org.springframework.stereotype.Component;

import app.core.aspects.annotations.MyLogAnnotation;

@Component
public class CalculatorBeanImpl implements CalculatorBean {

	@Override
	public String div(int a, int b) throws RuntimeException {
		return a + " / " + b + " = " + (a / b) + "[remainder: " + (a % b) + "]";
	}

	@Override
	@MyLogAnnotation(condition = true)
	public void greet() {
		System.out.println("Hello");
	}

}
