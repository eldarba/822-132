package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Person;
import app.core.services.PersonService;

@RestController
@RequestMapping("/crud/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	// the user sends the person as JSON:
	// {"id": 205, "name": "Ruth", "age": 25}
	// spring will convert the JSON to Person object
	@PostMapping
	public int addPerson(@RequestBody Person person) {
		System.out.println(person);
		return this.personService.add(person);
	}

	// homework
	// map all service methods to this controller
	// HTTP method
	// create - http POST
	// read - http GET
	// update - http PUT
	// delete - http DELETE

}
