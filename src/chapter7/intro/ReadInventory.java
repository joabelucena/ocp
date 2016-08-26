package chapter7.intro;

public class ReadInventory extends Thread {
	
	private String order;
	
	public ReadInventory(String order){
		this.order = order;
	}
	@Override
	public void run() {
		System.out.println(order + "-Printing zoo inventory");
	}
}
