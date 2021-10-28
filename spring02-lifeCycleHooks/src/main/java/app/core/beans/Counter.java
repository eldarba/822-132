package app.core.beans;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component("my-counter")
public class Counter implements Runnable, BeanNameAware {

	private Thread thread = new Thread(this);
	private String beanName;

	@Override
	public void run() {
		for (int c = 1;; c++) {
			System.out.println(c++ + ": " + beanName);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

	@PostConstruct
	public void startMyCounter() {
		thread.start();
	}

	@PreDestroy
	public void stopMyThread() {
		thread.interrupt();
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;

	}
}
