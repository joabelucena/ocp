package chapter1.year;

import static lib.TextElements.*;

public class TestEnums {

	public static void main(String[] args) {

		{
			Season s = Season.SUMMER;
			System.out.println(s);
			System.out.println(s == Season.SUMMER);
		}

		separe();

		{
			for (Season season : Season.values()) {
				System.out.println(season.name() + " " + season.ordinal());
			}

			System.out.println(Season.values()[3]);
		}

		separe();

		{
			Season s1 = Season.valueOf("SUMMER");
			// Season s2 = Season.valueOf("summer"); //THROWS EXCEPTION
		}

		separe();

		{
			Season summer = Season.SUMMER;
			switch (summer) {
			case WINTER:
				System.out.println("Get out the sled!");
				break;
			case SUMMER:
				System.out.println("Time for the pool!");
				break;
			default:
				System.out.println("Is it summer yet?");
				break;
			}
		}

		separe();

		{
			Season summer = Season.SUMMER;

			//DOES NOT COMPILE
//			switch (summer) {
//			case 0:
//				System.out.println("Get out the sled!");
//				break;
//			}
		}
		
		separe();
		
		{
			Season.SUMMER.printExpectedVisitors();
			Season.FALL.printExpectedVisitors();
		}
		
		separe();
		
		{
			
		}

	}

}
