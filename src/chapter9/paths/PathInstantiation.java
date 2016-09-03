package chapter9.paths;

import java.io.File;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;

import lib.TextElements;

public class PathInstantiation extends TextElements {

	public static void main(String[] args) throws Exception {
		
		{
			Path path1 = Paths.get("/home/joabe/Documents/workspace/ocp/io/zoo.txt");
			
			Path path2 = Paths.get("/","home","joabe","Documents","workspace","ocp","io","zoo.txt");
			
			System.out.println(path1.equals(path2));		// true
			
		}
		
		separe();
		
		{
			//The schema has at the end a double forward slash, eg: file://, http:// ftp://
			//The path must be absolute
			Path path1 = Paths.get(new URI("file:///io/zoo.txt"));
			
//			Path path4 = Paths.get(new URI("http://www.uol.com.br"));
			
//			Path path5 = Paths.get(new URI("ftp://username:password@ftp.the-ftp-server.com"));
//			
//			URI uri4 = path4.toUri();
			
			 // try to find provider
	        for (FileSystemProvider provider: FileSystemProvider.installedProviders()) {
	            System.out.println(provider.getScheme());;
	        }
			
			System.out.println("Path: " + path1);
		}
		
		separe();
		
		{
			Path path1 = FileSystems.getDefault().getPath("/","home","joabe","Documents","workspace","ocp","io","zoo.txt");
			
			
			//Get a remote FileSystem
//			FileSystem fileSystem = FileSystems.getFileSystem(new URI("http://www.uol.com.br"));
//			Path path = fileSystem.getPath("duck.txt");
			
			System.out.println(path1);
		}
		
		separe();
		
		{
			File file = new File("pandas/cuddly.png");
			Path path = file.toPath();
			
			File file2 = path.toFile();
			
			System.out.println(path);
			System.out.println(file2);
		}
		
		separe();
		
		{
			
		}
	}

}
