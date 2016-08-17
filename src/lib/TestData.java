package lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestData {
	private static final List<String> animals = Arrays.asList("lion", "sheep", "caw", "zebra");
	
	private static final List<Integer> numbers = Arrays.asList(23,42,54,65,11,73);
	
	private static final List<String> names = Arrays.asList("John", "Annie", "Robert", "Zack");
	
	private static final List<String> cats = Arrays.asList("Simba", "George", "Max", "Kitty");

	public static final List<String> getAnimals() {
		return new ArrayList<String>(animals);
	}
	
	public static final Stream<String> getAnimals(Integer i) {
		return animals.stream();
	}

	public static final List<Integer> getNumbers() {
		return new ArrayList<Integer>(numbers);
	}
	
	public static final Stream<Integer> getNumbers(Integer i) {
		return numbers.stream();
	}

	public static final List<String> getNames() {
		return new ArrayList<String>(names);
	}

	public static final Stream<String> getNames(Integer i) {
		return names.stream();
	}
	
	public static final List<String> getCats() {
		return new ArrayList<String>(cats);
	}
	
	public static final Stream<String> getCats(Integer i) {
		return cats.stream();
	}
}
