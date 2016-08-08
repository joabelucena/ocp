package chapter1.zoo.mouse;

import chapter1.cat.BigCat;

public class Mouse {
	public static void main(String[] args) {
		BigCat cat = new BigCat();
		
		System.out.println(cat.name);
		System.out.println(cat.hasFur);		//DOES NOT COMPILE: Not same package or extending
		System.out.println(cat.hasPaws);	//DOES NOT COMPILE: Not same package
		System.out.println(cat.id);			//DOES NOT COMPILE: Private member
		
	}
}
