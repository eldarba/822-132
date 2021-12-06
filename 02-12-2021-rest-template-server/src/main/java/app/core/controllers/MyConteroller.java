package app.core.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Person;
import app.core.entities.PersonWrapper;

@RestController
@RequestMapping("/api")
public class MyConteroller {

	private int nextPersonId = 101;

	private List<Person> list = new ArrayList<>();

	@GetMapping("/greet/{user}")
	public String greet(@PathVariable String user) {
		return "Hello " + user;
	}

	@GetMapping("/person")
	public Person getPerson() {
		int id = (int) (Math.random() * 9999999);
		return new Person(id, "Dan", 25);
	}

	@GetMapping("/all")
	public List<Person> getAll() {
		return this.list;
	}

	@GetMapping("/all/wrapper")
	public PersonWrapper getAllWrapped() {
		PersonWrapper personWrapper = new PersonWrapper();
		personWrapper.setList(list);
		return personWrapper;
	}

	@PostMapping("/person")
	public Person addPerson(@RequestBody Person person) {
		person.setId(nextPersonId++);
		this.list.add(person);
		return person;
	}
}
