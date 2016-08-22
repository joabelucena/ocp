package chapter5.format;

import java.text.*;
import java.util.*;

import static lib.TextElements.*;

public class FormatNumber {

	public static void main(String[] args) {
		
		{
			int attendeesPerYear = 3_200_000;
			int attendeesPerMonth = attendeesPerYear / 12;
			
			NumberFormat us = NumberFormat.getInstance(Locale.US);
			NumberFormat ge = NumberFormat.getInstance(Locale.GERMANY);
			NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
			
			System.out.println("US: " + us.format(attendeesPerMonth));
			
			System.out.println("Germany: " + ge.format(attendeesPerMonth));
			
			System.out.println("Canada: " + ca.format(attendeesPerMonth));
			
		}
		

		separe();
		
		{
			double price = 48.65;
			
			NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
			NumberFormat ge = NumberFormat.getCurrencyInstance(Locale.GERMANY);
			NumberFormat ca = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);
			NumberFormat fr = NumberFormat.getCurrencyInstance(Locale.FRENCH);
			
			System.out.println("US: " + us.format(price));
			
			System.out.println("Germany: " + ge.format(price));
			
			System.out.println("Canada: " + ca.format(price));
			
			System.out.println("France: " + fr.format(price));
			
			miniSepare();
		}
		
		separe();
		
		{
			/*
			 * parsing numbers
			 */
			NumberFormat en = NumberFormat.getInstance(Locale.US);
			NumberFormat fr = NumberFormat.getInstance(Locale.FRENCH);
			
			String s = "40.45";
			
			try {
				System.out.println(en.parse(s));
				System.out.println(fr.parse(s));	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
		}
		
		separe();
		
		{
			/*
			 * parsing money
			 */
			NumberFormat en = NumberFormat.getCurrencyInstance(Locale.US);
			
			String s = "$ 92,807.99";
			
			try {
				System.out.println(en.parse(s));	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
		}

	}
	
	
}
