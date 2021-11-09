package dates;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Demo3LocalDatesToDates {

	public static void main(String[] args) {
		LocalDateTime localDateTime = LocalDateTime.of(2020, 1, 1, 20, 30, 30);
		Date date = dateFromLocalDateTime(localDateTime);
		System.out.println(date);

		LocalDate localDate = LocalDate.of(2020, 1, 1);
		date = dateFromLocalDate(localDate);
		System.out.println(date);
	}

	// LocalDateTime to java.util.Date
	public static Date dateFromLocalDateTime(LocalDateTime localDateTime) {
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
		Instant instant = zonedDateTime.toInstant();
		Date date = Date.from(instant);
		return date;
	}

	// LocalDate to java.sql.Date
	public static Date dateFromLocalDate(LocalDate localDate) {
		java.sql.Date date = java.sql.Date.valueOf(localDate);
		return date;
	}

}
