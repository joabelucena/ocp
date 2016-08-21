package chapter5.time;

import static lib.TextElements.miniSepare;
import static lib.TextElements.separe;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeClass {

	public static void main(String[] args) {
		
		{
			/* 
			 * Method Signature: ZonedDateTime.of(LocalDateTime localDateTime, ZoneId zone)
			 * 					 ZonedDateTime.of(LocalDate localDate, LocalTime localTime, ZoneId zone) 
			 * 					 ZonedDateTime.of(int year, int month, int dayOfMonth, 
			 * 						int hour, int minute, int second, int nanoOfSecond, ZoneId zone)
			 * Description: Retrieves a ZonedDateTime
			 * 
			 */
			
			LocalDate date = LocalDate.of(1991, Month.APRIL, 30);		// 2 of()
			LocalTime time = LocalTime.of(19, 00);						// 3 of()
			ZoneId zone = ZoneId.systemDefault();
			
			ZonedDateTime z1 = ZonedDateTime.of(LocalDateTime.of(date, time), zone);
			ZonedDateTime z2 = ZonedDateTime.of(date, time, zone);
			ZonedDateTime z3 = ZonedDateTime.of(1991, 8, 19, 19, 20, 10, 123, zone);
			
			System.out.println(z1);
			System.out.println(z2);
			
			separe();
			
			miniSepare();
			
		}
		
	}

}
