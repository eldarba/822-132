package app.core;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import app.core.beans.MyComponent;

@ComponentScan
public class App1 {

	public static void main(String[] args) {
		System.out.println("starting container");
		// creating the context will cause container to call all beans construct methods
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App1.class);

		MyComponent bean = ctx.getBean(MyComponent.class);
		bean.sayHi();

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// closing the context will cause container to call all beans destroy methods
		ctx.close();
		System.out.println("stop - container is closed");
	}

}
