package a.recursive;

public class Matrioshka {

	private Matrioshka innerMatrioshka;

	public Matrioshka(Matrioshka innerMatrioshka) {
		super();
		this.innerMatrioshka = innerMatrioshka;
	}

	public int getSize() {
		if (this.getInnerMatrioshka() == null) {
			return 1;
		} else {
			return this.innerMatrioshka.getSize() + 1;
		}
	}

	public Matrioshka getInnerMatrioshka() {
		return innerMatrioshka;
	}

	public void setInnerMatrioshka(Matrioshka innerMatrioshka) {
		this.innerMatrioshka = innerMatrioshka;
	}

	@Override
	public String toString() {
		return "Matrioshka";
	}

}
