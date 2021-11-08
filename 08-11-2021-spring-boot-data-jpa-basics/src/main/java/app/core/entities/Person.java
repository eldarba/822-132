package app.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
// JPA annotations
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;

	public static void main(String[] args) {
		Person p = new Person();
		Person p2 = new Person(101, "aaa", 55);
		System.out.println(p);
		System.out.println(p2);
	}

}
