package chapter1.inner.statics;

import chapter1.inner.statics.Anonymous.AnonymousInnerClass;

public class Enclosing {
	static class Nested {
		private int price = 6;
	}

	public static void main(String[] args) {
		
		
		Nested nested = new Nested();
		System.out.println(nested.price);
		
		/*
		 * Static nested classes can be instantiated just like other regular classes
		 */
		AnonymousInnerClass a = new AnonymousInnerClass();
		System.out.println(a.id);
		
		

	}

}
