package chapter1;

import java.io.IOException;

class MySuperClass {
	
	protected void broaderAccess(){}
	
	public Number covariantReturn() { return 0; }
	
	public void subException() throws Exception {}
	
}

public class Overriding extends MySuperClass {

	/*
	 * Overriding occurs when the method signature* is the same as superclass.
	 * 
	 * Method signature = method_name + argument_list
	 */
	public void broaderAccess() {}
	
	public Integer covariantReturn(){ return 0;}
	
	public void subException() throws IOException {}
	
}
