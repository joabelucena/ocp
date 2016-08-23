package chapter6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static lib.TextElements.separe;

public class TryWithResources {

	public static void main(String[] args) {
		
		{
			try(Scanner s = new Scanner(System.in)){
				s.nextLine();
			}							//Resource is gone here
			catch (Exception e) {
				s.next();				//DOES NOT COMPILE
			}
		}

		separe();
		
		
	}
	
	private static void oldApproach(Path path1, Path path2) throws IOException {
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = Files.newBufferedReader(path1);
			out = Files.newBufferedWriter(path2);
			out.write(in.readLine());
			
		} finally{
			if(in != null) in.close();
			if(out != null) out.close();
			
		}
	}
	
	/**
	 * Try-with-resources example
	 * 
	 * @param path1
	 * @param path2
	 * @throws IOException
	 */
	private static void newApproach(Path path1, Path path2) throws IOException {
		
		try(BufferedReader in = Files.newBufferedReader(path1);
				BufferedWriter out = Files.newBufferedWriter(path2)) {
			
			out.write(in.readLine());
			
		} finally {
			
		}
	}

}
