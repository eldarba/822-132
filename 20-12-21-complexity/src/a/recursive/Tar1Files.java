package a.recursive;

import java.io.File;

public class Tar1Files {

	public static void printContent(String path) {
		File f = new File(path);
		if (f.isFile()) {
			System.out.println("\t" + f);
		} else {
			System.out.println(f);
			File[] files = f.listFiles();
			for (File file : files) {
				printContent(file.getPath());
			}
		}
	}

	public static void main(String[] args) {
		printContent("C:/eldar/temp");
	}

}
