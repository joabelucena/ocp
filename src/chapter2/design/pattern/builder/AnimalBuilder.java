package chapter2.design.pattern.builder;

import java.util.List;

import chapter2.design.pattern.immutable.Animal;

/**
 * This a Animal builder class. It holds the same attributes of an Animal class and has the method
 * build() tha returns an Animal. This is a solution for growing constructors
 */
public class AnimalBuilder {
	
	/**
	 * Attributes of Animal class
	 */
	private String species;
	private int age;
	private List<String> favoriteFoods;
	
	/**
	 * Setters methods returning an instance of this. The reason that they return 'this' is that
	 * these methods are commonly chained
	 * 
	 * @param age
	 * @return
	 */
	public AnimalBuilder setAge(int age) {
		this.age = age;
		return this;
	}
	
	public AnimalBuilder setSpecies(String species) {
		this.species = species;
		return this;
	}
	
	public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
		return this;
	}
	
	/**
	 * Finally we have the method build tha actually constructs an instance of Animal.
	 * @return
	 */
	public Animal build() {
		return new Animal(species, age, favoriteFoods);
	}
}
