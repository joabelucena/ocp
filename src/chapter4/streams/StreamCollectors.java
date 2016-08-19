package chapter4.streams;

import static lib.TextElements.miniSepare;
import static lib.TextElements.separe;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lib.TestData;

public class StreamCollectors extends TestData {
	
	private static Stream<String> getStream() {return Stream.of("lions", "tigers", "bears"); }
	
	public static void main(String[] args) {
		
		/*
		 * Main methods of Collectors class 
		 */
		separe();
		
		{
			System.out.println(getAnimals(0).collect(Collectors.toSet()));	
		
			System.out.println(getNumbers(0).collect(Collectors.toSet()));
		}
		
		separe();
		
		{
			/**
			 * Data manipulation collectors
			 */
			
			{
				/* 
				 * Method Signature: averagingInt(ToIntFunction mapper);
				 * Description: Calculates the average from an int (ToIntFuncton) given through
				 * a ToIntFunction parameter
				 * 
				 */
				
				Double result = getAnimals(0)
						.collect(Collectors.averagingInt(String::length));		//String::length is a function telling what to average
				
				System.out.println(result);
			}
			
			miniSepare();
			
			{
				/* 
				 * Method Signature: maxBy(Comparator c)
				 * Description: Retrieves the larger element
				 * 
				 */
				
				Optional<Integer> max = getNumbers(0)
						.collect(Collectors.maxBy((a, b)->a-b));
				
				max.ifPresent(System.out::println);
				
			}
			
			miniSepare();
			
			{
				/* 
				 * Method Signature: counting()
				 * Description: Retrieves the number of elements
				 * 
				 */
				
				Long count = getNumbers(0)
						.collect(Collectors.counting());
				
				System.out.println(count);
				
			}
			
			miniSepare();
			
			{
				/* 
				 * Method Signature: joining(CharSequence delimiter);
				 * Description: Collects concatenating a delimiter  
				 * 
				 */
				String result = getNames(0)
						.collect(Collectors.joining(", "));
				
				System.out.println(result);
			}
			
			miniSepare();
			
			{
				/*
				 * Method Signature: summingDouble(ToXXXFunction f);
				 * Description: Sum all Stream based information that was
				 * retrieved from Function
				 * 
				 */
				Integer hashSum = getAnimals(0)
						.collect(Collectors.summingInt(String::hashCode));
				
				System.out.println(hashSum);
			}
			
			miniSepare();
			
			{
				/*
				 * Method Signature: summarizingToInt(ToXXXFunction f);
				 * Description: Retrieves XXXSumaryStatistics
				 * 
				 */
				IntSummaryStatistics stats = getAnimals(0)
						.collect(Collectors.summarizingInt(String::length));
				
				System.out.println("The max length is: " + stats.getMax());
			}
			
		}
		
		separe();
		
		{
			/**
			 * Collection collectors
			 */
			{
				/* 
				 * Method Signature: toList()
				 * Description: Returns a List from stream  
				 * 
				 */
				List<String> animals = getAnimals(0)
						.collect(Collectors.toList());
				
				System.out.println(animals);
			}
			
			miniSepare();
			
			{
				/* 
				 * Method Signature: toSet()
				 * Description: Returns a Set from stream  
				 * 
				 */
				Set<String> animals = getAnimals(0)
						.collect(Collectors.toSet());
				
				System.out.println(animals);
			}
			
			miniSepare();
			
			{
				/* 
				 * Method Signature: toCollection(Supplier a)
				 * Description: Returns a Collection given from Supplier
				 * 
				 */
				Queue<String> animals = getAnimals(0)
						.collect(Collectors.toCollection(LinkedList::new));
				
				System.out.println(animals);
			}
		}
		
		separe();
		
		{
			/**
			 * Freaking way to build a Map
			 * 
			 * Method Signature: toMap(Function key, Function value)
			 * 					 toMap(Function key, Function value, BinaryOperator merge)
			 * 					 toMap(Function key, Function value, BinaryOperator merge, Supplier mapType)
			 * Description: Returns a Collection given from Supplier
			 */
			{
				/*
				 * toMap(Function key, Function value)
				 */
				Map<String, Integer> m1 = getAnimals(0).collect(
						Collectors.toMap( a -> a, b -> b.length() ));
				
				Map<String, Integer> m2 = getAnimals(0).collect(
						Collectors.toMap( String::toString, String::length ));
				
				System.out.println(m1);
				
				System.out.println(m2);
				
				/*
				 * WARNING: Map doesn't allows duplicate keys
				 */
				Stream<String> stream = Stream.of("lions", "tigers", "bears");
				
				try {
					Map<Integer, String> map = stream.collect(
							Collectors.toMap( String::length , String::toString));
					System.out.println(map);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				
			}
			
			miniSepare();
			
			{
				/*
				 * toMap(Function key, Function value, BinaryOperator merge)
				 */
				List<String> list = Arrays.asList("lions", "tigers", "bears");
				
				Map<Integer, String> m1 = list.stream().collect(Collectors.toMap(
						a->a.length(),												// Key is the length 
						b->b.toString(), 											// Value is itself. Could be b->b
						(s1, s2)->s1 + ", " + s2)									// If there are two words with the same key (length), it concacts this way
					);
				
				Map<Integer, String> m2 = list.stream().collect(Collectors.toMap(
						String::length, 
						String::toString, 
						String::concat)
					);
				
				System.out.println(m1);
				System.out.println(m2);
				System.out.println(m1.getClass());
				
			}
			
			miniSepare();
			
			{
				/*
				 * toMap(Function key, Function value, BinaryOperator merge, Supplier mapType)
				 */
				List<String> list = Arrays.asList("lions", "tigers", "bears");
				
				Map<Integer, String> m1 = list.stream().collect(Collectors.toMap(
						a->a.length(),												// Key is the length 
						b->b.toString(), 											// Value is itself. Could be b->b
						(s1, s2)->s1 + ", " + s2,									// If there are two words with the same key (length), it concacts this way
						() -> new TreeMap<>())										// Object that is holding the whole thing
					);
				
				Map<Integer, String> m2 = list.stream().collect(Collectors.toMap(
						String::length, 
						String::toString, 
						String::concat,
						TreeMap::new)
					);
				
				System.out.println(m1);
				System.out.println(m1.getClass());
				
			}
			
		}
		
		separe();
		
		{
			/**
			 * Grouping, Partitioning and Mapping
			 */
			{
				/*
				 * Grouping...
				 */
				{
					/* 
					 * Method Signature: groupingBy(Function criteria)
					 * Description: returns a map witch key is a criteria for grouping
					 * 
					 */
					Map<Integer, List<String>> map = getStream().collect(
							Collectors.groupingBy(String::length)			// Criteria
						);
					
					System.out.println(map);
				}
				
				miniSepare();
				
				{
					/* 
					 * Method Signature: groupingBy(Function criteria, Collector Downstream)
					 * Description: returns a map witch key is a criteria for grouping
					 * 
					 */
					Map<Integer, Set<String>> map = getStream().collect(Collectors.groupingBy(
							String::length,									// Criteria
							Collectors.toSet())								// DownStream
						);
					
					System.out.println(map);
				}
				
				miniSepare();
				
				{
					/* 
					 * Method Signature: groupingBy(Function criteria, Supplier type, Collector Downstream)
					 * Description: returns a map witch key is a criteria for grouping
					 * 
					 */
					TreeMap<Integer, Set<String>> map = getStream().collect(Collectors.groupingBy(
							String::length,									// Criteria
							TreeMap::new,									// Object that is holding the whole thing
							Collectors.toSet())								// DownStream
						);
					
					System.out.println(map);
				}
				
				miniSepare();
				
				{
					Map<Integer, Long> map = getStream().collect(Collectors.groupingBy(
							String::length,
							Collectors.counting()));
					System.out.println(map);
				}
			}
			
			separe();
			
			{
				/*
				 * Partitioning
				 */
				{
					/* 
					 * Method Signature: partitioningBy(Predicate criteria)
					 * Description: Groups into two groups according to a criteria
					 * 
					 */
					Map<Boolean, List<String>> map = getStream().collect(Collectors.partitioningBy(
							s -> s.length() <= 5
							));
					System.out.println(map);
				}
				
				miniSepare();
				
				{
					Map<Boolean, Set<String>> map = getStream().collect(Collectors.partitioningBy(
							s -> s.length() <= 5,
							Collectors.toSet()
							));
					
					System.out.println(map);
				}
			}
			
			separe();
			
			{
				/*
				 * Mmapping
				 */
				{
					/* 
					 * Method Signature: mapping(Function mapper, Collector downstream)
					 * Description: Groups into two groups according to a criteria
					 * 
					 */
					
					Map<Integer, Optional<Character>> map = getStream().collect(Collectors.groupingBy(
							String::length,
							Collectors.mapping(
									s -> s.charAt(0),
									Collectors.minBy(Comparator.naturalOrder())
									)
							));
					System.out.println(map);
				}
			}
		}

	}

}
