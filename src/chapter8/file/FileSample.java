package chapter8.file;

import java.io.File;

import lib.FilePath;

public class FileSample {

	public static void main(String[] args) {
		File file = new File(FilePath.SANDBOX_PATH + "zoo.txt");
		System.out.println(file.exists());
		
		System.out.println(file.getAbsolutePath());

	}

}
