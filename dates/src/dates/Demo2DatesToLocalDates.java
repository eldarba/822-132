package dates;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Demo2DatesToLocalDates {

	// java.util.Date to LocalDateTime
	public static LocalDateTime localDateTimeFromDate(Date date) {
		Instant instant = date.toInstant();
		ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
		LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
		return localDateTime;
	}

	// java.util.Date to LocalDateTime - Java 9
	public static LocalDateTime localDateTimeFromDateJava9(Date date) {
		LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		return localDateTime;
	}

	// java.util.Date to LocalDate - Java 9
	public static LocalDate localDateFromDateJava9(Date date) {
		LocalDate localDate = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
		return localDate;
	}

	// java.sql.Date to LocalDate
	public static LocalDate localDateFromSqlDate(java.sql.Date date) {
		return date.toLocalDate();
	}

	// java.util.Date to LocalDate via java.sql.Date
	public static LocalDate localDateFromDateViaSqlDate(Date date) {
		return new java.sql.Date(date.getTime()).toLocalDate();
	}

	public static LocalDate localDateFromSqlDate1(java.sql.Date date) {
		return date.toLocalDate();
	}

}
