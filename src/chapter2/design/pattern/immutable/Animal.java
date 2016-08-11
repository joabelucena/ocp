package chapter2.design.pattern.immutable;

import java.util.ArrayList;
import java.util.List;

/**
 * Immutable class.
 * 
 * Class is final for not be inherited
 * @author root
 *
 */
public final class Animal {
	
	/**
	 * All members must be private final
	 */
	private final String species;
	private final int age;
	private final List<String> favoriteFoods;
	
	/**
	 * Constructor must take and set all instance members
	 * 
	 * @param species
	 * @param age
	 * @param favoriteFoods
	 */
	public Animal(String species, int age, List<String> favoriteFoods) {
		this.species = species;
		this.age = age;
		
		if(favoriteFoods == null) throw new IllegalArgumentException("favoriteFoods is required");
		
		this.favoriteFoods = new ArrayList<String>(favoriteFoods);
	}
	
	/**
	 * No setters methods
	 * @return
	 */
	public String getSpecies() {
		return species;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getFavoriteFoodsCount() {
		return favoriteFoods.size();
	}
	
	public String getFavoriteFood(int index) {
		return favoriteFoods.get(index);
	}
	
	
	/**
	 * This method makes class mutable
	 * @return
	 */
	public List<String> getFavoriteFoods() {
		return favoriteFoods;
	}
	
	/**
	 * Correct implementation for "immutably" return a mutable object
	 * 
	 * @param x
	 * @return
	 */
	public List<String> getFavoriteFoods(int x) {
		return new ArrayList<String>(favoriteFoods);
	}
	
	@Override
	public String toString() {
		return "Animal: " + species + " | Favorite Foods: " + favoriteFoods;
	}
	
}
