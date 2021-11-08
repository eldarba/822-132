package app.core.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.dao.PersonDao;
import app.core.entities.Person;

@Service
@Transactional
public class PersonFacade {

	@Autowired
	private PersonDao personDao;

	public int add(Person person) {
		return personDao.create(person);
	}

	public Person find(int personId) {
		return this.personDao.read(personId);
	}

	public List<Person> readAll() {
		return this.personDao.readAll();
	}

}
