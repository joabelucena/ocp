package chapter7;

public class TestClass {

	public static void main(String[] args) {
		Runnable r = () -> System.out.println("Hello");
		
		Thread u = new Thread(r);
		Thread v = new Thread(r);
		Thread c = new Thread(r);
		Thread t = new Thread(r);
		
	}

}
