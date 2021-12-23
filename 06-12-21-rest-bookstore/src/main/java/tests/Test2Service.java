package tests;

import org.springframework.boot.CommandLineRunner;

import app.core.entities.Book;
import app.core.exceptions.BookStoreException;
import app.core.services.BookStoreService;

public class Test2Service implements CommandLineRunner {

	private BookStoreService storeService;

	public Test2Service(BookStoreService storeService) {
		super();
		this.storeService = storeService;
	}

	@Override
	public void run(String... args) {
		System.out.println("=== test 2 service");
		try {
//			addBookToStore(21);
//			deleteBook(8);
			deleteStore(2);
		} catch (BookStoreException e) {
			// e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}

	public void addBookToStore(int storeId) throws BookStoreException {
		storeService.addBooks(storeId, new Book(0, "bbb", "aaa", 150, null, null));
		System.out.println("Books Added");
	}

	public void deleteBook(int bookId) throws BookStoreException {
		this.storeService.deleteBook(bookId);
		System.out.println("DELETED");
	}

	public void deleteStore(int storeId) throws BookStoreException {
		this.storeService.deleteStore(storeId);
		System.out.println("DELETED");
	}

}
