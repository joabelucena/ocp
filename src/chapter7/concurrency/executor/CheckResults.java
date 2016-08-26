package chapter7.concurrency.executor;

import java.util.concurrent.*;

public class CheckResults {
	private static int counter = 0;

	public static void main(String[] args) throws InterruptedException, ExecutionException{
		
		ExecutorService service = null;
		
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			
			Future<?> result = service.submit(()->{
				for(int i = 0; i < 500; i++) CheckResults.counter++;
				
				return "";
			});
			
			// Wait 10 seconds for getting the thread result or throw an Exception
			result.get(10, TimeUnit.SECONDS);
			
			System.out.println("reached");
			
			
			
		} catch (TimeoutException e) {
			System.out.println("Not reached int time");
			
		} finally {
			if(service != null) service.shutdown();
		}

	}

}
