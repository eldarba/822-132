package app.core.beans;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "books")
public class BookStore {

	private int id;
	private String name;
	private String address;
	private List<Book> books;

	// add books to this store
	public void add(Book... books) {
		if (this.books == null) {
			this.books = new ArrayList<>();
		}
		for (Book b : books) {
			b.setBookStore(this);
			this.books.add(b);
		}
	}

	public void setBooks(List<Book> books) {
		for (Book book : books) {
			book.setBookStore(this);

		}
		this.books = books;
	}

}
