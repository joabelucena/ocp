package chapter3.generics.classes;

/**
 * This is a generic class. 
 * 
 * You can put anything you want as generic parameter, in this case is 'Generic'.
 * 
 * But, there are naming conventions for generics and the convention is to use a uppercase letter
 * to make clear it is not a class. There apre-defined common letters in this convention also, here 
 * they are:
 * 
 * E - Element
 * K - Map key
 * V - Map value
 * N - Number
 * T - Generic data type
 * 
 * @author root
 *
 * @param <Generic>
 */
public class Crate<Generic> {
	
	private Generic contents;
	
	public Generic emptyCrate() {
		Generic a = contents;
		contents = null;
		
		return a;
	}
	
	public void packCrate(Generic contents) {
		this.contents = contents;
	}
}
