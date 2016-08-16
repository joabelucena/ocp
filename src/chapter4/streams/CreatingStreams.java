package chapter4.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreatingStreams {

	public static void main(String[] args) {
		
		{
			/*
			 * FINITE Streams
			 */
			Stream<String> empty = Stream.empty();
			Stream<Integer> singleElement = Stream.of(1);
			Stream<Integer> fromArray = Stream.of(1, 2, 3);
			
			List<String> list = Arrays.asList("a", "b", "c");
			Stream<String> fromList = list.stream();
			Stream<String> fromListParallel = list.parallelStream();			
		}
		
		{
			/*
			 * INFINITE Streams
			 */
			Stream<Double> randoms = Stream.generate(Math::random);
			Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
			
//			randoms.forEach(System.out::println);
			oddNumbers.forEach(System.out::println);
		}
		


	}

}
