package app.core.beans;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "bookStore")
public class Book {

	private int id;
	private String title;
	private String author;
	private double price;
	private LocalDate publication;
	private BookStore bookStore;

}
