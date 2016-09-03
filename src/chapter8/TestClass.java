package chapter8;

import static lib.TextElements.separe;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import lib.FilePath;

public class TestClass  {

	public static void main(String[] args) throws IOException {
		{
			System.out.println(System.getProperty("file.separator"));
			
			System.out.println(java.io.File.separator);
		}

		separe();

		{
			File file = new File(FilePath.SANDBOX_PATH);
			
			Console console = System.console();
			new BufferedReader(new BufferedReader(new FileReader("")));
			
		}
	}

}
