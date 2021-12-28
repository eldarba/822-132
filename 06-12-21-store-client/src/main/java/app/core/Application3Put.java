package app.core;

import java.time.LocalDate;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import app.core.beans.Book;

public class Application3Put {

	public static void main(String[] args) {
		System.out.println("========= rest template =====================");
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8080/api/store/";

		Book book = new Book(111, "newTitlte", "newAuthor", 200, LocalDate.of(1985, 01, 06), null);
		try {
			rt.put(url, book);
			System.out.println("updated");
			System.out.println(book);
		} catch (HttpClientErrorException e) {
			System.err.println(e.getStatusCode());
			System.err.println(e.getMessage());
		}
		System.out.println("========= ============= =====================");
	}

}
