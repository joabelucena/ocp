package chapter7.concurrency.issues.beans;

/**
 * DeadLock example
 * 
 * @author root
 *
 */
public class Fox {

	public void eatAndDrink(Food food, Water water, String name) {
		move();
		synchronized (food) {
			System.out.println(name + " got Food!");
			move();
			synchronized (water) {
				System.out.println(name + " got Water!");
			}
		}
	}
	
	public void drinkAndEat(Food food, Water water, String name) {
		move();
		synchronized (water) {
			System.out.println(name + " got Water!");
			move();
			synchronized (food) {
				System.out.println(name + " got Food!");
			}
		}
	}
	
	public void move() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
