package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.dao.PersonDao;
import app.core.entities.Person;

@SpringBootApplication
public class Application2Dao {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application2Dao.class, args);

		PersonDao personDao = ctx.getBean(PersonDao.class);

		{ // add persons to the database using the Dao
			personDao.create(new Person(0, "aaa", 22));
			personDao.create(new Person(0, "bbb", 33));
			personDao.create(new Person(0, "ccc", 44));
		}

//		{ // find all persons in the database
//			List<Person> list = personDao.readAll();
//			System.out.println("==================");
//			for (Person person : list) {
//				System.out.println(person);
//			}
//			System.out.println("==================");
//		}

	}

}
