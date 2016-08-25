package chapter7.intro;

public class TestClass {

	public static void main(String[] args) {
		
		for (int i = 0; i < 5; i++) {
			System.out.println("begin");
			
			(new ReadInventory()).start();
			(new Thread(new PrintData())).start();
			(new ReadInventory()).start();
			
			System.out.println("end");	
		}		
		
	}

}
