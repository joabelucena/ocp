package chapter8.serialize;

import java.io.Serializable;

public class Animal implements Serializable {
	private static final long serialVersionUID = 2L;
	
	private transient String name;
	private transient int age = 10;
	private static char type = 'C';
	{this.age = 14;}
	
	public Animal() {
		this.name = "Unknown";
		this.age = 12;
		type = 'Q';
	}
	
	public Animal(String name, int age, char t) {
		this.name = name;
		this.age = age;
		type = t;
	}

	public final String getName() {
		return name;
	}

	public final int getAge() {
		return age;
	}

	public final char getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
	}
	
}
