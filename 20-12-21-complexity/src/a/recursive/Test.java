package a.recursive;

public class Test {

	public static void main(String[] args) {
		Matrioshka m = new Matrioshka(new Matrioshka(new Matrioshka(null)));

		System.out.println(m.getInnerMatrioshka());
		System.out.println(m.getInnerMatrioshka().getInnerMatrioshka());
		System.out.println(m.getInnerMatrioshka().getInnerMatrioshka().getInnerMatrioshka());

		System.out.println(m.getSize());

	}

}
