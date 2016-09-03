package chapter9.views;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import lib.TextElements;

public class BasicFileAttributesSample extends TextElements {

	public static void main(String[] args) throws IOException {

		Path nio = Paths.get("./nio2");
		Path zoo = nio.resolve("zoo.txt");
		
		BasicFileAttributes data = Files.readAttributes(zoo, BasicFileAttributes.class);
		
		System.out.println("File path: " + zoo.toAbsolutePath().normalize());
		
		separe();
		
		System.out.println("Is path a directory? " + getAns(data.isDirectory()));
		
		System.out.println("Is path a regular file? " + getAns(data.isRegularFile()));
		
		System.out.println("Is path a symbolic link? " + getAns(data.isSymbolicLink()));
		
		System.out.println("Path not a file, directoy, nor symbolic link? " + getAns(data.isOther()));
		
		System.out.println("Size (in Bytes): " + data.size());
		
		System.out.println("Creation date/time: " + data.creationTime());
		
		System.out.println("Last modified date/time: " + data.lastModifiedTime());
		
		System.out.println("Last accessed date/time: " + data.lastAccessTime());
		
		System.out.println("File ID (if available): " + data.fileKey());
		
	}
	
	private static String getAns(boolean bool) { return bool ? "Yes" : "No"; }

}
