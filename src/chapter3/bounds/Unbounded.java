package chapter3.bounds;

import java.util.ArrayList;
import java.util.List;

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
 * Unbounded wildcard eg: <?>
 * 
 * @author root
 *
 */
public class Unbounded {

	public static void main(String[] args) {
		List<String> keywords = new ArrayList<>();
		keywords.add("java");
		
		/*
		 * DOES NOT COMPILE WITH THE SIGNATURE printList(List<Object> list): List<String> cannot be
		 * casted to List<Object> although String is a subclass of Object, we could have an unwanted
		 * object stored in our list.
		 */
		printList(keywords);

	}
	
//	public static void printList(List<Object> list) {
//		for (Object object : list) System.out.println(object);
//	}
	
	/**
	 * ? wildcard means tha this method takes as parameter a List of whatever it be
	 * 
	 * @param list
	 */
	public static void printList(List<?> list) {
		for (Object object : list) System.out.println(object);
	}


}
