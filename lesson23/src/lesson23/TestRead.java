package lesson23;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestRead {

	public static void main(String[] args) {

		// read from file using IO
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.obj"));) {
			Rectangle r = (Rectangle) in.readObject();
			System.out.println(r);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
