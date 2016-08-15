package chapter4.functional.buitin;

import static lib.TextElements.*;

import java.time.LocalDate;
import java.util.*;
import java.util.function.*;

import lib.TestData;

public class SupplierImplementation {

	public static void main(String[] args) {
		
		/**
		 * Implementing Supplier<T>
		 * 
		 * Method Signature: T get();
		 */
		{
			Supplier<LocalDate> s1 = LocalDate::now;
			Supplier<LocalDate> s2 = () -> LocalDate.now();
			
			System.out.println(s1.get());
			System.out.println(s2.get());	
		}
		
		separe();
		
		{
			Supplier<StringBuilder> s1 = StringBuilder::new;
			Supplier<StringBuilder> s2 = () -> new StringBuilder();
			
			System.out.println(s1.get());
			System.out.println(s2.get());	
		}
		
		separe();
		
		{
			Supplier<ArrayList<String>> s1 = ArrayList<String>::new;
			ArrayList<String> a1 = s1.get();
			System.out.println(a1);
		}
		
		separe();
		
		{
			Supplier<List<String>> animals = TestData::getAnimals;
			
			System.out.println(animals.get());
		}
		

	}

}
