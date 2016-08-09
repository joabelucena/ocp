package chapter1.zoo;

interface Mother{}

class HeavyAnimal {}
class Hippo extends HeavyAnimal {}

/*
 * This is the reason compiler doesn't check right-hand operand when its an interface
 */
class MotherHippo extends Hippo implements Mother {}

public class Elephant extends HeavyAnimal{

	public static void main(String[] args) {
		
		HeavyAnimal hippo = new Hippo();
		
		System.out.println(hippo instanceof Hippo);			//true
		System.out.println(hippo instanceof HeavyAnimal);	//true
		System.out.println(hippo instanceof Elephant);		//false
		
		System.out.println(hippo instanceof Object);		//true
		
		Hippo nullHippo = null;
		
		System.out.println(nullHippo instanceof Object);	//false
		
		Hippo anotherHippo = new Hippo();
		
//		System.out.println(anotherHippo instanceof Elephant);	//DOES NOT COMPILE: Since Elephant has no relation with Hippo at all, the code will not compile.
		
		System.out.println(new MotherHippo() instanceof Mother);
		
		System.out.println(new MotherHippo() instanceof HeavyAnimal);

	}

}
