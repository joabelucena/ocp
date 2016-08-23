package chapter6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static lib.TextElements.separe;

public class MultiCatch {

	public static void main(String[] args) {
		
		{
			try {
				Path path = Paths.get("dolphin");
				String text = new String(Files.readAllBytes(path));
				LocalDate date = LocalDate.parse(text);
				System.out.println(date);
			
			} catch (DateTimeParseException e) {
				e.printStackTrace();				// DUPLICATE CODE
				throw new RuntimeException(e);
				
			} catch (IOException e) {
				e.printStackTrace();				// DUPLICATE CODE
				throw new RuntimeException(e);
			}
		}

		separe();
		
		{
			try {
				Path path = Paths.get("dolphin");
				String text = new String(Files.readAllBytes(path));
				LocalDate date = LocalDate.parse(text);
				System.out.println(date);
			
			} catch (Exception e) {					// BAD approach
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		separe();
		
		{
			try {
				Path path = Paths.get("dolphin");
				String text = new String(Files.readAllBytes(path));
				LocalDate date = LocalDate.parse(text);
				System.out.println(date);
			
			} catch (DateTimeParseException e) {
				handleException(e);					// BETTER, BUT STILL DUPLICATE
				
			} catch (IOException e) {
				handleException(e);					// BETTER, BUT STILL DUPLICATE
			}
		}
		
		separe();
		
		{
			/*
			 * Multi-Catch solution
			 */
			try {
				Path path = Paths.get("dolphin");
				String text = new String(Files.readAllBytes(path));
				LocalDate date = LocalDate.parse(text);
				System.out.println(date);
			
			} catch (DateTimeParseException | IOException e) {
				e.printStackTrace();				// Best approach
				throw new RuntimeException(e);
				
			}
		}

	}
	
	private static void handleException(Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}

}
