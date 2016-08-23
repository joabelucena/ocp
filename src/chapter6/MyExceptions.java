package chapter6;

class DangerInTheWaterException extends RuntimeException {}

class SharkInTheWaterException extends DangerInTheWaterException {}

public class MyExceptions {
	
	public void swim() throws CannotSwimException {
		
	}
	
	public static void main(String[] args) throws CannotSwimException {
		throw new CannotSwimException("lalalal");
	}
}
