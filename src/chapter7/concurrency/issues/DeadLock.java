package chapter7.concurrency.issues;

import java.util.concurrent.*;

import chapter7.concurrency.issues.beans.Food;
import chapter7.concurrency.issues.beans.Fox;
import chapter7.concurrency.issues.beans.Water;

/**
 * DeadLock example
 * 
 * @author root
 *
 */
public class DeadLock {

	public static void main(String[] args) {
		Fox foxy = new Fox();
		Fox tails = new Fox();
		
		Food food = new Food();
		Water water = new Water();
		
		//Process whole thing
		ExecutorService service = null;
		
		try {
			service = Executors.newFixedThreadPool(10);
			
			/*
			 * Waits forever because resources are locked
			 */
			service.submit(() -> foxy.eatAndDrink(food, water, "Foxy"));
			service.submit(() -> tails.drinkAndEat(food, water, "Tails"));
			
			
		} finally {
			if (service != null) service.shutdown();
		}

	}

}
