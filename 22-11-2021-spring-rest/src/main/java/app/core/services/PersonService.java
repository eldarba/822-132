package app.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Person;
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

	public Person get(int personId) {
		Optional<Person> opt = this.personRepository.findById(personId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public List<Person> getAll() {
		return this.personRepository.findAll();
	}

	public boolean update(Person person) {
		Person personFromDb = get(person.getId());
		if (personFromDb != null) {
			personFromDb.setName(person.getName());
			personFromDb.setAge(person.getAge());
			return true;
		}
		return false;
	}

	public void delete(int personId) {
		this.personRepository.deleteById(personId);

	}

}
