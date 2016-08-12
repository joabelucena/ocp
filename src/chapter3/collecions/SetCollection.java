package chapter3.collecions;

import static lib.TextElements.miniSepare;
import static lib.TextElements.separe;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Animal {
	String species;

	Animal(String s) { this.species = s; }
	
	public int hashCode() {
		return 1;
	}
	
	public boolean equals(Object o) {
//		return true;
		return ((Animal) o).species == this.species;
	}
}

public class SetCollection {

	public static void main(String[] args) {

		/**
		 * Set interface has some implementations, here are the most common followed by its 
		 * characteristics:
		 * 
		 *  Implementation	Description
		 * ----------------------------------------------------------------------------------------
		 *  HashSet			Add and search time O(1).
		 *  TreeSet			Store elements in a tree. It is always sorted. Search/add time O(log n)		
		 *    
		 */

		{
			/*
			 * Example of implementation of equals() and hashCode() and Set behavior
			 */
			Set<Animal> animals = new HashSet<>();
			Set<Animal> an = new TreeSet<>();
			
			System.out.println(animals.add(new Animal("lion")));
			System.out.println(animals.add(new Animal("sheep")));
			System.out.println(animals.add(new Animal("lion")));
			
		}

		separe();
		
		{
			/*
			 * HashSet unsorted example
			 */
			Set<Integer> set = new HashSet<Integer>();
			
			System.out.println(set.add(66));
			System.out.println(set.add(10));
			System.out.println(set.add(66));
			System.out.println(set.add(8));
			
			System.out.println(set);
		}
		
		separe();
		
		{
			TreeSet<Integer> set = new TreeSet<Integer>();
			
			System.out.println(set.add(9));
			System.out.println(set.add(7));
			System.out.println(set.add(5));
			System.out.println(set.add(3));
			System.out.println(set.add(1));
			
			miniSepare();
			
			System.out.println("Lower from 6: " 	+ set.lower(6));
			System.out.println("Floor from 6: " 	+ set.floor(6));
			System.out.println("Ceiling from 6: " 	+ set.ceiling(6));
			System.out.println("Higher from 6: " 	+ set.higher(6));
			
			miniSepare();
			
			System.out.println(set);
		}

	}

}
