package chapter9;

import java.nio.file.Path;
import java.nio.file.Paths;

import lib.TextElements;

public class TestClass extends TextElements {

	public static void main(String[] args) throws Exception {
		
		{
			Path path1 = Paths.get("/home/joabe/Documents/workspace/ocp/io/zoo.txt");
			
			Path path2 = Paths.get("/","home","joabe","Documents","workspace","ocp","io","zoo.txt");
			
			System.out.println(path1.equals(path2));		// true
			
		}
		
	}

}
