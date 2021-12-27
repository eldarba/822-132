package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.Book;
import app.core.entities.BookStore;
import app.core.exceptions.BookStoreException;
import app.core.services.BookStoreService;

@RestController
@RequestMapping("/api/store") // http://localhost:8080/api/store
public class StoreController {

	@Autowired
	private BookStoreService bookStoreService;

	@PostMapping
	public int addStore(@RequestBody BookStore bookStore) {
		return bookStoreService.addStore(bookStore);
	}

	// http://localhost:8080/api/store/102
	@PostMapping("/{storeId}")
	public void addBooksToStore(@PathVariable int storeId, @RequestBody Book... books) {
		try {
			bookStoreService.addBooks(storeId, books);
		} catch (BookStoreException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("/{storeId}")
	public List<Book> getAllStoreBooks(int storeId) {
		try {
			return bookStoreService.getAllBooks(storeId);
		} catch (BookStoreException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

}
