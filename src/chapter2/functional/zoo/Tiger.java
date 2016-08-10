package chapter2.functional.zoo;

import chapter2.functional.interfaces.Sprint;

public class Tiger implements Sprint {

	@Override
	public void sprint(Animal animal) {
		System.out.println("Animal is sprinting fast! " + animal.toString());
	}

}
