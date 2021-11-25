package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.Person;
import app.core.exceptions.PersonAppException;
import app.core.services.PersonService;

@RestController
@RequestMapping("/crud/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	// the user sends the person as JSON:
	// {"id": 205, "name": "Ruth", "age": 25}
	// spring will convert the JSON to Person object
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public int addPerson(@RequestBody Person person) {
		System.out.println(person);
		return this.personService.add(person);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Person> getAll() {
		return this.personService.getAll();
	}

	// http://localhost:8080/crud/person/101
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getPerson(@PathVariable(name = "id") int personId) {
		try {
			Person person = this.personService.get(personId);
			ResponseEntity<Person> resp = new ResponseEntity<>(person, HttpStatus.OK);
			return resp;
		} catch (PersonAppException e) {
			ResponseEntity<String> resp = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			return resp;
		}
	}

	@PutMapping
	public ResponseEntity<String> updatePerson(@RequestBody Person person) {
		try {
			this.personService.update(person);
			return new ResponseEntity<String>("updated", HttpStatus.OK);
		} catch (PersonAppException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping
	public void deletePerson(@RequestParam(name = "id") int personId) {
		try {
			this.personService.delete(personId);
		} catch (PersonAppException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "delete failed: " + e.getMessage(), e);
		}
	}

	// homework
	// map all service methods to this controller
	// HTTP method
	// create - http POST
	// read - http GET
	// update - http PUT
	// delete - http DELETE

}
