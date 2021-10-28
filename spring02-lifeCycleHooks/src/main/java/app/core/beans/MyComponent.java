package app.core.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {

	public MyComponent() {
		System.out.println(">>> from MyComponent CTOR");
	}

	// business methods

	public void sayHi() {
		System.out.println("Hi");
	}

	// life cycle hook methods

	// spring container call this method on bean creation
	@PostConstruct
	public void createBean() {
		System.out.println(">>> create bean actions");
	}

	// spring container call this method on bean destruction
	@PreDestroy
	public void destroyBean() {
		System.out.println(">>> destroy bean actions");
	}

}
