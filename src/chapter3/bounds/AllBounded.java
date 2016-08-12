package chapter3.bounds;

import java.util.*;

class A { }
class B extends A { }
class C extends B { }

public class AllBounded {

	public static void main(String[] args) {
		
		List<?>				list1 = new ArrayList<A>();
		List<? extends A> 	list2 = new ArrayList<A>();
		List<? super A> 	list3 = new ArrayList<A>();
		List<? extends B> 	list4 = new ArrayList<A>();
		List<? super B> 	list5 = new ArrayList<A>();
		List<?> 			list6 = new ArrayList<? extends A>();

	}
	
	/*
	 * VALID
	 */
	<T> T method1(List<? extends T> list) {
		return list.get(0);
	}
	
	/*
	 * INVALID
	 */
	<T> <? extends T> method2(List<? extends T> list) {
		return list.get(0);
	}
	
	/*
	 * VALID
	 */
	<T extends A> B method3(List<T> list) { 
		return new B();
	}
	
	/*
	 * INVALID: Take CARE! This is invalid because B, in this method, was shadowed by the type on
	 * <B extends A> and so on it can't be instantiated 
	 */
	<B extends A> B method3a(List<B> list) { 
		return new B();
	}
	
	/*
	 * VALID
	 */
	void method4(List<? super B> list) {
		
	}
	
	/*
	 * INVALID
	 */
	<X> void method5(List<X super B> list) {
		
	}
	
	

}
