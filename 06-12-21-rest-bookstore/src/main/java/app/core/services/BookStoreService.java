package app.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Book;
import app.core.entities.BookStore;
import app.core.exceptions.BookStoreException;
import app.core.repositories.BookRepository;
import app.core.repositories.BookStoreRepository;

@Service
@Transactional(rollbackFor = BookStoreException.class)
public class BookStoreService {

	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private BookStoreRepository storeRepo;

	// add store with books
	public int addStore(BookStore bookStore) {
		return this.storeRepo.save(bookStore).getId();
	}

	// add books to existing store
	public void addBooks(int storeId, Book... books) throws BookStoreException {
		if (this.storeRepo.existsById(storeId)) {
			BookStore store = this.storeRepo.findById(storeId).get();
			store.add(books);
		} else {
			throw new BookStoreException("addBooks to store failed - store " + storeId + " not found.");
		}
	}

	// get all books of a store
	public List<Book> getAllBooks(int storeId) throws BookStoreException {
		if (this.storeRepo.existsById(storeId)) {
			return this.bookRepo.findByBookStoreId(storeId);
		} else {
			throw new BookStoreException("getAllBooks of store failed - store " + storeId + " not found.");
		}
	}

	/**
	 * delete the book with the specified id
	 * 
	 * @param bookId
	 * @throws BookStoreException if the book id specified not found
	 */
	public void deleteBook(int bookId) throws BookStoreException {
		try {
			this.bookRepo.deleteById(bookId);
		} catch (Exception e) {
			throw new BookStoreException("deleteBook failed - " + e.getMessage(), e);
		}
	}

	// delete store
	public void deleteStore(int storeId) throws BookStoreException {
		try {
			this.storeRepo.deleteById(storeId);
		} catch (Exception e) {
			throw new BookStoreException("deleteStore failed - " + e.getMessage(), e);
		}
	}

	// update an existing book
	public void updateBook(Book book) throws BookStoreException {
		Optional<Book> opt = bookRepo.findById(book.getId());
		if (opt.isPresent()) {
			Book bookFromDb = opt.get();
			bookFromDb.setAuthor(book.getAuthor());
			bookFromDb.setPrice(book.getPrice());
			bookFromDb.setPublication(book.getPublication());
			bookFromDb.setTitle(book.getTitle());
		} else {
			throw new BookStoreException("updateBook failed - " + book + " not found.");
		}
	}

//	public void updateBook(Book book) throws BookStoreException {
//		if (this.bookRepo.existsById(book.getId())) {
//			Book bookFromDb = this.bookRepo.findById(book.getId()).get();
//			book.setBookStore(bookFromDb.getBookStore());
//			this.bookRepo.save(book);
//		} else {
//			throw new BookStoreException("updateBook failed - " + book + " not found.");
//		}
//	}

}
