package chapter7.intro;

public class TestClass {

	public static void main(String[] args) {
		
		System.out.println("begin");
		
		(new ReadInventory("1")).start();
		(new Thread(new PrintData("2"))).start();
		(new ReadInventory("5")).start();
		
		System.out.println("end");	
				
		
	}

}
