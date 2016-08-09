package chapter1.zoo;

public abstract class Animal {
	String name = "???";
	
	public abstract void feed();
	
	public void printName(){
		System.out.println(name);
	}
	public void careFor() {
		play();
	}
	public void play() {
		System.out.println("pet animal");
	}
	
}

/*
 * Cow class
 */
class Cow extends Animal {
	private void addHay() {}
	
	public void feed() { addHay(); }
}

/*
 * Bird class
 */
class Bird extends Animal {
	private void addSeed() {}
	
	public void feed(){ addSeed(); }
}

/*
 * Lion class
 */
class Lion extends Animal {
	String name = "Leo";
	private void addMeat() {}
	
	public void feed(){ addMeat(); }
	
	public void play() {
		System.out.println("toss in meat");
	}
	
}