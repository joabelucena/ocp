package chapter7.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lib.TextElements.miniSepare;
import static lib.TextElements.separe;

public class ParallelStreams {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i <= 6; i++) list.add(i);
		
		{
			/*
			 * Creating parallel streams
			 */
			{
				/*
				 * parallel() creates a parallel stream from an existing stream
				 */
				Stream<Integer> stream = list.stream();
				
				Stream<Integer> parallel = stream.parallel();
			}
			
			miniSepare();
			
			{
				/*
				 * parallelStream() creates a parallel stream from a Collection
				 */
				Stream<Integer> parallel = list.parallelStream();
				
			}
			
		}

		separe();
		
		{
			/*
			 * Processing tasks in parallel
			 */
			{
				list
				.stream()
				.forEach(System.out::print);
				
				System.out.println();
			}
			
			miniSepare();
			
			{
				list
				.parallelStream()
				.forEach(System.out::print);
				
				System.out.println();
				
				list
				.parallelStream()
				.forEachOrdered(System.out::print);
				
				System.out.println();
				
			}
		}
		
		separe();
		
		{
			/*
			 * Independent operations
			 */
			{
				Arrays.asList("jackal", "kangaroo", "lemur")
				.parallelStream()
				.map(s -> s.toUpperCase())
				.forEach(System.out::println);	
			}
			
			miniSepare();
			
			{
				Arrays.asList("jackal", "kangaroo", "lemur")
				.parallelStream()
				.map(s -> { System.out.println(s); return s.toUpperCase();})
				.forEach(System.out::println);
			}
			
		}
		
		separe();
		
		{
			/*
			 * avoiding stateful operations
			 */
			List<Integer> data = Collections.synchronizedList(new ArrayList<>());
			
			list
				.parallelStream()
				.map(i -> {data.add(i); return i;})
				.forEachOrdered(i -> System.out.print(i + " "));
			
			System.out.println();
			
			for (Integer i : data) {
				System.out.print(i + " ");
			}
			
			System.out.println();
		}
		
		separe();
		
		{
			/*
			 * Working with reductions or parallel reductions
			 */
			System.out.println(list.stream().findAny().get());
			
			miniSepare();
			
			System.out.println(list.parallelStream().findAny().get());
			
			// Although it's slower, this is still ordered
			System.out.println(list
					.parallelStream()
					.findFirst()
					.get());
			
		}
		
		separe();
		
		{
			/*
			 * Combining with reduce()
			 */
			System.out.println(Arrays.asList("w", "o", "l", "f")
					.parallelStream()
					.reduce("-", (c, s1) -> s1 + c,
							(s2, s3) -> s2 + s3));
			
			miniSepare();
			
			//This supposed to return an unpredictable value, but returns 3
			System.out.println(list
					.parallelStream()
					.reduce(0, (a, b) -> (a-b)));
			
			miniSepare();
			
			System.out.println(Arrays.asList("w", "o", "l", "f")
					.parallelStream()
					.reduce("-", String::concat));
			
		}
		
		separe();
		
		{
			/*
			 * Combining with collect()
			 */
			{
				Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
				Set<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
				System.out.println(set);
			}
			
			miniSepare();
			
			{
				
				Set<String> set = Stream.of("w", "o", "l", "f").parallel()
						.collect(Collectors.toSet());
				List<String> ordered = Stream.of("w", "o", "l", "f").parallel()
						.collect(Collectors.toList());
				
				System.out.println(set);		// HashSet
				System.out.println(ordered);	// ArrayList
			}
			
		}
	}
}
