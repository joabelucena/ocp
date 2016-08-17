package chapter4.streams;

import static lib.TextElements.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import lib.TestData;

public class IntermediateOperations {

	public static void main(String[] args) {
		
		Function<Integer, Stream<String>> animals = TestData::getAnimals;
		
		{
			
			animals.apply(0).forEach(System.out::println);
		}
		
		separe();
		
		{
			/*
			 * Stream<T> filter(Predicate<? super T> predicate)
			 */
			animals.apply(0)
			.filter((s) -> s.contains("a"))
			.forEach(System.out::println);
			
		}
		
		separe();
		
		{
			/*
			 * Stream<T> distinct()
			 */
			Stream<String> s1 = Stream.of("duck", "duck", "duck", "chimp", "chimp");
			Stream<String> s2 = Stream.of("duck", "duck", "duck", "chimp", "chimp");
			
			s1.forEach(System.out::println);
			
			miniSepare();
			
			s2
			.distinct()
			.forEach(System.out::println);
			
		}
		
		separe();
		
		{
			/*
			 * Stream<T> limit(long maxSize)
			 * Stream<T> skip(long n)
			 */
			Stream<Integer> stream = Stream.iterate(1, n -> n + 1);
			stream
			.skip(6)						//Skips the first n elements
			.limit(5)						//Limits the stream to n elements
			.forEach(System.out::println);
		}
		
		separe();
		
		{
			/*
			 * <R> Stream<R> map(Function<? super T, ? extends R> mapper)
			 * 
			 */
			animals.apply(0)
				.map(String::length)
				.forEach(System.out::println);
			
			animals.apply(0)
				.<Integer>map( (a) -> a.length() )			//Enters a String and outs an Integer
				.forEach((data) -> System.out.println(data));
		}
		
		separe();
		
		{
			/*
			 * <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
			 */
			List<String> zero = Arrays.asList();
			List<String> one = Arrays.asList("Bonobo");
			List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
			
			
			Stream.of(zero, one, two)
				.flatMap(l -> l.stream())
				.forEach(System.out::println);
			
			/*
			 * Explained version
			 */
			Stream.of(zero, one, two)
				.<String>flatMap( ( List<String> list)->list.stream())		//First we set the return type, <R>, to String
																			//Then we receive our input parameter <T> as variable 'list'
				.forEach((data) -> System.out.println(data));				//Then forEach() is called on our new returned Stream<String>
			
			/*
			 * Calling forEach in the original Stream (Stream<List<String>>) without flatMap
			 */
			Stream.of(zero, one, two)
				.forEach(System.out::println);
			
		}
		
		separe();
		
		{
			/*
			 * Stream<T> sorted()
			 * Stream<T> sorted(Comparator<? super T> comparator)
			 */
			
			animals.apply(0)
			.sorted()
			.forEach(System.out::println);
			
			miniSepare();
			
			animals.apply(0)
			.sorted((b,a) -> a.compareTo(b))
			.forEach(System.out::println);
			
			miniSepare();
			
			animals.apply(0)
			.sorted(Comparator.reverseOrder())
			.forEach(System.out::println);
		}
		
		separe();
		
		{
			/*
			 * WARNING: Instead of Queue, on Streams peek() run all elements
			 * 
			 * Stream<T> peek(Consumer<? super T> action)
			 * 
			 */
			{
				Stream<String> stream = Stream.of("black bear", "brown bear", "grizzly");
				long count = stream
						.filter(s->s.startsWith("b"))
						.peek(System.out::println)
						.count();
				System.out.println(count);
			}
			
			miniSepare();
			
			{
				List<Integer> numbers = Arrays.asList(1);
				List<String> letters = Arrays.asList("a");
				
				Stream<List<?>> stream = Stream.of(numbers, letters);
				stream.map(List::size).forEach(System.out::println);
				
				miniSepare();
				
				StringBuilder builder = new StringBuilder();
				Stream<List<?>> good = Stream.of(numbers, letters);
				
				good
				.peek(l -> builder.append(l))
				.map(List::size)
				.forEach(System.out::println);
				
				System.out.println(builder);
				
				miniSepare();
				
				
				/*
				 * throws exception. peek() can't change Stream's objects. It's read-only
				 */
				Stream<List<?>> bad = Stream.of(numbers, letters);
				bad
				.peek(l->l.remove(0))
				.map(List::size)
				.forEach(System.out::print);		
			}
			
		}
		
	}
}
