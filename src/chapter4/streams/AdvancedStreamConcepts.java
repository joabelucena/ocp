package chapter4.streams;

import static lib.TextElements.miniSepare;
import static lib.TextElements.separe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class AdvancedStreamConcepts {

	public static void main(String[] args) {
		
		{
			List<String> cats = new ArrayList<>();
			cats.add("Annie");
			cats.add("Ripley");
			
			Stream<String> stream = cats.stream();
			
			cats.add("Tom");
			
			/*
			 * Stream runs here.. and it's also terminated
			 */
			System.out.println(stream.count());
		}
		
		separe();
		
		{
		
			/*
			 * The three-digit case
			 */
			{
				Optional<Integer> optional = Optional.of(4);
				
				
				if(optional.isPresent()){				// outer if			
					Integer num = optional.get();
					
					String string = "" + num;
					
					if(string.length() == 3){			// inner if
						System.out.println(string);	
					}
				}
				
				
			}
			
			miniSepare();
			
			{
				Optional<Integer> optional = Optional.of(4);
				
				Optional<String> opt = Optional.of("a");
				
				optional.map(n -> "" + n)				// part 1
					.filter(s -> s.length() == 3)		// part 2
					.ifPresent(System.out::println);	// part 3
				
				Optional<Integer> r1 = opt.map(String::length);
				Optional<Integer> r2 = opt.flatMap(AdvancedStreamConcepts::calculator);
				
//				Optional<Integer> aaa = opt.map(AdvancedStreamConcepts::calculator);
				
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		separe();
		
		{
		
			/*
			 * Handling Exceptions
			 */
			{
				try {
					create().stream().count();
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
			
			miniSepare();
			
			{
				/*
				 * DOES NOT COMPILE: Trying to attribute to a supplier, a method that throws exceptions
				 * without handling it
				 * 
				 */
//				Supplier<List<String>> s1 = AdvancedStreamConcepts::create;
				
				/*
				 * 1st approach: Handle the exception within a lambda expression
				 */
				Supplier<List<String>> s2 = () -> {
						try{
							return AdvancedStreamConcepts.create();
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
				};
				
				/*
				 * 2nd approach: Create a second method that handles the exception and call it
				 */
				Supplier<List<String>> s3 = AdvancedStreamConcepts::createSafe;
				Supplier<List<String>> s4 = () -> AdvancedStreamConcepts.createSafe();
				
			}
			
		}
	}
	
	private static Optional<Integer> calculator(String s){
		return Optional.of(s.length());
	}
	
	
	private static List<String> create() throws IOException {
		throw new IOException();
	}
	
	private static List<String> createSafe()  {
		try {
			return AdvancedStreamConcepts.create();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
