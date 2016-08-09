package chapter1.inner.local;

public class EffectivelyFinal {
	
	public void isItFinal(){
		
		/*
		 * only 'one' variable is effectively final, because it is not changed along the program
		 */
		int one = 20;
		
		
		int two = one;
		two++;
		int three;
		if(one == 4) three = 3;
		else three = 4;
		int four = 4;
		class Inner {}
		four = 5;
	}
}
