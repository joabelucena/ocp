package chapter4.streams;

import static lib.TextElements.miniSepare;
import static lib.TextElements.separe;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lib.TestData;

public class TerminalOperations {

	public static void main(String[] args) {
		
		Supplier<List<String>> animals = TestData::getAnimals;
		
		{
			System.out.println(animals.get());
		}
		
		{
			/*
			 * long count()
			 */
			Stream<String> finite = Stream.of("a", "b", "c");
			
			Stream<String> infinite = Stream.generate(String::new);
			
			//This hangs
//			System.out.println(infinite.count());
			
			System.out.println(finite.count());
			
		}
		
		separe();
		
		{
			/*
			 * Optional<T> min(Comparator<? super T> comparator) and
			 * Optional<T> min(Comparator<? super T> comparator)
			 */
			System.out.println(animals.get());
			
			Stream<String> s = animals.get().stream();
			
			Optional<String> min = s.min((s1, s2) -> s1.length() - s2.length());
			
			min.ifPresent(System.out::println);
			
		}
		
		separe();
		
		{
			/*
			 * Optional<T> findFirst();
			 * Optional<T> findAny();
			 */
			Stream<String> s = animals.get().stream();
			Stream<String> infinite = Stream.generate(()->"chimp");
			
			s.findAny().ifPresent(System.out::println);
			
			infinite.findFirst().ifPresent(System.out::println);
		}
		
		separe();
		
		{
			/*
			 * boolean anyMatch(Predicate <? super T> predicate)
			 * boolean allMatch(Predicate <? super T> predicate)
			 * boolean noneMatch(Predicate <? super T> predicate)
			 */
			Stream<String> infinite = Stream.generate(() -> "chimp");
			
			Predicate<String> isLetter = x -> Character.isLetter(x.charAt(0));
			Predicate<String> hasA = x -> x.contains("a");
			
			System.out.println(animals.get().stream().anyMatch(isLetter));
			System.out.println(animals.get().stream().allMatch(isLetter));
			System.out.println(animals.get().stream().noneMatch(isLetter));
//			System.out.println(infinite.allMatch(isLetter));
			
			miniSepare();
			
			System.out.println(animals.get().stream().anyMatch(hasA));
			System.out.println(animals.get().stream().allMatch(hasA));
			System.out.println(animals.get().stream().noneMatch(hasA));
			
		}
		
		separe();
		
		{
			/*
			 * void forEach(Consumer<? super T> action)
			 */
			Consumer<String> c = (a) -> System.out.print(a + ", ");
			
			animals.get().stream().forEach(c);
			System.out.println();
			animals.get().stream().forEach(System.out::print);
			System.out.println();
		}
		
		separe();
		
		{
			/*
			 * T reduce(T identity, BinaryOperator<T> accumulator)
			 * Optional<T> reduce(BinaryOperator<T> accumulator)
			 * <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
			 */
			
			{
				//Concat with array
				String[] array = new String[]{"w", "o", "l", "f"};
				String identity = "";
				for (String string : array) identity += string;
				
				System.out.println(identity);
			}
			
			miniSepare();
			
			{
				Stream<String> s1 = Stream.of("w", "o", "l", "f");
				Stream<String> s2 = Stream.of("b", "e", "e");
				Stream<Integer> s3 = Stream.of(1,2,3,4,5);
				
				/*
				 * First parameter is the holder object (identity)
				 * Second parameter is the function that will run on each element of the stream 
				 */
				System.out.println( s1.reduce("", (s, c) -> s.concat(c)) );
				System.out.println( s2.reduce("", String::concat)  );
				
				//Factorial 
				System.out.println( s3.reduce(1, (a,b) -> a*b));
			}
			
			miniSepare();
			
			{
				BinaryOperator<Integer> op = (a, b) -> a * b;
				
				Stream<Integer> empty = Stream.empty();
				Stream<Integer> oneElement = Stream.of(3);
				Stream<Integer> threeElements = Stream.of(3,5,6);
				
				empty.reduce(op).ifPresent(System.out::println);
				oneElement.reduce(op).ifPresent(System.out::println);
				threeElements.reduce(op).ifPresent(System.out::println);
				
			}
			
			miniSepare();
			
			{
				//Didn't understand this at all =S
				BinaryOperator<Integer> op = (a, b) -> a * b;
				Stream<Integer> stream = Stream.of(3, 5, 6);
				System.out.println(stream.reduce(1, op, op));
			}

		}
		
		separe();
		
		{
			/*
			 * collect() is the same of reduce() but it uses the mutable object instead as
			 * a identity
			 * 
			 * <R> R collect(Supplier<R> supplier, BiConsummer<R, ? super T> accumulator, BiConsumer<R, R> comibner)
			 * <R, A> R collect(Collector<? superT, A,R> collector)
			 */
			{
				Stream<String> stream = Stream.of("w", "o", "l", "f");
				
				/*
				 * First parameter: Supplier for creating a new instance of a mutable object
				 * Second parameter: BiConsumer to merge data into supplier
				 * Third parameter: BiComsumer to combine the suppliers in case of parallel
				 */
				StringBuilder word = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
				
				System.out.println(word);	
			}
			
			miniSepare();
			
			{
				Stream<String> s1 = Stream.of("w", "o", "l", "f");
				Stream<String> s2 = Stream.of("w", "o", "l", "f");
				
				TreeSet<String> set1 = s1.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
				
				TreeSet<String> set2 = s2.collect(
								
						() -> new TreeSet<String>(),	// Creates a new mutable object tha will hold the whole thing
						(a, b) -> a.add(b),				// Accumulates the 'b' [that is a String] data into 'a' [that is our supplier, a TreeSet ]
						(a, b) -> a.addAll(b)			// Adds into 'a' [a second party TreeSet] all elements of our supplier 'b'
				
				);
				
				/*
				 * prints 'flow' because: f < l < o < w and as TreeSet is ordered...
				 */
				System.out.println(set1);
				System.out.println(set2);
				
			}
			
			miniSepare();
			
			{
				/*
				 * Implementing collect() with Collectors
				 */
				Stream<String> s1 = Stream.of("w", "o", "l", "f");
				Stream<String> s2 = Stream.of("w", "o", "l", "f");
				
				TreeSet<String> set1 = s1.collect(Collectors.toCollection(TreeSet::new));
				Set<String> set2 = s2.collect(Collectors.toSet());
				
				System.out.println(set1);
				System.out.println(set2);
				
			}
		}
	}

}
