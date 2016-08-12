package chapter3.generics.legacy;

import java.util.ArrayList;
import java.util.List;

public class LegacyUnicorns {

	public static void main(String[] args) {
		List<Unicorn> unicorns = new ArrayList();
		addUnicorn(unicorns);
		
		/*
		 * ClassCastException unchecked list
		 */
		Unicorn unicorn = unicorns.get(0);
	}
	
	public static void addUnicorn(List unicorn) {
		unicorn.add(new Dragon());
	}

}
