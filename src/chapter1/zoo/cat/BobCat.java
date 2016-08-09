package chapter1.zoo.cat;

public class BobCat {
	public void findDen(){}
}

class BobCatMother extends BobCat {
	@Override
	public void findDen() {}
	
	/*
	 * DOES NOT COMPILE: @Override tells the compiler the following method is being overriding. Since there's not method
	 * with the signature findDen(boolean c) within superclass, the code doesn't compile
	 */
	@Override
	public void findDen(boolean c) {}
}
