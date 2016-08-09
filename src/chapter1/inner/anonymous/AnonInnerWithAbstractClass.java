package chapter1.inner.anonymous;


public class AnonInnerWithAbstractClass {
	
	/*
	 * Abstract inner class
	 */
	abstract class SaleTodayOnly {
		abstract int dollarsOff();
	}
	
	public int admission(int basePrice) {
		
		/*
		 * Anonymous inner class implementing member inner class
		 */
		SaleTodayOnly sale = new SaleTodayOnly() {
			
			@Override
			int dollarsOff() {
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
			int dollarsOff() {
				// TODO Auto-generated method stub
				return 3;
			}
		});
	}
	
	public int admission(int basePrice, SaleTodayOnly sale){
		return basePrice - sale.dollarsOff();
	}
}
