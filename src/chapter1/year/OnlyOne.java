package chapter1.year;


public enum OnlyOne{
	
	ONCE(true), TWICE;
	
	private OnlyOne(boolean b){
		System.out.println("Constructing");
	}
	
	private OnlyOne(){System.out.println("aaa");}
	
	public static void main(String...args){
		OnlyOne firstCall = OnlyOne.ONCE;
		OnlyOne secondCall = OnlyOne.TWICE;		
	}
}
