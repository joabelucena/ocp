package chapter3.bounds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Test classes
 */
class Sparrow extends Bird { }
class Bird { }

interface Flyer { void fly(); }
class HangGlider implements Flyer { public void fly() { }  }
class Goose implements Flyer { public void fly() { }  }

/**
 * 
 * Bounded wildcards are specifications for receveing generic parameters. Its syntax is:
 * 
 * <? condition Type>
 * 
 * An easy way to remember is reading as:
 * 
 * ? 			- Any Class that
 * condition	- condition
 * Type			- of Type is acceptable
 * 
 * Upper-bounded wildcard eg: <? extends Object> 
 * 
 * @author root
 *
 */
public class UpperBounded {
	
	public static void main(String[] args) {
		
		{
			List<? extends Bird> birds = new ArrayList<Bird>();
			
			/*
			 * As the list becomes immutable you can't add new elements
			 */
//			birds.add(new Sparrow());
//			birds.add(new Bird());
			
			List<? extends Exception> l = new ArrayList<RuntimeException>();
		}
		
		{
			List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
			
			System.out.println("The list's: " + list + " factorial is: " + factorial(list));	
		}
		
		{
			List<Flyer> flyers = new ArrayList<>();
			List<HangGlider> gliders = new ArrayList<>();
			List<Goose> gooses = new ArrayList<>();
			
			anyFlyer(flyers);
			
			/*
			 * DOES NOT COMPILE
			 */
//			anyFlyer(gliders);
//			anyFlyer(gooses);
			
			groupOfFLyers(flyers);
			groupOfFLyers(gliders);
			groupOfFLyers(gooses);
		}
		

	}
	
	public static long factorial(List<? extends Number> list) {
		
		long count = 1;
				
		for (Number number : list) {
			count *= number.longValue();
		}
		
		return count;
	}
	
	private static void anyFlyer(List<Flyer> flyer) { }
	private static void groupOfFLyers(List<? extends Flyer> flyer) { }
}
