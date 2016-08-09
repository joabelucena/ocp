package chapter1.zoo;

public class PlayWithAnimal {

	public static void main(String[] args) {
		Animal animal = new Lion();
		
		Lion lion = new Lion();
		
		animal.printName();		//prints ??? because variables are hidden, not overriden
		
		lion.printName();

	}

}
