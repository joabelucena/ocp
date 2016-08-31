package chapter8.interaction;

import java.io.*;

public class SystemInSample {
	
	public static void main(String...args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Type something bro: ");
		
		String userInput = reader.readLine();
		
		System.out.println("You entered the following: " + userInput);
	}
}
