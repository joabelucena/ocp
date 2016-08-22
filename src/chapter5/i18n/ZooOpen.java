package chapter5.i18n;

import static lib.TextElements.*;

import java.util.*;

public class ZooOpen {

	public static void main(String[] args) {
		
		Locale us = new Locale("en", "US");
		Locale france = new Locale("fr", "FR");
		Locale brazil = new Locale("pt", "BR");
		Locale toronto = new Locale("en", "CA");
		Locale quebec = new Locale("fr", "CA");
		
		ResourceBundle rb = ResourceBundle.getBundle("Zoo", brazil);

		{
			printProperties(us);

			System.out.println();

			printProperties(france);

			System.out.println();

			printProperties(brazil);
		}

		separe();

		{
			
			
			rb.keySet().stream()
				.map(k -> k + " => " + rb.getString(k))
				.forEach(System.out::println);
			
		}

		separe();
		
		{
			Properties props = new Properties();
			
			rb.keySet().stream()
			.forEach(k -> props.put(k, rb.getString(k)));
			
			System.out.println(props.getProperty("none"));
			
			System.out.println(props.getProperty("none", "123"));
			
			System.out.println(props.getProperty("hello", "123"));
		}

		separe();
		
		{
			ResourceBundle bundle = ResourceBundle.getBundle("chapter5.i18n.properties.Tax");
			
			System.out.println(bundle.getObject("tax"));
		}
		
		separe();
		
		{
			Locale.setDefault(new Locale(""));
			ResourceBundle r1 = ResourceBundle.getBundle("Zoo");			// Retrieve from default Locale
			ResourceBundle r2 = ResourceBundle.getBundle("Zoo", brazil);	// Retrieve from specified Locale
		}
		
		separe();
		
		{
			Locale.setDefault(quebec);
			ResourceBundle r1 = ResourceBundle.getBundle("Zoo", toronto);
			
			System.out.print(r1.getString("hello")); 
			System.out.print(". ");
			System.out.print(r1.getString("name"));
			System.out.print(" ");
			System.out.print(r1.getString("open"));
			System.out.print(" ");
			System.out.print(r1.getString("visitor"));
		}
		
		
	}

	private static void printProperties(Locale locale) {

		ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);

		System.out.print(rb.getString("hello") + ", ");
		System.out.println(rb.getString("open") + "!");
	}

}
