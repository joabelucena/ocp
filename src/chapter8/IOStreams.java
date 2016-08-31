package chapter8;

import static lib.TextElements.miniSepare;
import static lib.TextElements.separe;

import java.io.*;
public class IOStreams {

	public static void main(String[] args) throws IOException {
		
		{
			/*
			 * Main abstract streams
			 */
			Reader reader = new FileReader("");
			Writer writer = new FileWriter("");
			
			InputStream inputStream = new FileInputStream("");
			OutputStream outputStream = new FileOutputStream("");
		}
		
		separe();
		
		{
			/*
			 * DOES NOT COMPILE ZONE
			 */
//			new BufferedInputStream(new FileReader(""));		// Mix InputStream and Reader
//			new BufferedWriter(new FileOutputStream(""));		// Mix Writer and OutputStream
//			new ObjectInputStream(new FileOutputStream(""));	// Mix InputStream and OutputStream
//			new BufferedInputStream(new InputStream());			// InputStream is an abstract class, can't be instanciated like that
		}
		
		miniSepare();
		
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(""));
			BufferedReader reader = new BufferedReader(new FileReader(""));
			
			writer.flush();
			reader.mark(123);
			
		}
		

	}

}
