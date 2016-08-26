package chapter7.concurrency.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryConsistencyError {

	public static void main(String[] args) {
		Map<String, Object> foodData = new HashMap<String, Object>();
		Map<String, Object> concurrentFoodData = new ConcurrentHashMap<String, Object>();
		
		foodData.put("penguin", 1);
		foodData.put("flamingo", 2);
		
		concurrentFoodData.put("penguin", 1);
		concurrentFoodData.put("flamingo", 2);
		
		try {
			for(String key : foodData.keySet()) {
				foodData.remove(key);
			}	
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		for(String key : concurrentFoodData.keySet()) {
			foodData.remove(key);
		}
		
		
	}

}
