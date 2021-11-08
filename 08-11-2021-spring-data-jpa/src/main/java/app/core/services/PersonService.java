package app.core.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Person;
import app.core.repositories.PersonRepository;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepo; // spring JPA generates implementation for us

	public int add(Person person) {
		person = this.personRepo.save(person);
		return person.getId();
	}

	public Person find(int personId) throws Exception {
		Optional<Person> opt = this.personRepo.findById(personId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new Exception("person with id " + personId + " not found");
		}
	}

	public List<Person> readAll() {
		return this.personRepo.findAll();
	}

	public void update(Person person) throws Exception {
		Person personFromDb = find(person.getId());
		personFromDb.setAge(person.getAge());
		personFromDb.setName(person.getName());
	}

	public void delete(int personId) throws Exception {
		Person person = find(personId);
		this.personRepo.delete(person);
	}

}
