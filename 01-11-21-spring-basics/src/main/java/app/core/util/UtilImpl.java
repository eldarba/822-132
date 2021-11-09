package app.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtilImpl implements Util {

	// fields here are injected helper classes:
	@Autowired // tell spring container to inject this type
	private Calculator calculator;
	@Autowired
	private Converter converter;

	@Override
	public int add(int a, int b) {
		// use the injected helpers to do the calculation
		return this.calculator.add(a, b);
	}

	@Override
	public double convertNisToDolar(double nis) {
		return this.converter.nisToDolar(nis);
	}

}
