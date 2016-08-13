package chapter3.collecions;

import static lib.TextElements.*;

import java.util.*;


public class MapCollection {

	public static void main(String[] args) {

		/**
		 * Map interface has some implementations, here are the most common followed by its 
		 * characteristics:
		 * 
		 *  Implementation	Description
		 * ----------------------------------------------------------------------------------------
		 *  HashMap			Uses hashCode to improve performance.. Adding and retrieving is O(1). 
		 *  				Its non ordered
		 *  LinkedHashMap	Same as HashMap but it is ordered
		 *  TreeMap			Keep data sorted but with performance loss. Adding/Retrieving O(log n)
		 *  Hashtable		Old.. ArrayList is to Vector as HashMap is to Hashtable		
		 *    
		 */
		{
			/*
			 * HashMap.. Not ordered at all
			 */
			Map<String, String> map = new HashMap<>();
			map.put("koala", "bamboo");
			map.put("lion", "meat");
			map.put("giraffe", "leaf");
			
			String food = map.get("koala");
			
			System.out.println(map);
			
		}
		
		separe();
		
		{
			/*
			 * TreeMap sorted
			 */
			Map<String, String> map = new TreeMap<>();
			map.put("koala", "bamboo");
			map.put("lion", "meat");
			map.put("giraffe", "leaf");
			
			String food = map.get("koala");
			
			System.out.println(map);
			
			System.out.println(map.containsKey("lion"));
			System.out.println(map.containsValue("lion"));
			System.out.println(map.size());
			
		}
		
	}

}
