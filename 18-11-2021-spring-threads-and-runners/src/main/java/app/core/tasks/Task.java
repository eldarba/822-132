package app.core.tasks;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

//@Component
public class Task extends Thread {

	@Override
	public void run() {
		System.out.println("======== task started");
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				break;
			}
			System.out.println(">>> from task");
		}
		System.out.println("======== task ended");
	}

	@PostConstruct
	public void init() {
		this.start();
	}

	@PreDestroy
	public void destory() {
		this.interrupt();
	}

}
