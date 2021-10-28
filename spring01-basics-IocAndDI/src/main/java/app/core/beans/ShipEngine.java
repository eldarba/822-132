package app.core.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ShipEngine implements Engine {
	private static long c = 1000001;
	private long number = c++;

	@Override
	public void start() {
		System.out.println("ship engine started #" + this.number);

	}

	@Override
	public void stop() {
		System.out.println("ship engine stopped #" + this.number);
	}

}
