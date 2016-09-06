package chapter9;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import lib.TextElements;

public class TestClass extends TextElements {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		{
			Path path1 = Paths.get("/home/joabe/Documents/workspace/ocp/io/zoo.txt");
			
			Path path2 = Paths.get("/","home","joabe","Documents","workspace","ocp","io","zoo.txt");
			
			System.out.println(path1.equals(path2));		// true
			
		}
		
		separe();
		
		{
			Path a = Paths.get("nio2/tree/a");
			
			try {
				if(Files.isSameFile(a.resolve("zoo.txt"), a.resolve("a2/zoo.txt")))
					System.out.println("Same File");
				
				Files.copy(a.resolve("zoo.txt"), a.resolve("a2/zoo.txt"), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		separe();
		
		{
			Path path = Paths.get("/kang");
			
			if(Files.isDirectory(path) && Files.isSymbolicLink(path))
				Files.createDirectories(path.resolve("joey"));
				
		}
		
		separe();
		
		{
			Path path1 = Paths.get("/pets/../cat.txt");
			Path path2 = Paths.get("./dog.txt");
			
			System.out.println(path1.resolve(path2));
			System.out.println(path2.resolve(path1));
		}
		
		separe();
		
		{
			Path p1 = Paths.get("c:\\temp\\test1.txt");
			
			System.out.println(p1);
			System.out.println(p1.resolve("test2.txt"));
			System.out.println(p1.relativize(Paths.get("text2.txt")));
			
			Paths.get(new URI(")"));
		}
	}
}
