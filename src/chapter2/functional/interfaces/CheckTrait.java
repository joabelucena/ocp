package chapter2.functional.interfaces;

import chapter2.functional.zoo.Animal;

@FunctionalInterface
public interface CheckTrait {
	public boolean test(Animal a);
}
