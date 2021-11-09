package app.core;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ReminderTask implements Runnable {

	private Set<Reminder> reminders;
	private Thread thread;

	public ReminderTask(Set<Reminder> reminders) {
		super();
		this.reminders = reminders;
	}

	public void start() {
		this.thread = new Thread(this, "ReminderTask");
		this.thread.start();
	}

	public void stop() {
		this.thread.interrupt();
	}

	@Override
	public void run() {

		System.out.println("----- ReminderTask started");

		while (true) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				break;
			}
//			System.out.println("----- ReminderTask performs check cycle");
			for (Reminder reminder : reminders) {
				if (reminder.isExpired() && !reminder.isPopped()) {
					reminder.setPopped(true);
					System.out.println("ALERT: " + reminder);
					if (reminder.isImportant()) {
						ImportantTask importantTask = new ImportantTask(reminder);
						importantTask.start();
					}
				}
			}
		}

		System.out.println("----- ReminderTask stopped");
	}

}
