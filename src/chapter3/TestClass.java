package chapter3;

import static lib.TextElements.separe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import chapter3.generics.Crate;
import chapter3.generics.SizeLimitedCrate;

public class TestClass {
	
	private static class Elephant { }
	private static class Robot { }
	private static class Zebra { }

	public static void main(String[] args) {
		
		{
			/*
			 * using array and ArrayList
			 */
			List<String> list = new ArrayList<String>();
			list.add("Fluffy");
			list.add("Webby");
			
			System.out.println(list);
			
			String[] array = new String[list.size()];
			array[0] = list.get(1);
			array[1] = list.get(0);
			
			for(int i = 0; i < array.length; i++) {
				System.out.print(array[i] + "-");
			}
			System.out.println();
		}
		
		separe();
		
		{
			String[] array = {"gerbil", "mouse"};
			/*
			 * Creates a fixed size list that points to the same object
			 */
			List<String> list = Arrays.asList(array);
			
			System.out.println(Arrays.toString(array));
			System.out.println(list);
			
			list.set(1, "test");
			array[0] = "new";
			
			/*
			 * As they are linked, they'll print the same
			 */
			System.out.println(Arrays.toString(array));
			System.out.println(list);
			
			try {
				
				String[] array2 = (String[]) list.toArray();
				
				/*
				 * As it is fixed size, it's not allowed to remove itens
				 */
				list.remove(1);	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		

	}

}
