package app.core.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.core.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	// derived methods - meaning of query derived from method name
	boolean existsByName(String name);

	List<Student> findByNameOrEnrolled(String name, LocalDate date);

	List<Student> findByNameAndEnrolled(String name, LocalDate date);

	List<Student> findByEnrolledAfter(LocalDate date);

	List<Student> findByAgeBetween(int min, int max);

	List<Student> findByNameStartingWith(String prefix);

	List<Student> findByActiveTrue();

	List<Student> findByActiveFalse();

	List<Student> findByName(String name);

	List<Student> findByNameEquals(String name);

	long countByName(String name);

//	List<Student> getByName(String name);
//
//	List<Student> queryByName(String name);
//
//	List<Student> readByName(String name);

	// JPQL - use entity name
	@Query("from talmid where gender='F'")
	List<Student> getFemales();

	@Query("select t.name from talmid t")
	List<String> getNames();

	// native SQL - use table name
	@Query(value = "select  * from students where gender='M'", nativeQuery = true)
	List<Student> getMales();

	@Query("from talmid where age > :minAge")
	List<Student> getOlderThan(int minAge);

}
