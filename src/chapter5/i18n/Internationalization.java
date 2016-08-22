package chapter5.i18n;

import static lib.TextElements.miniSepare;
import static lib.TextElements.separe;

import java.util.Locale;
import java.util.function.UnaryOperator;

public class Internationalization {
	
	public static UnaryOperator<String> modifier = (s)-> new StringBuilder()
															.append(String.valueOf(s.charAt(0)).toLowerCase())
															.append(s.substring(1).length()-1)
															.append(String.valueOf(s.charAt(s.length()-1)).toLowerCase())
															.toString();

	public static void main(String[] args) {
		
		System.out.println(modifier.apply("Internationalization"));
		
		separe();
		
		{
			/*
			 * Constructing Locales
			 */
			
			System.out.println(Locale.getDefault());			
			
			miniSepare();
			
			System.out.println(Locale.CANADA_FRENCH);			
			System.out.println(Locale.CANADA);			
			System.out.println(Locale.GERMAN);			
			System.out.println(Locale.GERMANY);
			
			miniSepare();
			
			System.out.println(new Locale("pt"));
			System.out.println(new Locale("pt", "BR"));
			
			miniSepare();
			
			System.out.println(new Locale.Builder().setLanguage("pt").setRegion("BR").build());
			
		}

		separe();
		
		{
			/*
			 * Setting default Locale
			 */
			
			Locale.setDefault(Locale.CANADA);
			
			System.out.println(Locale.getDefault());
		}

	}

}
