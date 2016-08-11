package chapter2;

import static lib.TextElements.separe;
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

	}

}
