package chapter1.zoo.cat.species;

import chapter1.zoo.cat.BigCat;

public class Lynx extends BigCat {

	public static void main(String[] args) {
		BigCat cat = new BigCat();
		
		System.out.println(cat.name);
		System.out.println(cat.hasFur);		//DOES NOT COMPILE: Lynx extends BigCat and here we have a BigCat reference, not Lynx
		System.out.println(cat.hasPaws);	//DOES NOT COMPILE: Not same package
		System.out.println(cat.id);			//DOES NOT COMPILE: private member
		
	}

}
