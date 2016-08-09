package chapter1;

import static lib.TextElements.separe;

import java.util.ArrayList;

import chapter1.zoo.Elephant;


class Card {
	private String rank;
	private String suit;
	public Card(String r, String s){
		if(r == null || s == null) throw new IllegalArgumentException();
		rank = r;
		suit = s;
	}
	public boolean equals(Object obj){
		if( !(obj instanceof Card)) return false;
		Card c = (Card) obj;
		return rank.equals(c.rank) && suit.equals(c.suit);
	}
	public int hashCode(){
		return rank.hashCode();
	}
}

public class CommonOverriddenMethods {

	public static void main(String[] args) {
		
		{
			System.out.println(new ArrayList<>());
			
			System.out.println(new String[0]);	
		}
		
		separe();
		
		//
		{
			Elephant el = new Elephant("Harry", 3100);
			System.out.println(el);
		}
		
		separe();
		
		{
			String s1 = new String("lion");
			String s2 = new String("lion");
			
			System.out.println(s1.equals(s2));
			
			StringBuilder sb1 = new StringBuilder("lion");
			StringBuilder sb2 = new StringBuilder("lion");
			
			System.out.println(sb1.equals(sb2));
		}
		
		separe();
		
		{
			Elephant e1 = new Elephant(1, 2, "Dumbo");
			Elephant e2 = new Elephant(2, 2, "Kero");
			Elephant e3 = new Elephant(1, 2, "Jaspion");
			
			System.out.println(e1.equals(e2));
			System.out.println(e3.equals(e1));
			System.out.println(e3.equals(new Boolean(true)));
			System.out.println(e3.equals(null));
			
			
		}
		

	}

}
