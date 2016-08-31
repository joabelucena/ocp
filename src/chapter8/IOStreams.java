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
			// new BufferedInputStream(new FileReader("")); // Mix InputStream
			// and Reader
			// new BufferedWriter(new FileOutputStream("")); // Mix Writer and
			// OutputStream
			// new ObjectInputStream(new FileOutputStream("")); // Mix
			// InputStream and OutputStream
			// new BufferedInputStream(new InputStream()); // InputStream is an
			// abstract class, can't be instanciated like that
		}

		miniSepare();

		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(""));
			BufferedReader reader = new BufferedReader(new FileReader(""));

			writer.flush();
			reader.mark(123);

		}

		separe();

		{
			InputStream is1 = new FileInputStream("");
			InputStream is2 = new BufferedInputStream(new FileInputStream(""));
			InputStream is3 = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream("")));

			Reader r1 = new FileReader("");
			Reader r2 = new BufferedReader(new FileReader(""));
			Reader r3 = new InputStreamReader(new FileInputStream(""));
			Reader r4 = new InputStreamReader(new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("")))); // Converts
																		// a
																		// Stream
																		// to a
																		// Reader

			OutputStream os1 = new FileOutputStream("");
			OutputStream os2 = new BufferedOutputStream(
					new FileOutputStream(""));
			OutputStream os3 = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream("")));

			Writer w1 = new FileWriter("");
			Writer w2 = new BufferedWriter(new FileWriter(""));
			Writer w3 = new OutputStreamWriter(new FileOutputStream(""));
			Writer w4 = new OutputStreamWriter(new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("")))); // Converts
																			// a
																			// Stream
																			// to
																			// a
																			// Writer

		}

	}

}
