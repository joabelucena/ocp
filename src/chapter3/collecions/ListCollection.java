package chapter3.collecions;

import java.util.*;

import static lib.TextElements.*;

public class ListCollection {

	public static void main(String[] args) {
		
		/**
		 * List interface has some implementations, here are the most common followed by its 
		 * characteristics:
		 * 
		 *  Implementation	Description
		 * ----------------------------------------------------------------------------------------
		 *  ArrayList		Has a constant time search: O(1);
		 *  LinkedList		Because it also implements Queue, you can manipulate the FIRST and
		 *  				LAST entry in a constant time;
		 *  Vector			Nothing. It's a very old implementation of List. It's a slower version
		 *  				of ArrayList
		 *  Stack			It is a LIFO extended version of Vector. Obsolete also.			
		 *    
		 */
		
		{	
			/**
			 * Here are the most common methods from list:
			 * ------------------------------------------------------------------------------------
			 * 
			 * boolean add(E element)			Adds new element to the list
			 * void add(int index, E element)	Adds an element to index and moves the rest
			 * E get(int index)					Returns element at index
			 * int indexOf(Object o)			Returns first matching index or -1
			 * int lastIndexOf(Object o)		Returns last matching index or -1
			 * E remove(int index)			
			 * E set(int index, E e)			
			 */
			List<String> list = new ArrayList<String>();
			
			list.add("SD");			System.out.println(list);
			list.add(0, "NY");		System.out.println(list);
			list.set(1, "FL");		System.out.println(list);
			list.remove("NY");		System.out.println(list);
			list.remove(0);			System.out.println(list);
			
			list.add("OH");			System.out.println(list);
			list.add("CO");			System.out.println(list);
			list.add("NJ");			System.out.println(list);
			
			System.out.println(list.get(0));
			System.out.println(list.indexOf("NJ"));
			
		}
		
		separe();

	}

}
