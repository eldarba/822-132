package app.core;

import java.time.LocalDate;

import org.springframework.web.client.RestTemplate;

import app.core.beans.Book;

public class Application2 {

	public static void main(String[] args) {
		System.out.println("========= rest template =====================");
		RestTemplate rt = new RestTemplate();
		int storeId = 1;
		String url = "http://localhost:8080/api/store/" + storeId;
		Book[] books = { new Book(0, "Alice in Wonderland", "Lewis Carol", 88, LocalDate.now(), null) };

		rt.postForObject(url, books, Void.class);
		System.out.println("added book for store " + storeId);
		System.out.println("========= ============= =====================");
	}

}
