package app.core;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import app.core.beans.Person;

public class Application {

	public static void main(String[] args) {

		// rest template is used to act as client to REST API from java code
		RestTemplate rt = new RestTemplate();

		// CREATE
		// we, as client, want to create a resource on the server
//		{
//			String url = "http://localhost:8080/api/person";
//			Person p = new Person(0, "Moshe", 35);
//			int id = rt.postForObject(url, p, Integer.class);
//			p.setId(id);
//			System.out.println(p);
//		}

		// READ
		// we, as client, want to get a resource from the server
//		{
//			String url = "http://localhost:8080/api/person/5";
//			Person p = rt.getForObject(url, Person.class);
//			System.out.println("found" + p);
//		}

		// READ all
		// we, as client, want to get all resources of a type from the server
//		{
//			String url = "http://localhost:8080/api/person";
//			Person[] arr = rt.getForObject(url, Person[].class);
//			List<Person> list = new ArrayList<>(Arrays.asList(arr));
//			System.out.println("found" + list);
//		}

		// UPDATE
		// we, as client, want to update a resource on the server
//		{
//			String url = "http://localhost:8080/api/person";
//			Person p = new Person(5, "Moshe", 30);
//			rt.put(url, p);
//			System.out.println("updated");
//		}

		// DELETE
		// we, as client, want to delete a resource from the server
//		{
//			String url = "http://localhost:8080/api/person/3";
//			rt.delete(url);
//			System.out.println("deleted");
//		}

		// DELETE and get the deleted resource using exchange method
		// we, as client, want to delete a resource from the server and get it
//		{
//			String url = "http://localhost:8080/api/person/4/get";
//			RequestEntity<Integer> request;
//			try {
//				request = new RequestEntity<>(HttpMethod.DELETE, new URI(url));
//				Person p = rt.exchange(request, Person.class).getBody();
//				System.out.println(p + " deleted");
//			} catch (URISyntaxException e) {
//				e.printStackTrace();
//			}
//		}

	}

}
