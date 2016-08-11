package chapter3;

import static lib.TextElements.separe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import chapter3.generics.Crate;
import chapter3.generics.SizeLimitedCrate;
import chapter3.generics.beans.Elephant;
import chapter3.generics.beans.Robot;
import chapter3.generics.beans.Zebra;

public class TestClass {
	
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
		
		separe();
		
		{
			/*
			 * Searching and sorting arrays
			 */
			int[] numbers = {6,10,1,8};
			Arrays.sort(numbers);
			System.out.println(Arrays.toString(numbers));
			System.out.println(Arrays.binarySearch(numbers, 6));
			System.out.println(Arrays.binarySearch(numbers, 3));
			System.out.println(Arrays.binarySearch(numbers, 9));
			
			/*
			 * Searching and sorting Collections
			 */
			List<Integer> list = Arrays.asList(9,7,5,3);
			Collections.sort(list);
			System.out.println(Collections.binarySearch(list, 3));
			System.out.println(Collections.binarySearch(list, 2));
			
		}
		
		separe();
		
		{
			/*
			 * Generics
			 */
			Elephant elephant = new Elephant();
			Crate<Elephant> crateForElephant = new Crate<>();
			crateForElephant.packCrate(elephant);
			Elephant inNewHome = crateForElephant.emptyCrate();
			
			Crate<Zebra> crateForZebra = new Crate<>();
			
			Robot joeRobot = new Robot();
			Crate<Robot> crateForRobot = new Crate<>();
			crateForRobot.packCrate(joeRobot);
			
			Robot atDestination = crateForRobot.emptyCrate();
			
		}
		
		separe();
		
		{
			/*
			 * More than one-parameter generics
			 */
			Elephant elephant = new Elephant();
			Integer numPounds = 15_000;
			
			SizeLimitedCrate<Elephant, Integer> c1 = new SizeLimitedCrate<>(elephant, numPounds);
		}

	}

}
