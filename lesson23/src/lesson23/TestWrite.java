package lesson23;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestWrite {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(10, 3);

		// save to file using IO
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file.obj"));) {
			out.writeObject(r1);
			System.out.println("saved");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
