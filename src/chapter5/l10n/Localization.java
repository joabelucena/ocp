package chapter5.l10n;

import static lib.TextElements.miniSepare;
import static lib.TextElements.separe;

import java.util.Locale;

import chapter5.i18n.Internationalization;

public class Localization {

	public static void main(String[] args) {
		
		System.out.println(Internationalization.modifier.apply("Localization"));
		
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
