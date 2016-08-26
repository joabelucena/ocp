package chapter7.intro;

public class PrintData implements Runnable {

	private String order;
	
	public PrintData(String order){
		this.order = order;
	}
	
	@Override
	public void run() {
		for(int i=0; i<3; i++)
			System.out.println(order + "-Printing record: " + i);

	}

}
