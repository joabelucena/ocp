package chapter9.paths;

import java.nio.file.Path;
import java.nio.file.Paths;

import lib.TextElements;

public class PathMethods extends TextElements {

	public static void main(String[] args) throws Exception {
		
		Path absolute = Paths.get("/zoo/cage/lion.txt");
		Path relative = Paths.get("cage/lion.txt");
		
		Path file = Paths.get("lion.txt");
		
		
		{
			/*
			 * String toString()
			 * int getNameCount()
			 * Path getName(int)
			 */
			System.out.println("The path is: " + absolute);
			miniSepare();
			for(int i = 0; i < absolute.getNameCount(); i++) {
				System.out.println("\t- Element " + i + " is: " + absolute.getName(i));
			}
		}
		
		separe();
		
		{
			/*
			 * Path getFileName()
			 * Path getParent()
			 * Path getRoot()
			 */
			printPathInformation(absolute);
			
			miniSepare();
			
			printPathInformation(relative);
			
		}
		
		separe();
		
		{
			/*
			 * boolean isAbsolute()
			 * Path toAbsolutePath()
			 */
			System.out.println("Path: " + absolute);
			System.out.println("Is absolute? " + absolute.isAbsolute());
			System.out.println("Absolute version: " + absolute.toAbsolutePath());
			
			miniSepare();
			
			System.out.println("Path: " + relative);
			System.out.println("Is absolute? " + relative.isAbsolute());
			System.out.println("Absolute version: " + relative.toAbsolutePath());
			
			
		}
		
		separe();
		
		{
			/*
			 * Path subPath(int beginIndex, int endIndex)
			 */
			System.out.println("The path is: " + absolute);
			miniSepare();
			
			System.out.println("Subpath from 0 to 3 is: " + absolute.subpath(0, 3));
			System.out.println("Subpath from 1 to 3 is: " + absolute.subpath(1, 3));
			System.out.println("Subpath from 1 to 2 is: " + absolute.subpath(1, 2));
			
		}
		
		separe();
		
		{
			/*
			 * Path relativize(Path other)
			 */
			Path path1 = Paths.get("fish.txt");
			Path path2 = Paths.get("birds.txt");
			
			System.out.println(path1.relativize(path2));		// relative always go to the parent
			System.out.println(path2.relativize(path1));		// relative always go to the parent
			
			Path path3 = Paths.get("/pirulito/habitat");
			Path path4 = Paths.get("/home/sancturay/raven");
			
			System.out.println(path3.relativize(path4));		// IamHere.relativize(WantToGetHere)
			System.out.println(path4.relativize(path3));		// IamHere.relativize(WantToGetHere)
			
		}
		
		separe();
		
		{
			/*
			 * Path resolve(Path path)
			 * Path resolve(String path)
			 */
			System.out.println(absolute.resolve(file));
			
			Path path1 = Paths.get("/turkey/food");
			Path path2 = Paths.get("/tiger/cage");
			
			System.out.println(path1.resolve(path2));	// Last path is returned
			
		}
		
		separe();
		
		{
			/*
			 * void normalize()
			 */
			Path path1 = Paths.get("/data");
			Path path2 = Paths.get("/user/home");
			
			Path relativePath = path1.relativize(path2);
			
			System.out.println(relativePath);
			
			System.out.println(path1.resolve(relativePath));
			
			Path normalizedPath = path1.resolve(relativePath).normalize();
			
			System.out.println(normalizedPath);
		}
		
	}
	
	public static void printPathInformation(Path path) {
		System.out.println("The path is: " + path);
		
		miniSepare();
		
		System.out.println("File name is: " + path.getFileName());
		System.out.println("Root is: " + path.getRoot());
		
		Path currentParent = path;
		
		while((currentParent = currentParent.getParent()) != null) {
			System.out.println("\t- Current parent is: " + currentParent);
		}
	}

}
