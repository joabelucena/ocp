package chapter2.design.pattern.factory;

public class Pellets extends Food {
	
	public Pellets(int quantity) {
		super(quantity);
	}

	@Override
	public void consumed() {
		System.out.println("Pellets eaten: " + getQuantity());

	}

}
