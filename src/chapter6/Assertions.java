package chapter6;

import static lib.TextElements.separe;

enum Seasons {
	SPRING, SUMMER, FALL
}

public class Assertions {

	public static void main(String[] args) {
		
		/*
		 * Enables assertions on current run:
		 * -----------------------------------------------------------------------
		 * java -ea chapter6.Assertions
		 *  or
		 * java -enableassertions chapter6.Assertions
		 * 
		 * Enables assertions for a specific package
		 * -----------------------------------------------------------------------
		 * java -ea:chapter5 chapter6.Assertions
		 * 
		 * Enables assertions for a specific package + subpackages
		 * -----------------------------------------------------------------------
		 * java -ea:chapter5... chapter6.Assertions
		 * 
		 * Enables assertions for a specific class
		 * -----------------------------------------------------------------------
		 * java -ea:chapter5.StringReview chapter6.Assertions
		 * 
		 * Disable assertions (-da or -disableassertions) for specific class in a
		 * package that was enabled for assertions
		 * -----------------------------------------------------------------------
		 * java -ea:chapter5... -da:chapter5.StringReview chapter6.Assertions
		 * 
		 */
		{
			int num = -5;
			
			assert num > 0: "Eu preciso aprender um pouco aqui";
			
			System.out.println(num);	
		}
		
		separe();
		
		{
			
		}
		

	}
	
	static void testSeasons(Seasons s) {
		/*
		 * Control flow invariant. It is known that WINTER value is not present for Seasons.
		 * However, if it changes the assertion will tell us.
		 */
		switch (s) {
		case SPRING:
		case FALL:
			System.out.println("Shorter hours");
			break;
		
		case SUMMER:
			System.out.println("Longer hours");
			break;

		default:
			//Control flow
			assert false: "Invalid season";
			break;
		}
	}

}
