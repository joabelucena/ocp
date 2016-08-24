package chapter6;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;

public class RethrowingExceptions {
	
	public void parseData() throws IOException, DateTimeParseException {}
	
	
	
	
	/*
	 * Multi Catch version
	 */
	public void multiCatch() throws IOException, SQLException, DateTimeParseException {
		
		try {
			parseData();
		} catch (IOException | DateTimeParseException e) {
			System.err.println(e);
			throw e;
		}
	}
	
	/*
	 * Rethrowing version
	 */
	public void rethrowing() throws IOException, SQLException, DateTimeParseException {
		
		try {
			parseData();
		} catch (Exception e) {		//Catching Exception is allowed in all circumstances because it can handle unchecked exceptions
			System.err.println(e);
			throw e;
		}
	}
}
