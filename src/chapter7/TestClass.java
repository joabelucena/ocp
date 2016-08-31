package chapter7;

import static lib.TextElements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class TestClass {

	public static void main(String[] args) {
		{
			Runnable r = () -> System.out.println("Hello");

			Thread u = new Thread(r);
			Thread v = new Thread(r);
			Thread c = new Thread(r);
			Thread t = new Thread(r);
		}

		separe();

		{
			BlockingDeque<Integer> deque = new LinkedBlockingDeque<Integer>();

			try {
				deque.offer(103);
				deque.offerFirst(20, 1, TimeUnit.SECONDS);
				deque.offerLast(85, 7, TimeUnit.HOURS);
				System.out.print(deque.pollFirst(200, TimeUnit.NANOSECONDS));
				System.out.println(" " + deque.pollLast(1, TimeUnit.MINUTES));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		separe();

		{
			final List<Future<?>> results = new ArrayList<Future<?>>();

			ExecutorService service = Executors.newSingleThreadExecutor();

			IntStream.range(0, 10).forEach(
					i -> results.add(service.submit(() -> i)));

			service.shutdown();

		}

		separe();

		{
			Thread cool = new CoolThread("Java");
			cool.start();
		}

		separe();

		{
			ExecutorService es = Executors.newSingleThreadExecutor();
			Future<String> future = es.submit(() -> {
				Thread.sleep(2000);
				return "DONE";
			});
			
			try {
				System.out.println(future.get(1, TimeUnit.SECONDS)); // 1
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			es.shutdownNow(); //2
		}

	}

}
