package chapter2.functional.run;

import chapter2.functional.interfaces.CheckTrait;
import chapter2.functional.zoo.Animal;

public class FindMatchingAnimals {

	private static void print(Animal animal, CheckTrait trait) {
		if(trait.test(animal)) System.out.println(animal);
	}
	
	public static void main(String[] args) {
		
		int b = 0;
		
		print(new Animal("fish", false, true), a -> a.canHop());
		print(new Animal("kangaroo", true, false), a -> a.canHop());
		
		print(new Animal("fish", false, true), (Animal a) -> {return a.canSwim(); });
		
		print(new Animal("fish", false, true), (Animal a) -> {
			
			/*
			 * DOES NOT COMPILE: It's not allowed to redeclare local variables
			 */
//			int b = 0;
			int c = 0;
			
			/*
			 * DOES NOT COMPILE: It's not allowed to redeclare local variables
			 */
//			for(int b = 0; b < 4; b++){
//				
//			}
			
			
			return a.canSwim();
			
		});
		
	}

}
