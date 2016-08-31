package chapter8.interaction;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

public class PasswordCompareSample {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Console console = System.console();

		if (console == null) {
			throw new RuntimeException("Console not available");
		} else {
			char[] password = console.readPassword("Ennter your password: ");
			console.format("Enter your password again: ");
			console.flush();
			char[] verify = console.readPassword();
			
			boolean match = Arrays.equals(password, verify);
			
			//Immediately clear passwords from memory
			for (int i = 0; i < password.length; i++) {
				password[i] = 'x';
			}
			Arrays.fill(verify, 'x');
			
			console.writer().println("Your password was " + (match ? "correct" : "incorrect") + "!");
			
			console.writer().println("------------------------");
			
			console.writer().println("Password: " + Arrays.toString(password));
			console.flush();
			console.writer().println("Verify: " + Arrays.toString(verify));
			console.flush();
			
		}
	}
}
