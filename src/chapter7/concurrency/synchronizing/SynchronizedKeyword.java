package chapter7.concurrency.synchronizing;

public class SynchronizedKeyword {
	
	public synchronized void printA() {
		System.out.println("A");
	}
	
	public void printB(){
		synchronized (this) {
			System.out.println("B");
		}
	}
	
	public synchronized static void printC() {
		System.out.println("C");
	}
	
	public static void printD(){
		synchronized (SynchronizedKeyword.class) {
			System.out.println("D");
		}
	}
	
	
}
