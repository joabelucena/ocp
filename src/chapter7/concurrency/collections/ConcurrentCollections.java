package chapter7.concurrency.collections;

import java.util.*;
import java.util.concurrent.*;

import static lib.TextElements.miniSepare;
import static lib.TextElements.separe;

public class ConcurrentCollections {

	public static void main(String[] args) {
		
		{
			/*
			 * ConcurrentHashMap
			 */
			Map<String, Integer> map = new ConcurrentHashMap<>();
			map.put("zebra", 52);
			map.put("elephant", 10);
			
			System.out.println(map.get("elephant"));
			
		}

		separe();
		
		{
			/*
			 * ConcurrentLinkedQueue
			 */
			Queue<Integer> queue = new ConcurrentLinkedQueue<>();
			
			// ##### <--- #
			queue.offer(31);
			
			// get this guy ---> # #####
			System.out.println(queue.peek());
			
			// get and remove this guy # <--- #####
			System.out.println(queue.poll());
			
		}
		
		separe();
		
		{
			/*
			 * ConcurrentLinkedDeque
			 */
			Deque<Integer> deque = new ConcurrentLinkedDeque<>();
			
			// ##### <--- #
			deque.offer(10);
			
			// # ---> #####
			deque.push(4);
			
			// get this guy ---> # #####
			System.out.println(deque.peek());
			
			// get and remove this guy  # <--- #####
			System.out.println(deque.pop());
			
		}
		
		separe();
		
		{
			/*
			 * Blocking Collections
			 */
			
			{
				/*
				 * LinkedBlockingQueue
				 */
				try {
					BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
					
					blockingQueue.offer(39);
					
					System.out.println("Offering...");
					blockingQueue.offer(3, 4, TimeUnit.SECONDS);
					
					System.out.println(blockingQueue.poll());
					
					System.out.println("Polling...");
					System.out.println(blockingQueue.poll(4, TimeUnit.SECONDS));
					
				} catch (InterruptedException e) {
					// Handle Interruption
				}
			}
			
			miniSepare();
			
			{
				/*
				 * LinkedBlockingQueue
				 */
				try {
					BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
					
					
					// 5 91 47 3
					
					blockingDeque.offer(91);
					blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
					blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
					
					blockingDeque.offer(3, 4, TimeUnit.SECONDS);
					
					System.out.println(blockingDeque);
					
					System.out.println(blockingDeque.poll());								// 5
					System.out.println(blockingDeque.poll(950, TimeUnit.MICROSECONDS));		// 91
					System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS));	// 47
					System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));		// 3
					
				} catch (InterruptedException e) {
					
				}
			}
		}
		
		separe();
		
		{
			/*
			 * SkipList collections SORTED
			 */
			{
				Set<Integer> set = new ConcurrentSkipListSet<Integer>();
				
				for (Integer item : set) {
					System.out.print(item + " ");
				}
				
				set.add(4);
				set.add(2);
				set.add(8);
				set.add(18);
				set.add(90);
				set.add(56);
				
				System.out.println(set);

			}
			
			miniSepare();
			
			{
				Map<Integer, String> map = new ConcurrentSkipListMap<>();
				
				map.put(3, "lion");
				map.put(2, "sheep");
				map.put(1, "zebra");
				
				System.out.println(map);
			}
			
		}
		
		separe();
		
		{
			/*
			 * CopyOnWriteArraySet
			 * CopyOnWriteArrayList
			 */
			List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
			
			System.out.println(list);
			
			// Iterates over the original list: [4, 3, 52]
			for (Integer item : list) {
				System.out.print(item + " ");
				list.add(9);
			}
			
			System.out.println();
			System.out.println("Size: " + list.size());
		}
		
		separe();
		
		{
			/*
			 * Collections.synchronizedCollection();
			 * 
			 * Generates synchronized collection from regular collections.
			 * 
			 * Collections generated from these methods have only get() and set() methods synchronized 
			 * 
			 */
			List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>(Arrays.asList(4, 3, 52)));
			
			synchronized (list) {
				for (Integer data : list) {
					System.out.print(data + " ");
				}
			}
			
			//Throws exception as regular collection would do
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("penguin"	, 1);
			map.put("flamingo"	, 2);
			
			Map<String, Object> syncMap = Collections.synchronizedMap(map);
			
			for (String key : syncMap.keySet()) {
				syncMap.remove(key);
			}
		}
		
		
		
	}

}
