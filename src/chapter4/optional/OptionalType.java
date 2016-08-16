package chapter4.optional;

import static lib.TextElements.separe;

import java.util.Optional;

public class OptionalType {

	public static void main(String[] args) {
		
		{
			System.out.println(average(90,100));
			System.out.println(average());	
		}
		
		separe();
		
		{
			Optional<Double> opt = average(90,100);
			if(opt.isPresent()) {
				System.out.println(opt.get());
			}	
		}
		
		separe();
		
		{
			Optional<Double> opt = average();
			try {
				System.out.println(opt.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		separe();
		
		{
			String a = null;
			Optional<String> o1 = (a == null) ? Optional.empty() : Optional.of(a);
			Optional<String> o2 = Optional.ofNullable(a);
			
			System.out.println(o1);
			System.out.println(o2);
			
		}
		
		separe();
		
		{
			Optional<Double> o = average(53,70, 80);
			o.ifPresent(System.out::println);
			
			o.ifPresent(s-> System.out.println(s));
		}
		
		separe();
		
		{
			System.out.println(average().orElseGet(()->new Double(1)));
		}
		
		separe();
		
		{
			Optional<Double> o = average();
			
			System.out.println(o.orElse(Double.NaN));
			System.out.println(o.orElseGet(() -> Math.random()));
			System.out.println(o.orElseThrow(IllegalArgumentException::new));
			
		}
		

	}
	
	
	public static Optional<Double> average(int...scores){
		
		if(scores.length == 0) return Optional.empty();
		
		int sum = 0;
		for(int score: scores) sum += score;
		return Optional.of((double) sum / scores.length);
	}

}
