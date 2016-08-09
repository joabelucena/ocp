package chapter1.inner.anonymous;

public class AnonInnerWithInterface {
	
	/*
	 * Inner interface
	 */
	interface SaleTodayOnly {
		int dollarsOff();
	}
	
	public int admission(int basePrice) {
		
		/*
		 * Anonymous inner class implementing member inner class
		 */
		SaleTodayOnly sale = new SaleTodayOnly() {
			
			@Override
			public int dollarsOff() {
				// TODO Auto-generated method stub
				return 3;
			}
		};
		
		return basePrice - sale.dollarsOff();
		
	}
	
	/*
	 * Inline declaration
	 */
	public int pay(){
		return admission(5, new SaleTodayOnly() {
			
			@Override
			public int dollarsOff() {
				// TODO Auto-generated method stub
				return 3;
			}
		});
	}
	
	public int admission(int basePrice, SaleTodayOnly sale){
		return basePrice - sale.dollarsOff();
	}
}
