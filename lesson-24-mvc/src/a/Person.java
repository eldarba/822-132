package a;

public class Person {

	public void speak() {
		System.out.println("bla bla");
	}

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.speak();

		Person p2 = new Person() {
			@Override
			public void speak() {
				System.out.println("Bli Bli");
			}
		};
		p2.speak();

	}

}
