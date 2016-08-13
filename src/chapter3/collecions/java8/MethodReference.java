package chapter3.collecions.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

import chapter3.collecions.comparable.Duck;
import static lib.TextElements.*;

@FunctionalInterface
interface Test<T> {
	public T go(T t1, T t2);
}

public class MethodReference {

	public static void main(String[] args) {
		
		{
			/*
			 * Static call
			 */
			Consumer<List<Integer>> ref = Collections::sort;
			Consumer<List<Integer>> lamb = l->Collections.sort(l);
			
			List<Integer> l = Arrays.asList(1,5,6,86,23,3);
			
			System.out.println(l);
			
			ref.accept(l);
			
			System.out.println(l);
		}
		
		separe();
		
		{
			/*
			 * Unknown instance call
			 */
			Test<String> t1 = (b1, b2)->b1.concat(b2);
			Test<String> t2 = String::concat;
			
			System.out.println(t2.go("Joabe", " Lucena"));
			System.out.println(t1.go("Joabe", " Lucena"));
			
		}
		
		separe();
		
		{
			/*
			 * Object call
			 */
			String str = "abc";
			
			/*
			 * Gives a bypass to parameter..
			 */
			Predicate<String> ref = str::startsWith;
			Predicate<String> lamb = l->str.startsWith(l);
			
			System.out.println(lamb.test("abc"));
			
		}
		
		separe();
		
		{
			/*
			 * Unknown instance call
			 */
			Predicate<String> ref = String::isEmpty;
			Predicate<String> lamb = l->l.isEmpty();
			
			System.out.println(lamb.test(""));
		}
		
		separe();
		
		{
			/*
			 * Constructor call
			 */
			Supplier<String> ref = String::new;
			Supplier<String> lamb = () -> new String();
			
			System.out.println(ref.get());
		}
		
	}

}

class DuckHelper {
	public static int compareByWeight(Duck d1, Duck d2) {
		return (int) (d1.getWeight() - d2.getWeight());
	}
	
	public static int compareByName(Duck d1, Duck d2) {
		return d1.getName().compareTo(d2.getName());
	}
	
	public static void ain(String...args) {
		
		Comparator<Duck> byWeight 			= (d1, d2) -> DuckHelper.compareByWeight(d1, d2);
		
		/*
		 * Method reference
		 */
		Comparator<Duck> byWeightReference 	= DuckHelper::compareByWeight;
	}
}