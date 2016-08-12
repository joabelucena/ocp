package chapter3.generics.legacy;

import java.util.ArrayList;
import java.util.List;

class Dragon { }
class Unicorn { }

public class LegacyDragons {

	public static void main(String[] args) {
		List unicorns = new ArrayList();
		unicorns.add(new Unicorn());
		printDragons(unicorns);

	}
	
	private static void printDragons(List<Dragon> dragons) {
		
		/*
		 * ClassCastException unchecked list
		 */
		for (Dragon dragon : dragons) {
			System.out.println(dragon);
		}
	}

}
