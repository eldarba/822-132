package d.functional.interfaces;

import java.util.function.Supplier;

public class Demo5Supplier {

	public static void main(String[] args) {

		Supplier<Integer> rnd = () -> (int) (Math.random() * 101);

		System.out.println(rnd.get());
		System.out.println(rnd.get());
		System.out.println(rnd.get());
		System.out.println(rnd.get());
		System.out.println(rnd.get());

		Supplier<Person> prs = () -> {
			Person p = new Person();
			p.setId(-1);
			p.setAge((int) (Math.random() * 101));
			p.setName("aaa");
			return p;
		};

		Person p = prs.get();
		System.out.println(p);
	}

}

class Person {
	private int id;
	private String name;
	private int age;

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
