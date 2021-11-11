package app.core;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Student;
import app.core.entities.Student.Gender;
import app.core.repositories.StudentRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		StudentRepository studentRepository = ctx.getBean(StudentRepository.class);

		{ // add student entities to the data storage
			studentRepository.save(new Student(0, "Ran", 25, "ran@mail", Gender.M, LocalDate.of(2020, 1, 25), true));
			studentRepository
					.save(new Student(0, "Danna", 23, "danna@mail", Gender.F, LocalDate.of(2015, 5, 10), true));
			studentRepository
					.save(new Student(0, "Ronen", 30, "ronen@mail", Gender.M, LocalDate.of(2020, 8, 1), false));
			studentRepository.save(new Student(0, "Ran", 19, "ran@mail", Gender.M, LocalDate.of(2015, 1, 25), true));
			studentRepository
					.save(new Student(0, "aaaZiv", 20, "ziv@mail", Gender.M, LocalDate.of(2012, 1, 25), false));
			studentRepository.save(new Student(0, "aaaEti", 44, "eti@mail", Gender.F, LocalDate.of(2012, 5, 12), true));
			studentRepository.save(new Student(0, "Ran", 30, "ran@mail", Gender.M, LocalDate.of(2010, 1, 25), false));
		}

//		{ // get all students
//			List<Student> list = studentRepository.findAll();
////			List<Student> list = studentRepository.findAll(Sort.by("gender", "name"));
////			List<Student> list = studentRepository.findAll(Sort.by(Direction.DESC, "enrolled"));
//			print(list);
//		}

		{
			List<Student> list = studentRepository.findByNameStartingWith("aaa");
			print(list);

		}
//		{
//			List<Student> list = studentRepository.findByActiveFalse();
//			print(list);
//			
//		}

//		{
//			String name = "Ran";
//			List<Student> list = studentRepository.findByName(name);
//			print(list);
//			System.out.println(studentRepository.countByName(name));
//		}
//		{
//			List<Student> list = studentRepository.getFemales();
//			print(list);
//		}
//		{
//			List<Student> list = studentRepository.getMales();
//			print(list);
//		}
//
//		{
//			List<String> list = studentRepository.getNames();
//			print(list);
//		}
//		{
//			List<Student> list = studentRepository.getOlderThan(29);
//			print(list);
//		}

	}

	public static <T> void print(Collection<T> col) {
		System.out.println("==================================");
		for (T curr : col) {
			System.out.println(curr);
		}
		System.out.println("==================================");
	}

}
