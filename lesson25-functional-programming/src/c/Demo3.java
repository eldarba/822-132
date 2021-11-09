package c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Demo3 {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person(101, "eee", 22));
		list.add(new Person(105, "bbb", 11));
		list.add(new Person(102, "aaa", 55));
		list.add(new Person(104, "ddd", 33));
		list.add(new Person(103, "ccc", 44));

		print(list);
		// sort by id
		list.sort((p1, p2) -> p1.getId() - p2.getId());
		print(list);
		// sort by name
		list.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
		print(list);
		// sort by age (youngest to oldest)
		list.sort((p1, p2) -> p1.getAge() - p2.getAge());
		print(list);
		// sort by age (oldest to youngest)
		list.sort((p1, p2) -> p2.getAge() - p1.getAge());
		print(list);

	}

	private static void print(Collection<?> col) {
		System.out.println("==========");
		for (Object object : col) {
			System.out.println(object);
		}
		System.out.println("==========");
	}

}

class Person {
	private int id;
	private String name;
	private int age;

	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
