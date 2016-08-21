package chapter5.time;

import static lib.TextElements.miniSepare;
import static lib.TextElements.separe;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZonedDateTime;

public class LocalDateReview {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.of(1991, Month.APRIL, 30);		// 2 of()
		LocalTime time = LocalTime.of(19, 00);						// 3 of()
		
		{
			System.out.println(LocalDate.now());
			System.out.println(LocalTime.now());
			System.out.println(LocalDateTime.now());
			System.out.println(ZonedDateTime.now());
		}
		
		separe();
		
		{
			LocalDateTime full = LocalDateTime.of(date, time);			// (2x3) + 1 (LocalDate, LocalTime) of()
			
			System.out.println(full);
		}
		
		separe();
		
		{
			LocalDate d1 = date.plusMonths(4)
							.minusDays(11);
			
			System.out.println(d1);
			
			
			miniSepare();	
		}
		
	}

}
