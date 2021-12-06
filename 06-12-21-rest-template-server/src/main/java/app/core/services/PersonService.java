package app.core.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Person;
import app.core.repos.PersonRepo;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepo personRepo;

	public int create(Person person) {
		person.setId(0);
		person = personRepo.save(person);
		return person.getId();
	}

	public Person read(int personId) {
		return personRepo.findById(personId).orElseThrow();
	}

	public List<Person> readAll() {
		return personRepo.findAll();
	}

	public void update(Person person) {
		Person personFronDb = read(person.getId());
		personFronDb.setAge(person.getAge());
		personFronDb.setName(person.getName());
	}

	public void delete(int personId) {
		personRepo.deleteById(personId);
	}

}
