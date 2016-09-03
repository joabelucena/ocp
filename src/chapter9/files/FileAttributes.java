package chapter9.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

import lib.TextElements;

public class FileAttributes extends TextElements {

	/**
	 * Most of the methods presented in this classes, are static methods from
	 * java.nio.file.Files class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Path nio = Paths.get("./nio2");
		Path zoo = nio.resolve("zoo.txt");

		{
			/*
			 * boolean isDirectory(Path path)
			 * boolean isRegularFile(Path path)
			 * boolean isSymbolicLink(Path path)
			 */
			System.out.println(Files.isDirectory(nio));
			System.out.println(Files.isRegularFile(zoo));
			System.out.println(Files.isSymbolicLink(nio.resolve("zoo/zebra/food.source")));
			
			System.out.println(Files.isRegularFile(nio.resolve("zoo/zebra/food.source")));
		}
		
		separe();
		
		{
			/*
			 * boolean isHidden(Path path) throws IOException
			 */
			try {
				System.out.println(Files.isHidden(zoo));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		separe();
		
		{
			/*
			 * boolean isExecutable(Path path)
			 * boolean isReadable(Path path)
			 */
			System.out.println(Files.isExecutable(zoo));
			System.out.println(Files.isReadable(zoo));
		}
		
		separe();
		
		{
			/*
			 * long size(Path path) throws IOException
			 */
			try {
				System.out.println(Files.size(zoo));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		separe();
		
		{
			/*
			 * FileTime getLastModifiedTime(Path path) throws IOException
			 * Path setLastModifiedTime(Path path) throws IOException
			 */
			try {
				long currentTimeMillis = System.currentTimeMillis();
				
				System.out.println(Files.getLastModifiedTime(zoo).toMillis());
				
				Files.setLastModifiedTime(zoo, FileTime.fromMillis(currentTimeMillis));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		separe();
		
		{
			/*
			 * UserPrincipal getOwner(Path path) throws IOException
			 * Path setOwner(Path path, UserPrincipal user) throws IOException 
			 */
			try {
				UserPrincipal owner = Files.getOwner(zoo);
				
				System.out.println(Files.getOwner(zoo).getName());
				
				UserPrincipal user = zoo.getFileSystem()
						.getUserPrincipalLookupService()
						.lookupPrincipalByName("joabe");
				
				Files.setOwner(zoo, user);
				
				System.out.println(Files.getOwner(zoo).getName());
				
				// Put old owner back
				Files.setOwner(zoo, owner);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
