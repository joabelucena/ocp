package chapter4.streams;

import java.util.function.Function;
import java.util.stream.Stream;

import static lib.TextElements.*;

import lib.TestData;

public class StreamPipeline {

	public static void main(String[] args) {
		
		Function<Integer, Stream<String>> names = TestData::getNames;
		
		{
			/*
			 * Lets say that we want to get the first two names alphabetically that are four characters long
			 */
			names.apply(0)
			.filter(n->n.length()==4)			// that are four characters long ...
			.sorted()							// alphabetically ...
			.limit(2)							// the first two names ...
			.forEach(System.out::println);
			
			miniSepare();
			
			/*
			 * Order of pipeline matters...
			 */
			names.apply(0)
			.limit(2)							// the first two names ...
			.sorted()							// alphabetically ...
			.filter(n->n.length()==4)			// that are four characters long ...
			.forEach(System.out::println);
		}
		
		separe();
		
		{
			/*
			 * Hangs...
			 *
			Stream.generate(() -> "Elsa")
			.filter(n -> n.length() == 4)
			.sorted()						// <--- Hangs here
			.limit(2)
			.forEach(System.out::println);
			*/
			
			miniSepare();
			
			/*
			 * 
			 * Good.. print 'Elsa' twice
			 */
			Stream.generate(() -> "Elsa")
			.filter(n -> n.length() == 4)
			.limit(2)
			.sorted()						
			.forEach(System.out::println);
			
			miniSepare();
			
			/*
			 * Hangs...
			 
			Stream.generate(() -> "Olaf Lazisson")
			.filter(n -> n.length() == 4)	// <--- Hangs here
			.limit(2)
			.sorted()						
			.forEach(System.out::println);
			*/
		}
		
		separe();
		
		{
			/*
			 * Pipeline operations order matters
			 */
			{
				Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
				infinite.limit(5)
						.filter(x -> x % 2 ==1)
						.forEach(System.out::print);	//135
				System.out.println();
			}
			
			miniSepare();
			
			{
				Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
				infinite.limit(5)
						.peek(System.out::print)
						.filter(x -> x % 2 ==1)
						.forEach(System.out::print);	//11233455
				System.out.println();
			}
			
			miniSepare();
			
			{
				Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
				infinite
						.filter(x -> x % 2 ==1)
						.limit(5)
						.forEach(System.out::print);	//13579
				System.out.println();
			}
			
			miniSepare();
			
			{
				Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
				infinite
						.filter(x -> x % 2 ==1)
						.peek(System.out::print)
						.limit(5)
						.forEach(System.out::print);	//1133557799
				System.out.println();
			}
			
			miniSepare();
			
		}

	}

}
