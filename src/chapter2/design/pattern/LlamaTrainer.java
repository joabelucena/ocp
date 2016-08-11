package chapter2.design.pattern;

import chapter2.design.pattern.singleton.HayStorage;

public class LlamaTrainer {
	
	public boolean feedLlamas(int numberOfLlamas) {
		int amoutNeeded = 5 * numberOfLlamas;
		
		HayStorage hayStorage = HayStorage.getInstance();
		
		if(hayStorage.getHayQuantity() < amoutNeeded) {
			hayStorage.addHay(amoutNeeded + 10);
		}
		
		boolean fed = hayStorage.removeHay(amoutNeeded);
		
		if(fed) System.out.println("llamas have been fed");
		
		return fed;
		
	}
}
