package a;

public class Demo {

	// nested class is inside another class
	class MyLocalClass {

	}

	public static void main(String[] args) {

		// local class is inside block of methods, loops, if, etc.
		class MyLocalClass {

		}

		// anonymous inner class is like local class but without name declaration
		Executor x1 = new Executor() {

			// this is an undeclared class

			@Override
			public void execute() {
				System.out.println("Executor implemented by anonymous inner type");

			}

			@Override
			public void doMore() {
				System.out.println("doing more");

			}
		};

//		Executor x2 = () -> {
//			System.out.println("Executor implemented by lambda expression");
//		};

		// implement using lambda expression
		Mover mover = () -> {
			System.out.println("moving");
		};

		x1.execute();
		mover.move();

	}

}

@FunctionalInterface
interface Mover {
	void move();
}

interface Executor {

	void execute();

	void doMore();

}