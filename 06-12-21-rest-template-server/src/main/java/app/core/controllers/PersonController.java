package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.Person;
import app.core.services.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping
	public int create(@RequestBody Person person) {
		return personService.create(person);
	}

	@GetMapping("/{personId}")
	public Person read(@PathVariable int personId) {
		try {
			return personService.read(personId);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "person id " + personId + " not found", e);
		}
	}

	@GetMapping
	public List<Person> readAll() {
		return personService.readAll();
	}

	@PutMapping
	public void update(@RequestBody Person person) {
		try {
			personService.update(person);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "person " + person + " not found", e);
		}

	}

	@DeleteMapping("/{personId}")
	public void delete(@PathVariable int personId) {
		try {
			personService.delete(personId);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "person id " + personId + " not found", e);
		}
	}

	@DeleteMapping("/{personId}/get")
	public Person deleteAndGet(@PathVariable int personId) {
		try {
			Person p = personService.read(personId);
			personService.delete(personId);
			return p;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "person id " + personId + " not found", e);
		}
	}

}
