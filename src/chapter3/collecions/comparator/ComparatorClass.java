package chapter3.collecions.comparator;

import java.util.*;

import chapter3.collecions.comparable.Duck;


public class ComparatorClass {

	public static void main(String[] args) {
		
		Comparator<Duck> byWeight = new Comparator<Duck>() {
			public int compare(Duck d1, Duck d2) {
				return (int) (d1.getWeight() - d2.getWeight());
			}
		};
		
		List<Duck> ducks = new ArrayList<Duck>();
		ducks.add(new Duck("Quack"	, 7));
		ducks.add(new Duck("Puddles", 10));
		
		Collections.sort(ducks, byWeight);
		System.out.println(ducks);
		
		Collections.sort(ducks);
		System.out.println(ducks);
		
	}

}
