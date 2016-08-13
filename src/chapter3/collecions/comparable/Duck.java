package chapter3.collecions.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Duck implements Comparable<Duck> {
	
	private String name;
	private double weight;
	
	public Duck(String name){
		this(name, 5);
	}
	
	public Duck(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String toString() {
		return name;
	}
	
	public int compareTo(Duck d) {
		return name.compareTo(d.name);
	}
	
	public static void main(String...args) {
		List<Duck> ducks = new ArrayList<>();
		ducks.add(new Duck("Quack"));
		ducks.add(new Duck("Puddles"));
		
		Collections.sort(ducks);
		System.out.println(ducks);
	}
}
