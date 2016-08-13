package chapter3.collecions.java8;

import static lib.TestData.*;
import static lib.TextElements.*;

import java.util.*;

public class NewCollectionAPI {

	public static void main(String[] args) {
		
		{
			/*
			 * boolean removeIf(Predicate<? super E> filter)
			 */
			List<String> animals = getAnimals();
			
			System.out.println(animals);
			
			animals.removeIf(s -> s.endsWith("a"));
			
			System.out.println(animals);
			
		}
		
		separe();
		
		{
			/*
			 * void replaceAll(UnaryOperator<E> o)
			 */
			List<Integer> numbers = getNumbers();
			
			System.out.println(numbers);
			numbers.replaceAll(n->n*2);
			System.out.println(numbers);
			
		}
		
		separe();
		
		{
			/*
			 * void forEach(Consumer<? super T> action)
			 */
			List<String> cats = getCats();
			
			cats.removeIf(gato->gato.equals("Max") || gato.equals("George"));
			
			for(String s : cats) System.out.println(s);
			
			//Lambda
			cats.forEach(s -> System.out.println(s));
			
			//Method Reference
			cats.forEach(System.out::println);
		}

	}

}
