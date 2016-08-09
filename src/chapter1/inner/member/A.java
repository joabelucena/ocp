package chapter1.inner.member;

public class A {
	private int x = 10;
	
	class B {
		private int x = 20;
		
		class C {
			private int x = 30;
			
			public void allTheX() {
				System.out.println(x);			//30 prints its x
				System.out.println(this.x);		//30 print its x
				System.out.println(B.this.x);	//Refer to B class, then 'this' (B) then x
				System.out.println(A.this.x);	//Refer to A class, then 'this' (A) then x
			}
		}
	}
	
	
	public static void main(String...args){
		A a = new A();
		A.B b = a.new B();		//To instantiate, use dot (.) for referring to class you want
		A.B.C c = b.new C();
		
		
		B b2 = new A().new B();
		
		A.B.C c2 = new A().new B().new C();
		B.C c3 = new A().new B().new C();
		
		c.allTheX();
	}
}
