package app.core;

import java.util.Set;
import java.util.TreeSet;

public class ReminderSystem {

	private Set<Reminder> reminders = new TreeSet<Reminder>();
	private ReminderTask reminderTask = new ReminderTask(this.reminders);

	public boolean addReminder(Reminder reminder) {
		if (!reminder.isExpired()) {
			return this.reminders.add(reminder);
		} else {
			return false;
		}
	}

	public Set<Reminder> getReminders() {
		return reminders;
	}

	public void showMenu() {
		System.out.println();
		System.out.println("= Reminder System Menu ===================");
		System.out.println("add reminder ............. 1 / add");
		System.out.println("show reminders ........... 2 / show");
		System.out.println("quit ..................... q");
		System.out.println("= ==================== ===================");
		System.out.print("enter choice: ");
	}

	public void start() {
		this.reminderTask.start();
	}

	public void stop() {
		this.reminderTask.stop();
	}

}
