package lib;

public class Car {
	
	public static int test;
	
	private String brand;
	
	private String model;
	
	public Car(){
		super();
	}
	
	public Car(String brand, String model) {
		super();
		this.brand = brand;
		this.model = model;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
}
