package chapter3.generics.methods;

import chapter3.generics.classes.Crate;

public class GenericMethods {
	
	/**
	 * The formal parameter type must be right before the return type:
	 * 
	 * public <T> return_type method_name() { }
	 * 
	 * @param t
	 */
	
	public static <T> void ship(T t){
		
		System.out.println("Preparing " + t);
		
	}
	
	public static <T> Crate<T> ship() {
		
		return new Crate<>();
	}
	
	public static <T> void sink(T t) { }
	
	public static <T> T indetity(T t) { return t; }
	
	
	public static T noGood(T t) { return t; }
}
