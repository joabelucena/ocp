package chapter5.time;

import static lib.TextElements.miniSepare;
import static lib.TextElements.separe;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DayligthSavingTime {

	public static void main(String[] args) {
		
		/**
		 * March, 13th +1 hour
		 * November, 6th -1 hour
		 * 
		 * WARNING: Duration takes daylights, Period DOES NOT!
		 */
		
		Duration duration = Duration.ofDays(1);
		Period period = Period.ofDays(1);
		
		{
			LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
			LocalTime time = LocalTime.of(1, 30);
			ZonedDateTime zoned = ZonedDateTime.of(date, time, ZoneId.of("US/Eastern"));
			
			System.out.println(zoned);
			
			System.out.println(zoned.plusHours(1));

			miniSepare();
			
			System.out.println("Period:\t\t" + zoned.plus(period));		//DO NOT take daylight saving
			
			System.out.println("Duration:\t" + zoned.plus(duration));	//Takes daylight saving
		}

		separe();
		
		{
			LocalDate date = LocalDate.of(2016, Month.NOVEMBER, 6);
			LocalTime time = LocalTime.of(1, 30);
			ZonedDateTime zoned = ZonedDateTime.of(date, time, ZoneId.of("US/Eastern"));

			System.out.println(zoned);
			
//			System.out.println(zoned.plusHours(1));
//			
//			System.out.println(zoned.plusHours(2));

			miniSepare();
			
			System.out.println("Period:\t\t" + zoned.plus(period));		//DO NOT take daylight saving
			
			System.out.println("Duration:\t" + zoned.plus(duration));	//Takes daylight saving
		}
		
		separe();
		
		{
			/*
			 * Trying to create a date tha doesn't exist
			 */
			LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
			LocalTime time = LocalTime.of(2, 30);
			ZonedDateTime zoned = ZonedDateTime.of(date, time, ZoneId.of("US/Eastern"));

			System.out.println(zoned);
		}
		

	}

}