package chapter5.time;

import static lib.TextElements.miniSepare;
import static lib.TextElements.separe;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DurationClass {
	
	public static void main(String[] args) {
		
		LocalDate date = LocalDate.of(1991, Month.APRIL, 30);		// 2 of()
		LocalTime time = LocalTime.of(19, 00);						// 3 of()
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		
		Duration dTwoDay = Duration.ofDays(2);
		Duration oneDay = Duration.ofHours(24);
		
		Period pTwoDay = Period.ofDays(2);
		
		
		{
			System.out.println(Duration.ofDays(3));
			System.out.println(Duration.ofHours(1));
			System.out.println(Duration.ofMinutes(1));
			System.out.println(Duration.ofSeconds(1));
			System.out.println(Duration.ofMillis(1));
			System.out.println(Duration.ofNanos(1));
			System.out.println(Duration.ofSeconds(1,1));
		}
		
		separe();
		
		{
			Duration daily = Duration.of(1, ChronoUnit.DAYS);
			Duration hourly = Duration.of(1, ChronoUnit.HOURS);
			Duration everyMinute = Duration.of(1, ChronoUnit.MINUTES);
			Duration everyTenSeconds = Duration.of(10, ChronoUnit.SECONDS);
			Duration everyMilli = Duration.of(1, ChronoUnit.MILLIS);
			Duration everyNano = Duration.of(1, ChronoUnit.NANOS);
		}
		
		separe();
		
		{
			LocalTime one = LocalTime.of(5, 15);
			LocalTime two = LocalTime.of(6, 30);
			
			System.out.println(ChronoUnit.HOURS.between(one, two));
			System.out.println(ChronoUnit.HOURS.between(two, one));
			
			System.out.println(ChronoUnit.MINUTES.between(one, two));
			
		}
		
		separe();
		
		{
			try {
				System.out.println(date.plus(dTwoDay));
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
			System.out.println(date.plus(pTwoDay));
			
		}
		
	}

}
