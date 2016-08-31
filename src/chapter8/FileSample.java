package chapter8;

import java.io.File;

import lib.FilePath;

public class FileSample {

	public static void main(String[] args) {
		File file = new File(FilePath.PROJECT_PATH + "io/zoo.txt");
		System.out.println(file.exists());
		
		System.out.println(file.getAbsolutePath());

	}

}
