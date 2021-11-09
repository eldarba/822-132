package app.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Run {

	private static ReminderSystem reminderSystem = new ReminderSystem();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {

		boolean quit = false;
		reminderSystem.start();
		TimeUnit.SECONDS.sleep(1);

		while (!quit) {
			try {
				reminderSystem.showMenu();
				String command = sc.nextLine();
				switch (command) {
				case "add":
				case "1": {
					doAdd();
				}
					break;
				case "show":
				case "2": {
					doShow();
				}
					break;
				case "q": {
					quit = true;
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + command);
				}
			} catch (Exception e) {
				System.out.println("ERROR: " + e.getMessage());
			}
		}

		reminderSystem.stop();
		sc.close();

	}

	private static void doShow() {
		System.out.println("== All Reminders =================");
		for (Reminder reminder : reminderSystem.getReminders()) {
			System.out.println(reminder);
		}
		System.out.println("== ============= =================");

	}

	private static void doAdd() {

		System.out.print("enter reminder date [yyyy-mm-dd]: ");
		LocalDate localDate = LocalDate.parse(sc.nextLine());
		System.out.print("enter reminder time [hh:mm:ss]: ");
		LocalTime localTime = LocalTime.parse(sc.nextLine());
		LocalDateTime expiration = LocalDateTime.of(localDate, localTime);

		System.out.print("enter reminder text: ");
		String text = sc.nextLine();

		System.out.println("is reminder important? y / n");
		boolean important = sc.nextLine().equals("y") ? true : false;

		Reminder reminder = new Reminder(expiration, text, important);

		if (reminderSystem.addReminder(reminder)) {
			System.out.println("reminder added: " + reminder);
		} else {
			System.out.println("reminder NOT added");
		}

	}

}
