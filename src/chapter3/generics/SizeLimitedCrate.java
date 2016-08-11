package chapter3.generics;

/*
 * Generics references use in this case are: T for Type and U for Unit
 */
public class SizeLimitedCrate<T, U> {
	private T contents;
	private U sizeLimit;
	
	public SizeLimitedCrate(T contents, U sizeLimit) {
		this.contents = contents;
		this.sizeLimit = sizeLimit;
	}
	
}
