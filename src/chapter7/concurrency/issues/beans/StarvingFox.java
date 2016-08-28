package chapter7.concurrency.issues.beans;


/**
 * This Fox doesn't wait after drinking/eating for eating/drinking
 * 
 * @author root
 *
 */
public class StarvingFox extends Fox {
	
	@Override
	public void eatAndDrink(Food food, Water water, String name) {
		synchronized (food) {
			System.out.println(name + " got Food!");
			
			//Doesn't move
			synchronized (water) {
				System.out.println(name + " got Water!");
			}
		}
	}
	
	@Override
	public void drinkAndEat(Food food, Water water, String name) {
		synchronized (water) {
			System.out.println(name + " got Water!");
			
			//Doesn't move
			synchronized (food) {
				System.out.println(name + " got Food!");
			}
		}
	}
}
