package chapter6;

class TurkeyCage implements AutoCloseable {
	public void close() {
		System.out.println("Close gate!");
	}
}

public class AutoCloseableInterface {

	public static void main(String[] args) {
		
		try(TurkeyCage t = new TurkeyCage()) {
			System.out.println("put Turkeys in");
		}
		
		// Lambda practicing =P
		AutoCloseable c = () -> System.out.println("Closing...");
		
	}

}
