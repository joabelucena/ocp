package chapter7.concurrency.executor;

import java.util.concurrent.*;

public class AwaitingTasks {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = null;
		
		try {
			service = Executors.newSingleThreadExecutor();
			
			service.submit(()-> {Thread.sleep(5000); return null;});
			
			service.submit(()-> {Thread.sleep(4000); return null;});
			
			service.submit(()-> {Thread.sleep(1000); return null;});
			
			//Total 10 seconds
			
		} finally {
			System.out.println("Shutting service down");
			if(service != null) service.shutdown();
		}

		if(service != null) {
			
			System.out.println("Awaiting termination");
			
			//Waits X (3) seconds because might have some tasks running..
			service.awaitTermination(3, TimeUnit.SECONDS);
			
			if(service.isTerminated()) {
				System.out.println("All tasks finished");
			} else {
				System.out.println("Some tasks still running");
				
				//Closes immediately  
				service.shutdownNow();
			}

		}

	}

}
