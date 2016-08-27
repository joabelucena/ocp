package chapter7.concurrency.management;

import java.util.concurrent.*;

public class LionPenManager {
	
	//WAITING THREAD TIME IN SECONDS
	private static final int THREAD_TIME = 2;

	private void removeAnimals(){
		System.out.println("Removing animals");
		try {
			Thread.sleep(THREAD_TIME * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void cleanPen() {
		System.out.println("Cleaning pen");
		try {
			Thread.sleep(THREAD_TIME * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void addAnimals() {
		System.out.println("Adding animals");
		try {
			Thread.sleep(THREAD_TIME * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void performTask(CyclicBarrier c1, CyclicBarrier c2) {
		try {
			removeAnimals();
			
			c1.await();
			
			cleanPen();
			
			c2.await();
			
			addAnimals();	
		} catch (InterruptedException | BrokenBarrierException e) {
			//
		}
		
	}
	
	public static void main(String[] args) {
		
		ExecutorService service = null;
		
		int workers = 4;
		
		try {
			service = Executors.newFixedThreadPool(workers);
			
			LionPenManager manager = new LionPenManager();
			
			CyclicBarrier c1 = new CyclicBarrier(workers);
			CyclicBarrier c2 = new CyclicBarrier(workers, () -> System.out.println("*** Pen Cleaned!"));
			
			for(int i = 0; i < workers; i++)
				service.submit(() -> manager.performTask(c1, c2));
			
			
		} finally {
			if (service != null) service.shutdown();
		}

	}

}
