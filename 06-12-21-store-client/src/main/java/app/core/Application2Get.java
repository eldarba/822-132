package app.core;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import app.core.beans.Book;
import app.core.beans.BookWrapper;

public class Application2Get {

	public static void main(String[] args) {
		System.out.println("========= rest template =====================");
		RestTemplate rt = new RestTemplate();

		{ // get all books of a store - using wrapper
			int storeId = 1;
			String url = "http://localhost:8080/api/store/wraper/" + storeId;

			BookWrapper wrapper = rt.getForObject(url, BookWrapper.class);
			List<Book> books = wrapper.getBooks();
			System.out.println(books);
		}

		{ // get all books of a store
			int storeId = 1;

			// the url
			String url = "http://localhost:8080/api/store/" + storeId;

			// the response type - List<Book>
			ParameterizedTypeReference<List<Book>> type = new ParameterizedTypeReference<>() {
			};

			// get the response using exchange method
			ResponseEntity<List<Book>> resp = rt.exchange(url, HttpMethod.GET, null, type);

			List<Book> books = resp.getBody();

			System.out.println(books);
		}

		{ // get all books of a store - using array
			int storeId = 1;
			String url = "http://localhost:8080/api/store/" + storeId;
			Book[] arr = rt.getForObject(url, Book[].class);
			System.out.println(Arrays.toString(arr));

			// convert to list
			List<Book> list = Arrays.asList(arr);
			System.out.println(list);
		}
		System.out.println("========= ============= =====================");
	}

}
