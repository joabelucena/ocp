package chapter9.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import lib.TextElements;

public class FileInteraction extends TextElements {
	
	/**
	 * Most of the methods presented in this classes, are static methods
	 * from java.nio.file.Files class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Path nio = Paths.get("./nio2");
		
		{
			try {
				System.out.println(Paths.get("./nio2/zebra/food.source").toRealPath());	// symbolic link that points to 'food.txt'
				System.out.println(Paths.get("./nio2/horse/food.txt").toRealPath());
				
				System.out.println(Paths.get(".").toRealPath());					// Shows current work directory
				
			} catch (IOException e) {
//				e.printStackTrace();
			}
			
		}
		
		separe();
		
		{
			/*
			 * boolean exists(Path path)
			 */
			System.out.println(Files.exists(nio));
			
		}
		
		separe();
		
		{
			/*
			 * boolean isSameFile(Path path1, Path path2) throws IOException
			 */
			try {
				System.out.println(Files.isSameFile(
						Paths.get("./nio2/zoo/zebra/food.source"),
						Paths.get("./nio2/zoo/horse/food.txt")));
			} catch (IOException e) {
//				e.printStackTrace();
			}
		}
		
		separe();
		
		{
			/*
			 * Path createDiirectory(Path path, FileAttribute<?>...attrs) throws IOException
			 * Path createDiirectories(Path path, FileAttribute<?>...attrs) throws IOException
			 */
			
			try {
				Files.createDirectory(Paths.get("./nio2/zoo"));
				Files.createDirectories(Paths.get("./nio2/zoo/bison/field/pasture"));
			} catch (IOException e) {
//				e.printStackTrace();
			}
		}
		
		separe();
		
		{
			/*
			 * Path copy(Path source, Path destination) throws IOException
			 */
			try {
				Files.copy(
						Paths.get("./nio2/zoo"),
						Paths.get("./nio2/zoo-backup"));
			} catch (IOException e) {
//				e.printStackTrace();
			}
		}
		
		separe();
		
		{
			/*
			 * long copy(InputStream is, Path path) throws IOException
			 * long copy(Path path, OutputStream out) throws IOException
			 */
			try (InputStream in = new FileInputStream("./nio2/zoo.txt");
					OutputStream out = new FileOutputStream("./nio2/zoo-backup.txt")) {
				
				Files.copy(Paths.get("./nio2/zoo.txt"), out);
//				Files.copy(in, Paths.get("./nio2/zoo-backup.txt"));
				
				
			} catch (IOException e) {
				System.out.println("bad");
				e.printStackTrace();
			}
		}
		
		separe();
		
		{
			/*
			 * Path move(Path source, target) throws IOException
			 */
			try {
//				Files.move(nio.resolve("horse"), nio.resolve("zoo/horse"));
				Files.move(nio.resolve("zebra"), nio.resolve("zoo/zebra"));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		separe();
		
		{
			/*
			 * void delete(Path path) throws IOException
			 * boolean deleteIfExists(Path path) throws IOException
			 */
			try {
				Files.delete(nio.resolve("zoo"));			// Not empty throw Exception
				System.out.println(Files.deleteIfExists(nio.resolve("zoo-backup")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		separe();
		
		{
			/*
			 *  BufferedReader newBufferedReader(Path path, Charset set) throws IOException
			 *  BufferedWriter newBufferedWriter(Path path, Charset set) throws IOException
			 */
			try(BufferedReader reader = Files.newBufferedReader(nio.resolve("zoo.txt"), Charset.defaultCharset());
					BufferedWriter writer = Files.newBufferedWriter(nio.resolve("zoo-backup.txt"), Charset.defaultCharset())) {
				String currentLine = null;
				
				// Reads file
				while((currentLine = reader.readLine()) != null) {
					
					// Prints file to user
					System.out.println(currentLine);
					
					/// Writes file in a new place
					writer.write(currentLine);
					writer.newLine();
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		separe();
		
		{
			/*
			 * List<String> readAllLines(Path path) throws IOException 
			 */
			
			try {
				List<String> file = Files.readAllLines(nio.resolve("zoo.txt"));
				
				for(String line : file)
					System.out.println(line);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
