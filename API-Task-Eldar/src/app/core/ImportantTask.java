package app.core;

import java.util.concurrent.TimeUnit;

public class ImportantTask implements Runnable {

	private Reminder reminder;
	private Thread thread;

	public ImportantTask(Reminder reminder) {
		super();
		this.reminder = reminder;
	}

	public void start() {
		this.thread = new Thread(this);
		this.thread.setDaemon(true);
		this.thread.start();
	}

	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			try {
				TimeUnit.MINUTES.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("IMPORTANT ALERT #" + i + ": " + reminder);
		}

	}

}
