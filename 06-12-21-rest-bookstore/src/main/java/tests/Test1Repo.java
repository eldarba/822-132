package tests;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;

import app.core.entities.Book;
import app.core.entities.BookStore;
import app.core.repositories.BookRepository;
import app.core.repositories.BookStoreRepository;

public class Test1Repo implements CommandLineRunner {

	private ApplicationContext ctx;

	public Test1Repo(ApplicationContext ctx) {
		super();
		this.ctx = ctx;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=== test 1");
//		addStoreWithBooks();
		getStoreWithBooks(2);
	}

	public void getStoreWithBooks(int storeId) {
		BookStoreRepository bookStoreRepository = ctx.getBean(BookStoreRepository.class);
		BookRepository bookRepository = ctx.getBean(BookRepository.class);

		BookStore bookStore = bookStoreRepository.findById(storeId).orElse(null);
		if (bookStore != null) {
			System.out.println(bookStore);
//			System.out.println(bookStore.getBooks());
			System.out.println(bookRepository.findByBookStoreId(storeId));
		} else {
			System.out.println("NOT FOUND");
		}
	}

	public void addStoreWithBooks() {
		BookStoreRepository bookStoreRepository = ctx.getBean(BookStoreRepository.class);

		Book book1 = new Book(0, "Java 1", "Dan", 500, LocalDate.of(2018, 1, 1), null);
		Book book2 = new Book(0, "HTML", "Dan", 400, LocalDate.of(2020, 1, 1), null);
//		Book book3 = new Book(0, "Spring 3", "Ruth", 200, LocalDate.of(2021, 1, 1), null);

		BookStore bookStore = new BookStore(0, "Sfarim TLV", "Tel Aviv", null);
//		bookStore.add(book1, book2, book3);
		bookStore.add(book1, book2);

		bookStoreRepository.save(bookStore);
		System.out.println("SAVED");

	}

}
