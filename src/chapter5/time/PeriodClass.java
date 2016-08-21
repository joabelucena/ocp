package chapter5.time;

import static lib.TextElements.miniSepare;
import static lib.TextElements.separe;

import java.time.*;

public class PeriodClass {
	
	public static void main(String[] args) {
		
		LocalDate date = LocalDate.of(1991, Month.APRIL, 30);		// 2 of()
		LocalTime time = LocalTime.of(19, 00);						// 3 of()
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		
		Period period = Period.ofMonths(1);
		
		{
			LocalDate start = LocalDate.of(2016, Month.APRIL, 30);
			LocalDate end = LocalDate.of(2016, Month.AUGUST, 19);
			
			Period monthly = Period.ofMonths(1);
			Period weekly = Period.ofWeeks(1);
			Period crazy = Period.of(1, 0, 7);
			
			performAnimalEnrichment(start, end);
			
			miniSepare();
			
			performAnimalEnrichment(start, end, monthly);
			
			miniSepare();
			
			performAnimalEnrichment(start, end, weekly);
		}
		
		separe();
		
		{
			
			System.out.println(Period.of(1,2,3));
			System.out.println(Period.ofMonths(3));
			System.out.println(Period.of(0, 29, 47));
			System.out.println(Period.ofWeeks(3));
			
		}
		
		separe();
		
		{
			System.out.println(date.plus(period));
			System.out.println(dateTime.plus(period));
			System.out.println(time.plus(period));
		}
		
		
	}
	
	public static void performAnimalEnrichment(LocalDate start, LocalDate end) {
		
		LocalDate upTo = start;
		
		while(upTo.isBefore(end)){
			System.out.println("Give new toy: " + upTo);
			upTo = upTo.plusMonths(1);
		}
	}
	
	public static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) {
		
		LocalDate upTo = start;
		
		while(upTo.isBefore(end)){
			System.out.println("Give new toy: " + upTo);
			upTo = upTo.plus(period);
		}
	}

}
