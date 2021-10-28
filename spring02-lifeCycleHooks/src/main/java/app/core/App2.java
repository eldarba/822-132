package app.core;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class App2 {

	public static void main(String[] args) {
		System.out.println("starting container");
		// creating the context will cause container to call all beans construct methods
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App2.class);

		System.out.println("main thread is going to sleep for 10 seconds");
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// closing the context will cause container to call all beans destroy methods
		ctx.close();
		System.out.println("stop - container is closed");
	}

}
