package chapter2.design.pattern.singleton;

public class HayStorage {
	
	/**
	 * Regular member fields
	 */
	private int quantity = 0;
	
	/**
	 * The Singleton
	 * Here we have a HayStorage instance that composes our HayStorageSingleton class
	 */
	private static final HayStorage instance = new HayStorage();
	
	/**
	 * Here we declare a private constructor that avoids the compiler to create a default one and
	 * users to instantiate our class.
	 * 
	 * When marking the constructor as private, the class becomes effectively final
	 */
	private HayStorage() {}
	
	/**
	 * Method for accessing singleton
	 */
	public static HayStorage getInstance() {
		return instance;
	}
	
	public synchronized void addHay(int amount) {
		quantity += amount;
	}
	
	public synchronized boolean removeHay(int amount) {
		
		if(quantity < amount) return false;
		quantity -= amount;
		
		return true;
	}
	
	public synchronized int getHayQuantity() {
		return quantity;
	}
	
	
}
