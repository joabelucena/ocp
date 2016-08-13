package chapter3.collecions.sort;

import java.util.*;

public class SortRabbits {

	static class Rabbit {
		int id;
	}

	public static void main(String[] args) {
		List<Rabbit> rabbits = new ArrayList<>();
		rabbits.add(new Rabbit());

		Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;

		Collections.sort(rabbits, c);
		
		Set<Rabbit> rabbitSet = new TreeSet<>();
		
		/*
		 * Throws ClassCastException because it doesn't implement Comparable and it TreeSet is 
		 * ordered
		 */
//		rabbitSet.add(new Rabbit());
		
		Set<Rabbit> rabbit = new TreeSet<>(new Comparator<Rabbit>() {
			public int compare(Rabbit r1, Rabbit r2){
				return r1.id-r2.id;
			}
		});
		
		rabbit.add(new Rabbit());

	}

}
