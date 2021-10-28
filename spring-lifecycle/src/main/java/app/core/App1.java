package app.core;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.MyBean;
import app.core.beans.Person;

public class App1 {

	public static void main(String[] args) {

		System.out.println("START: container will open");
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(Config.class);
		MyBean bean = ctx.getBean("myBean", MyBean.class);

		System.out.println("\nusing MyBean ===============================================");
		System.out.println(bean);

		Person p = ctx.getBean(Person.class);
		System.out.println(p.getBeanName()); // null
		System.out.println(bean.getBeanName());

		System.out.println("============================================================\n");

		System.out.println("container will close in 5 seconds");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ctx.close();
		System.out.println("END: container closed");

	}

}
