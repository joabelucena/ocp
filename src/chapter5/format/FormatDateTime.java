package chapter5.format;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static lib.TextElements.*;

public class FormatDateTime {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.of(1991, Month.AUGUST, 19);
		LocalTime time = LocalTime.of(19, 20, 30);
		
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		
		{
			System.out.println(date.getDayOfWeek());
			System.out.println(date.getMonth());
			System.out.println(date.getYear());
			System.out.println(date.getDayOfYear());
			
			miniSepare();
		}
		
		separe();
		
		{
			System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));				//1991-08-19
			System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));				//19:20:30
			System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));		//1991-08-19T19:20:30
		}
		
		separe();
		
		{
			DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
			
			System.out.println(shortDateTime.format(dateTime));
			System.out.println(shortDateTime.format(date));
			
//			System.out.println(shortDateTime.format(time));			//THROWS EXCEPTION
			
		}
		
		separe();
		
		{
			/*
			 * Two Way
			 */
			DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
			
			System.out.println(dateTime.format(shortDateTime));
			System.out.println(shortDateTime.format(dateTime));
		}
		
		separe();
		
		{
			/*
			 * PreDefined formats: SHORT and MEDIUM
			 */
			DateTimeFormatter sf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
			DateTimeFormatter mf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
			
			System.out.println(sf.format(dateTime));
			System.out.println(mf.format(dateTime));
		}
	}
	
	
}
