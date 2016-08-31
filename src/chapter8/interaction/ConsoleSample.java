package chapter8.interaction;

import java.io.*;
import java.util.Locale;

import lib.TextElements;

public class ConsoleSample extends TextElements {

	public static void main(String... args) throws IOException {
		Console console = System.console();

		{
			if (console != null) {
				console.writer().print("Type something bro: ");
				console.flush();
				
				String userInput = console.readLine();
				console.flush();
				
				console.writer().println(
						"You entered the following: " + userInput);
				console.flush();
			}
		}

		separe();

		{
			if (console != null) {
				console.writer().format(new Locale("fr", "CA"), "Hello World");
//				console.flush();
			}
		}

	}
}
