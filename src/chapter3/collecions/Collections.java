package chapter3.collecions;

import java.util.*;

import static lib.TextElements.*;

public class Collections {

	public static void main(String[] args) {
		
		/**
		 * These methods are common to Collection objects
		 */
		
		{
			/*
			 * boolean add(E e)
			 */
			List<String> list = new ArrayList<>();
			System.out.println(list.add("Sparrow"));
			System.out.println(list.add("Sparrow"));
			
			Set<String> set = new HashSet<>();
			System.out.println(set.add("Sparrow"));
			System.out.println(set.add("Sparrow"));
			
		}
		
		separe();
		
		{
			/*
			 * boolean remove(Object o)
			 */
			List<String> birds = new ArrayList<>();
			birds.add("Hawk");								System.out.println(birds);
			birds.add("Hawk");								System.out.println(birds);
			System.out.println(birds.remove("cardinal"));	System.out.println(birds);
			System.out.println(birds.remove("Hawk"));		System.out.println(birds);
			
		}
		
		separe();
		
		{
			/*
			 * boolean isEmpty()
			 * int size()
			 */
			List<String> birds = new ArrayList<>();
			
			System.out.println(birds.size());				System.out.println(birds);
			System.out.println(birds.isEmpty());			System.out.println(birds);
			
			birds.add("Hawk");								System.out.println(birds);
			birds.add("Hawk");								System.out.println(birds);
			
			System.out.println(birds.size());				System.out.println(birds);
			System.out.println(birds.isEmpty());			System.out.println(birds);
			
		}
		
		separe();
		
		{
			/*
			 * void clear()
			 */
			List<String> birds = new ArrayList<>();
			
			
			birds.add("Hawk");								System.out.println(birds);
			birds.add("Hawk");								System.out.println(birds);
			
			
			birds.clear();
			
			System.out.println(birds);
			
		}
		
		separe();
		
		{
			/*
			 * boolean contains(Object o)
			 */
			List<String> birds = new ArrayList<>();
			
			birds.add("Hawk");
			
			System.out.println(birds.contains("cardinal"));
			System.out.println(birds.contains("Hawk"));
			
		}

	}

}
