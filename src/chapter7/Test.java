package chapter7;

public class Test extends Thread {
	static int x, y;

	public synchronized void run() {
		for (;;) {
			x++;
			y++;
			System.out.println(x + " " + y);
			
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

	public static void main(String[] args) {
		Thread a = new Test();
		Thread b = new Test();
		
		a.start();
		b.start();
		
		try {
			a.join();
			b.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
