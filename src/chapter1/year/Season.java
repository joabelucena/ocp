package chapter1.year;

public enum Season {
	
	WINTER ("Low") {
		
		public void printHours(){
			System.out.println("9am-3pm");
		}
		
	}, SUMMER("High") {
		
		public void printHours(){
			System.out.println("9am-7pm");
		}
		
	}, SPRING ("Medium") , FALL ("Medium",2);
	
	/*
	 * Enun fields..
	 * 
	 * These fields are the ones that goes next to the constant value, eg SPRING("Medium", 2). It
	 * must have an constructor for it [Season(String c, int a)]
	 */
	private String expectedVisitors;
	private int madness;
	
	/*
	 * Cosntructors
	 */
	private Season(){}
	private Season(String expectedVisitors){
		this.expectedVisitors = expectedVisitors;
	}
	private Season(String expectedVisitors, int madnessLevel){
		this.expectedVisitors = expectedVisitors;
		this.madness = madnessLevel;
	}
	
	/*
	 * Common methods
	 */
	public void printExpectedVisitors(){
		System.out.println("Exp Visitors: " + expectedVisitors + "Madness: " + madness);
	}
	
	public void printHours(){
		System.out.println("Default hours");
	}
	
}
