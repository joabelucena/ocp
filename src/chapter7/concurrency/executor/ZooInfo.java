package chapter7.concurrency.executor;

import java.util.concurrent.*;

public class ZooInfo {

	public static void main(String[] args) {
		ExecutorService service = null;
		
		try {
			service = Executors.newSingleThreadExecutor();
			
			System.out.println("begin");
			
			// Thread 1
			service.execute(()->{
				System.out.println("1-Printing zoo inventory");
			});
			
			// Thread 2
			service.execute(()->{
				for(int i=0; i<3; i++)
					System.out.println("2-Printing record: " + i);
			});
			
			// Thread 3
			service.execute(()->{
				System.out.println("3-Printing zoo inventory");
			});
			
			System.out.println("end");
			
		} finally {
			if(service != null) service.shutdown();
		}

	}

}
