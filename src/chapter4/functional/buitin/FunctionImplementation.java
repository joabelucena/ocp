package chapter4.functional.buitin;

import static lib.TextElements.separe;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionImplementation {

	public static void main(String[] args) {
		
		/**
		 * Implementing Function<T, R> and BiFunction<T, U, R>
		 * 
		 * Method Signature: R apply(T t) and R apply(T t, U u);
		 */
		{
			Function<String, Integer> f1 = String::length;
			Function<String, Integer> f2 = s -> s.length();
			
			System.out.println(f1.apply("cluck"));
			System.out.println(f2.apply("cluck"));
			
		}
		
		separe();
		
		{
			BiFunction<String, String, String> b1 = String::concat;
			BiFunction<String, String, String> b2 = (s1, s2) -> s1.concat(s2);
			
			System.out.println(b1.apply("Joabe ", "Lucena"));
			System.out.println(b2.apply("Joabe ", "Lucena"));
		}

	}

}
