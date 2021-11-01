package app.core.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Converter {

	@Value("${rate.nis}")
	private double nisExchangeRate;
	@Value("${rate.dolar}")
	private double dolarExchangeRate;

	public double nisToDolar(double nis) {
		return nis * this.dolarExchangeRate;
	}

	public double dolarToNis(double dolar) {
		return dolar * this.nisExchangeRate;
	}

}
