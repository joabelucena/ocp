package chapter7.concurrency.issues;

import java.util.concurrent.*;

import chapter7.concurrency.issues.beans.Food;
import chapter7.concurrency.issues.beans.Fox;
import chapter7.concurrency.issues.beans.StarvingFox;
import chapter7.concurrency.issues.beans.Water;

/**
 * DeadLock example
 * 
 * @author root
 *
 */
public class Starvation {

	public static void main(String[] args) {
		Fox foxy = new Fox();
		StarvingFox starving = new StarvingFox();
		
		Food food = new Food();
		Water water = new Water();
		
		//Process whole thing
		ExecutorService service = null;
		
		try {
			service = Executors.newFixedThreadPool(10);
			
			/*
			 * Foxy went to complete her task...
			 */
			Future<?> eaten = service.submit(() -> foxy.eatAndDrink(food, water, "Foxy"));
			
			/*
			 * But she is really slow and every time she goes for eating, an starving fox rushes before her
			 */
			while(!eaten.isDone()){
				service.submit(() -> starving.eatAndDrink(food, water, "Starving Fox"));
			}
			
		} finally {
			if (service != null) service.shutdown();
		}

	}

}
