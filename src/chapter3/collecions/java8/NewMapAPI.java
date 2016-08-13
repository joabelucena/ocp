package chapter3.collecions.java8;

import static lib.TextElements.*;

import java.util.*;
import java.util.function.*;

public class NewMapAPI {

	public static void main(String[] args) {
		
		{
			/*
			 * putIfAbsent()
			 * 
			 * put if value is null
			 */
			Map<String, String> favorites = new HashMap<>();
			
			favorites.put("Jenny", "Bus Tour");
			System.out.println(favorites);
			
			//Overrides
			favorites.put("Jenny", "Tram");
			System.out.println(favorites);
			
			miniSepare();
			
			favorites.put("Jenny", "Bus Tour");
			favorites.put("Tom", null);
			
			System.out.println(favorites);
			
			favorites.putIfAbsent("Jenny", "Tram");
			favorites.putIfAbsent("Sam"	 , "Tram");
			favorites.putIfAbsent("Tom"	 , "Tram");
			
			System.out.println(favorites);
			
		}
		
		separe();
		
		{
			/*
			 * merge()
			 * 
			 * put if merge value is returned from BiFunction
			 */
			BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
			
			Map<String, String> favorites = new HashMap<>();
			
			favorites.put("Jenny", "Bus Tour");
			favorites.put("Tom"	 , "Tram");
			
			System.out.println(favorites);
			
			String jenny = favorites.merge("Jenny", "Skyride", mapper);
			String tom = favorites.merge("Tom", "Skyride", mapper);
			
			System.out.println(favorites);
			
			miniSepare();
			
			/*
			 * null treatment
			 */
			favorites.put("Sam", null);
			
			System.out.println(favorites);
			
			favorites.merge("Tom", "Skyride", mapper);
			favorites.merge("Sam", "Skyride", mapper);
			
			System.out.println(favorites);
			
			miniSepare();
			
			/*
			 * When mapping function return null, the key is removed
			 */
			mapper = (v1, v2) -> null;
			
			favorites.merge("Jenny", "Skyride", mapper);
			favorites.merge("Sam", "Skyride", mapper);	//removes (because already exists)
			favorites.merge("Sam", "Skyride", mapper);	//inserts (beacause it didn't exist [because it waw removed...line up])
			
			System.out.println(favorites);
			
		}
		
		separe();
		
		{
			/*
			 * computeIfPresent()
			 */
			Map<String, Integer> counts = new HashMap<String, Integer>();
			
			counts.put("Jenny", 1);
			
			System.out.println(counts);
			
			BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;
			
			counts.computeIfPresent("Jenny", mapper);	//returns 2
			counts.computeIfPresent("Sam", mapper);		//returns null
			
			System.out.println(counts);
		}
		
		separe();
		
		{
			/*
			 * computeIfAbsent()
			 */
			Map<String, Integer> counts = new HashMap<String, Integer>();
			
			counts.put("Jenny"	, 2);
			counts.put("Tom"	, null);
			
			System.out.println(counts);
			
			Function<String, Integer> mapper = (k) -> 1;
			
			Integer jenny = counts.computeIfAbsent("Jenny", mapper);
			Integer sam = counts.computeIfAbsent("Sam", mapper);
			Integer tom = counts.computeIfAbsent("Tom", mapper);
			
			System.out.println(counts);
			
			System.out.println(jenny);
			System.out.println(sam);
			System.out.println(tom);
			
			
		}
		

	}

}
