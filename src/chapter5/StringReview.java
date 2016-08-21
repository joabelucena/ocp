package chapter5;

import static lib.TextElements.miniSepare;
import static lib.TextElements.separe;

public class StringReview {

	public static void main(String[] args) {
		
		{
			/**
			 * String Class Review
			 */
			{
				/*
				 * Strings and memory
				 */
				
				String s1 = "bunny";				// Pooled String
				String s2 = "bunny";				// Pooled String
				String s3 = new String("bunny");	// Regular String object
				String s4 = new String(s1);			// Regular String object
				String s5 = new String(s1);			// Regular String object
				
				System.out.println(s1 == s2);
				System.out.println(s1 == s3);
				System.out.println(s1 == s4);
				
				System.out.println(s4 == s5);
				
			}

			miniSepare();
			
			{
				/*
				 * String concatenation with "+"
				 * 
				 * When concatenating strings, Java creates a NEW String from the original
				 */
				String s1 = "1" + 2 + 3;
				String s2 = 1 + 2 + "3";
				
				System.out.println(s1);
				System.out.println(s2);
				
			}
			
			miniSepare();
			
			{
				//			01234
				String s = "abcde ";
				
				System.out.println(s.trim().length());
				System.out.println(s.charAt(4));
				System.out.println(s.indexOf('e'));
				System.out.println(s.indexOf("de"));
				System.out.println(s.substring(2, 4).toUpperCase());
				System.out.println(s.replace('a', '1'));
				System.out.println(s.contains("DE"));
				System.out.println(s.startsWith("a"));
				
			}
		}
		
		separe();
		
		{
			/**
			 * StringBuilder Class Review
			 */
			
			StringBuilder b = new StringBuilder();
			b.append(12345).append('-');
			System.out.println(b.length());
			System.out.println(b.indexOf("-"));
			System.out.println(b.charAt(2));
			
			StringBuilder b2 = b.reverse();
			System.out.println(b.toString());
			System.out.println(b == b2);
			
			System.out.println(b);
			System.out.println(b2);
			
			miniSepare();
			
			//									 01234
			StringBuilder s = new StringBuilder("abcde");
			s.insert(1, '-').delete(3,  4);
			System.out.println(s);
			
		}
	}

}
