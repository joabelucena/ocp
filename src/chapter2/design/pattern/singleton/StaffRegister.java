package chapter2.design.pattern.singleton;

public class StaffRegister {
	private static final StaffRegister instance;
	
	static {
		System.out.println("Initializing singleton: StaffRegister");
		
		instance = new StaffRegister();
		/*
		 * Perform additional steps, for example throwing an exception.
		 * 
		 * This is awesome!
		 */
		
	}
	
	private StaffRegister() {}
	
	public static StaffRegister getInstance() {
		return instance;
	}
	
	/*
	 * Data access methods
	 */
	public static void sayHello() {
		System.out.println("Hello World");
	}
}
