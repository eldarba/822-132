package app.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Person;
import app.core.exceptions.PersonAppException;
import app.core.repositories.PersonRepository;

@Service
@Transactional
public class PersonService {

	private PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	public int add(Person person) {
		this.personRepository.save(person);
		return person.getId();
	}

	public Person get(int personId) throws PersonAppException {
		Optional<Person> opt = this.personRepository.findById(personId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new PersonAppException("get person with id " + personId + " failed: NOT FOUND");
		}
	}

	public List<Person> getAll() {
		return this.personRepository.findAll();
	}

	public void update(Person person) throws PersonAppException {

		try {
			Person personFromDb = get(person.getId());
			personFromDb.setName(person.getName());
			personFromDb.setAge(person.getAge());
		} catch (PersonAppException e) {
			throw new PersonAppException("update failed", e);
		}
	}

	public void delete(int personId) throws PersonAppException {

		try {
			Person p = get(personId);
			this.personRepository.deleteById(personId);
		} catch (PersonAppException e) {
			throw new PersonAppException("delete failed", e);
		}
	}

	public void deleteAll() {
		this.personRepository.deleteAll();
	}

}
