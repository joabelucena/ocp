package enthuware;

import chapterA.TestConnect;
import lib.TextElements;

abstract class Abs {
	public Abs(int x) {}
	public Abs() {}
}

public class Foundation extends TextElements {
	
	int instance = 0;
	
	static int stat = 0;
	
	/*
	 * Member class
	 */
	public class NonStatic {
		final static int x = 0;
		
		void print(){
			System.out.println(instance);
			
			Foundation f = new Foundation(){
				public double pi() { return 3.1415; }
			};
			
			
		}
	}
	
	/*
	 * Static member class
	 */
	static class StaticClass {
		static int zeta = 0;
		int beta = 0;
	}
	
	void m1() {
		
		/*
		 * Local class
		 */
		class Inner1{
			final static int ab = 0;
			
		}
	}
	
	static void m2() {
		
		class Inner2 {
			void print(){
				System.out.println(stat);
			}
		}
		
		TestConnect tc = new TestConnect(){
			public double pi() { return 3.1415; }
		};
		
		
		
		/*
		 * Anonymous class
		 */
		new Abs() {
		};
		
		new Abs(10) {
		};
		
		
	}

	public static void main(String[] args) {
		
		{
			Thread a = new Thread();
			
		}
		
		separe();
		
		{
			
		}

	}

}
