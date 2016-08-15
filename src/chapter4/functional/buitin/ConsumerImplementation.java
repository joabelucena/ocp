package chapter4.functional.buitin;

import static lib.TextElements.*;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ConsumerImplementation {
	
	public static void main(String...args) {
		
		/**
		 * Implementing Predicate<T> and BiPredicate<T, U>
		 * 
		 * Method Signature: boolean test(T t) and boolean test(T t, U u);
		 */
		{
			Predicate<String> p1 = String::isEmpty;
			Predicate<String> p2 = (s) -> s.isEmpty();
			
			System.out.println(p1.test(""));
			System.out.println(p2.test(""));
			
			miniSepare();
			
			Predicate<String> isFilled = p1.negate();
			
			System.out.println(isFilled.test(""));
		}
		
		separe();
		
		{
			BiPredicate<String, String> b1 = String::startsWith;
			BiPredicate<String, String> b2 = (a, s) -> a.startsWith(s);
			
			System.out.println(b1.test("chicken", "chick"));
			System.out.println(b2.test("chicken", "chick"));
			
		}
		
	}
			
}
