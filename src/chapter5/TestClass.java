package chapter5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import static lib.TextElements.separe;

public class TestClass {

	public static void main(String[] args) {

		{
			ZonedDateTime d1 = ZonedDateTime.of(
					LocalDateTime.of(2016, Month.MARCH, 13, 1, 30),
					ZoneId.of("US/Eastern"));
			ZonedDateTime d2 = d1.plus(1, ChronoUnit.HOURS);

			long hours = ChronoUnit.HOURS.between(d1, d2);

			int c1 = d1.getHour();
			int c2 = d2.getHour();

			System.out.println(hours + ", " + c1 + ", " + c2);

		}

		separe();

		{
			Period p = Period.of(1, 1, 1);
			Duration d = Duration.ofDays(1);

		}

		separe();

		{
			LocalDateTime ld1 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 1, 0);
			ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("US/Eastern"));
			
			System.out.println(zd1);
			
			System.out.println(zd1.plusHours(1));
			
			
			LocalDateTime ld2 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 1, 0);
			ZonedDateTime zd2 = ZonedDateTime.of(ld2, ZoneId.of("US/Eastern"));
			long x = ChronoUnit.HOURS.between(zd1, zd2);
			
			System.out.println(zd1);
			System.out.println(zd2);
			System.out.println(x);
		}

	}

}
