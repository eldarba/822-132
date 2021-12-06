package app.core;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import app.core.beans.Person;
import app.core.beans.PersonWrapper;

public class Demo4getAll {

	public static void main(String[] args) throws RestClientException, URISyntaxException {

		String baseUri = "http://localhost:8080/api";
		String path;
		RestTemplate rt = new RestTemplate();

		path = baseUri + "/all";

		{ // get all as JSON
			ResponseEntity<String> resp = rt.getForEntity(path, String.class);
			String allAsJson = resp.getBody();
			System.out.println(allAsJson);
		}

		{ // 1. get all as Student[]
			ResponseEntity<Person[]> resp = rt.getForEntity(path, Person[].class);
			Person[] arr = resp.getBody();
			System.out.println(Arrays.toString(arr));
			// convert the array to list
			List<Person> list = new ArrayList<>(Arrays.asList(arr));
			System.out.println(list);
		}

		{ // 2. get all as List<Student>
			ParameterizedTypeReference<List<Person>> listOfStudent = new ParameterizedTypeReference<>() {
			};

			ResponseEntity<List<Person>> resp = rt.exchange(path, HttpMethod.GET, null, listOfStudent);
			List<Person> list = resp.getBody();
			System.out.println(list);
		}

		{ // post 3 persons
			Person p1 = new Person(101, "aaa", 11);
			Person p2 = new Person(102, "bbb", 22);
			Person p3 = new Person(103, "ccc", 33);

			Person p;
			p = rt.postForObject(baseUri + "/person", p1, Person.class);
			System.out.println(p);
			p = rt.postForObject(baseUri + "/person", p2, Person.class);
			System.out.println(p);
			p = rt.postForObject(baseUri + "/person", p3, Person.class);
			System.out.println(p);

			System.out.println("added");
		}

//		{ // 3. get all using wrapper
//			ResponseEntity<PersonWrapper> resp = rt.getForEntity(path, PersonWrapper.class);
//			PersonWrapper wrapper = resp.getBody();
//			List<Person> list = wrapper.getList();
//			System.out.println(list);
//		}

	}

}
