package chapter2.design.pattern.singleton;

/**
 * Lazily initialized singleton
 * 
 * @author root
 *
 */
public class VisitorTicketTracker {

	private static VisitorTicketTracker instance;
	
	private VisitorTicketTracker() {}
	
	/**
	 * This is not thred-safe because it could be called twice at once.
	 * 
	 * @return
	 */
	public static VisitorTicketTracker getInstance() {
		
		if(instance == null) {
			
			System.out.println("Initializing singleton: VisitorTicketTracker");
			
			instance = new VisitorTicketTracker();
			
		}
		
		return instance;
	}
	
	/**
	 * This is an overloaded thread-safe version of getInstance method once it gets synchronized
	 * modifier, it can't be called at the same time.
	 * This can cost performance also since every getInstance(int x) call is gonna be synchronized.
	 * 
	 * @param x
	 * @return
	 */
	public synchronized static VisitorTicketTracker getInstance(int x) {
		
		if(instance == null) {
			
			System.out.println("Initializing singleton: VisitorTicketTracker");
			
			instance = new VisitorTicketTracker();		//NOT THREAD-SAFE
			
		}
		
		return instance;
	}
	
	
	
	public static void sayHello() {
		System.out.println("Hello World");
	}
	
}
