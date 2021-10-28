package app.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Ship {

	@Autowired
	@Qualifier("shipEngine")
	private Engine engine;

	public void start() {
		System.out.println("ship is starting");
		this.engine.start();
	}

	public void turnOff() {
		System.out.println("ship is turning off");
		this.engine.stop();
	}

}
