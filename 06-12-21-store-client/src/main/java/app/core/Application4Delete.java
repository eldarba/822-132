package app.core;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class Application4Delete {

	public static void main(String[] args) {
		System.out.println("========= rest template =====================");
		RestTemplate rt = new RestTemplate();

		int bookstoreId = 1;
		String url = "http://localhost:8080/api/store/" + bookstoreId;
		try {
			rt.delete(url);
			System.out.println("book store deleted: " + bookstoreId);
		} catch (HttpClientErrorException e) {
			System.err.println(e.getStatusCode());
			System.err.println(e.getMessage());
		}
		System.out.println("========= ============= =====================");
	}

}
