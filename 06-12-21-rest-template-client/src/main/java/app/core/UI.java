package app.core;

import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

import app.core.beans.Person;

public class UI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Add Person");
			String name;
			int age;
			System.out.print("enter name: ");
			name = sc.nextLine();
			System.out.print("enter age: ");
			age = Integer.parseInt(sc.nextLine());
			RestTemplate rt = new RestTemplate();
			String url = "http://localhost:8080/api/person";
			Person p = new Person(0, name, age);
			int id = rt.postForObject(url, p, Integer.class);
			p.setId(id);
			System.out.println("person added: " + p);
			System.out.print("enter x to quit: ");
			if (sc.nextLine().equals("x")) {
				break;
			}
		}
		sc.close();
		System.out.println("Bye");
	}

}
