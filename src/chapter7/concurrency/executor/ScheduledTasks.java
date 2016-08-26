package chapter7.concurrency.executor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static lib.TextElements.separe;

public class ScheduledTasks {

	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService service = null;
		
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("mm:ss");
		
		try {
			
			service = Executors.newSingleThreadScheduledExecutor();
			
			Runnable task1 = ()->{
				System.out.println("1-Begin:\t" + formater.format(LocalTime.now()));
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("1-End:\t\t" + formater.format(LocalTime.now()));
				
				separe();
				
			};
			
			
			Runnable task2 = ()->{
				System.out.println("2-Begin:\t" + formater.format(LocalTime.now()));
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("2-End:\t\t" + formater.format(LocalTime.now()));
				
				separe();
				
			};
			
			
			service.scheduleAtFixedRate(task1, 0, 2, TimeUnit.SECONDS);
			service.scheduleAtFixedRate(task2, 0, 2, TimeUnit.SECONDS);
			
//			service.scheduleWithFixedDelay(task1, 0, 2, TimeUnit.SECONDS);
			
			
		} finally {
//			if(service != null) service.shutdown();
		}

	}

}
