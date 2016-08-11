package chapter2;

import static lib.TextElements.separe;

import java.util.Arrays;

import chapter2.design.pattern.builder.AnimalBuilder;
import chapter2.design.pattern.immutable.Animal;
import chapter2.design.pattern.singleton.HayStorage;
import chapter2.design.pattern.singleton.StaffRegister;
import chapter2.design.pattern.singleton.VisitorTicketTracker;

public class TestClass {

	public static void main(String[] args) {
		
		{
			HayStorage s1 = HayStorage.getInstance();
			HayStorage s2 = HayStorage.getInstance();
			
			System.out.println(s1==s2);
			
		}
		
		separe();
		
		{
			StaffRegister r1 = StaffRegister.getInstance();
			StaffRegister r2 = StaffRegister.getInstance();
			
		}
		
		separe();
		
		{
			/*
			 * For understanding this, we might not have any instances of StaffRegister and
			 * VisitorTicketTracker active 
			 */
			StaffRegister.sayHello();
			VisitorTicketTracker.sayHello();
			
			StaffRegister.getInstance();
			VisitorTicketTracker.getInstance();
		}
		
		separe();
		
		{
			/*
			 * Immutability
			 */
			Animal lion = new Animal("Lion", 5, Arrays.asList("meat", "more meat"));
			
			Animal updatedLion = new Animal(lion.getSpecies(), lion.getAge(), lion.getFavoriteFoods());
			
			System.out.println(lion + "" + lion.hashCode());
			System.out.println(updatedLion + "" + updatedLion.hashCode());
		}
		
		separe();
		
		{
			AnimalBuilder lionBuilder = new AnimalBuilder();
			
			lionBuilder.setSpecies("Lion")
						.setAge(5)
						.setFavoriteFoods(Arrays.asList("meat", "more meat"));
			
			Animal lion = new Animal("Lion", 5, Arrays.asList("meat", "more meat"));
			Animal lion2 = lionBuilder.build();
			
			System.out.println(lion);
			System.out.println(lion2);
			
			
		}

	}

}
