package chapter4.functional.buitin;

import chapter4.functional.Megazord;

public class MegazordImplementation {

	public static void main(String[] args) {
		
		Megazord<String, Integer, Integer, String> mega1 = String::substring;
		Megazord<String, Integer, Integer, String> mega2 = (s, start, end) -> s.substring(start, end);
		
		System.out.print(mega1.apply("MEGAZORD", 0, 4));
		System.out.print(mega2.apply("MEGAZORD", 4, 8));

	}

}
