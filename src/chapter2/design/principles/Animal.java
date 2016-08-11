package chapter2.design.principles;

/*
 * Encapsulation principle.
 * 
 * Requirements:
 * 
 * - Non-null species
 * - Age greater than or equal to 0
 */
public class Animal {
	
	private String species;
	private int age;
	
	public Animal(String species) {
		this.setSpecies(species);
	}
	
	public String getSpecies() {
		return species;
	}
	
	public void setSpecies(String species) throws IllegalArgumentException {
		if(species == null || species.trim().length() == 0) {
			throw new IllegalArgumentException("Specie is required");
		}
		this.species = species;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws IllegalArgumentException {
		if(age < 0) throw new IllegalArgumentException("Age cannot be a negative number");
		this.age = age;
	}
	
}
