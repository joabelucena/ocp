package chapter7.concurrency.synchronizing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager {
	
	//Atomic objects ensure that the object is not accessed for two threads at once
	private AtomicInteger atomicCount = new AtomicInteger(0);
	
	private int syncCount = 0;
	
	
	/*
	 * Guarantees order
	 */
	private void incrementSynchronously() {
		
		//synchronized blocks locks the block of code ensuring that only one thread will run this 
		//block at time creating a queue of threads until it's unlocked
		synchronized (this) {
			
			System.out.print( (++syncCount) + " ");
		}
	}
	
	/*
	 * Does NOT guarantees order
	 */
	private void incrementAtomically() {

		//Retrieving a value from the atomic object
		System.out.print( atomicCount.incrementAndGet() + " ");
	}

	public static void main(String[] args) {
		
		
		System.out.println("printAtomically - UNORDERED ");
		printAtomically();
		System.out.println();
		System.out.println("printSynchronously - ORDERED ");
		printSynchronously();

	}
	
	public static void printAtomically(){
		ExecutorService service = null;
		
		try {
			service = Executors.newFixedThreadPool(20);
			SheepManager manager = new SheepManager();
			
			for (int i = 0; i < 10; i++) {
				service.submit(()-> manager.incrementAtomically());	
			}
			
		} finally {
			if (service != null) service.shutdown();
		}
		
		try {
			service.awaitTermination(3, TimeUnit.SECONDS);
		} catch (Exception e) {
			
		}
	}
	
	
	public static void printSynchronously(){
		ExecutorService service = null;
		
		try {
			service = Executors.newFixedThreadPool(20);
			SheepManager manager = new SheepManager();
			
			for (int i = 0; i < 10; i++) {
				service.submit(()-> manager.incrementSynchronously());	
			}
			
		} finally {
			if (service != null) service.shutdown();
		}
		
		try {
			service.awaitTermination(3, TimeUnit.SECONDS);
		} catch (Exception e) {
			
		}
	}

}
