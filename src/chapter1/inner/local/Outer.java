package chapter1.inner.local;

public class Outer {
	private int length = 5;

	/*
	 * method holding an inner class
	 */
	public void calculate() {
		int width = 20;
		
		/*
		 * class inside method
		 */
		class Inner {
			public void multiply() {
				System.out.println(length * width);
			}

		}
		
		/*
		 * Calling inner class method
		 */
		Inner inner = new Inner();
		inner.multiply();
	}
	
	public static void main(String...args){
		Outer outer = new Outer();
		outer.calculate();
		
	}

}
