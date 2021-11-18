package app.core.tasks;

import java.util.concurrent.TimeUnit;

import javax.annotation.PreDestroy;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class MyOtherTask {

	@Scheduled(timeUnit = TimeUnit.SECONDS, initialDelay = 2, fixedRate = 5)
	public void doTheTask() {
		System.out.println(">>> from other task");
	}

	@PreDestroy
	public void bye() {
		System.out.println(">>> other task says bye");
	}

}
