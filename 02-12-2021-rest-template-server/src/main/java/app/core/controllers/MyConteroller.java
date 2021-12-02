package app.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Person;

@RestController
@RequestMapping("/api")
public class MyConteroller {

	@GetMapping("/greet/{user}")
	public String greet(@PathVariable String user) {
		return "Hello " + user;
	}

	@GetMapping("/person")
	public Person getPerson() {
		int id = (int) (Math.random() * 9999999);
		return new Person(id, "Dan", 25);
	}
}
