package chapter4.functional.buitin;

import static lib.TextElements.separe;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorImplementation {

	public static void main(String[] args) {
		/**
		 * Implementing UnaryOperator<T> and BinaryOperator<T>
		 * 
		 * Method Signature: T apply(T t) and T apply(T t1, T t2);
		 */
		{
			UnaryOperator<String> u1 = String::toUpperCase;
			UnaryOperator<String> u2 = s -> s.toUpperCase();
			
			System.out.println(u1.apply("oracle"));
			System.out.println(u2.apply("oracle"));
			
		}
		
		separe();
		
		{
			BinaryOperator<String> b1 = String::concat;
			BinaryOperator<String> b2 = (a, s) -> a.concat(s);
			
			System.out.println(b1.apply("Oracle", " Java"));
			System.out.println(b2.apply("Oracle", " Java"));
		}

	}

}
