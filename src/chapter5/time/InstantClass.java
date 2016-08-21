package chapter5.time;

import static lib.TextElements.separe;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class InstantClass {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		
		ZonedDateTime zoned = ZonedDateTime.of(date, time, ZoneId.systemDefault());
		
		{
			Instant now = Instant.now();
			
			Instant later = Instant.now();
			
			Duration duration = Duration.between(now, later);
			
			System.out.println(duration.toNanos());
			
			System.out.println(later);
			
		}

		separe();
		
		{
			
			Instant instant = zoned.toInstant();
			
			System.out.println(instant);
			
			System.out.println(zoned);
			
		}
		
		separe();
		
		{
			/*
			 * adds DAYS or LESS
			 */
			Instant nextDay = zoned.toInstant().plus(1, ChronoUnit.DAYS);
			Instant nextHour = zoned.toInstant().plus(1, ChronoUnit.HOURS);
//			Instant nextWeek = zoned.toInstant().plus(1, ChronoUnit.WEEKS);		//RUNTIME EXCEPTION
			
		}
		
	}

}
