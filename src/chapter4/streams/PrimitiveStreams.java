package chapter4.streams;

import static lib.TextElements.miniSepare;
import static lib.TextElements.separe;

import java.util.IntSummaryStatistics;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lib.TestData;

public class PrimitiveStreams {

	public static void main(String[] args) {
		
		IntConsumer printer = System.out::println;
		
		Function<Integer, Stream<String>> names = TestData::getNames;
		
		{
			IntStream stream = IntStream.of(1,2,3);
			
			System.out.println(stream.sum());
		}
		
		separe();
		
		{
			IntStream exclusive = IntStream.range(1, 5);
			IntStream inclusive = IntStream.rangeClosed(1, 5);
			
			exclusive.forEach(printer);
			
			miniSepare();
			
			inclusive.forEach(printer);			
			
		}
		
		separe();
		
		{
			IntStream lengths = names.apply(0).mapToInt(s->s.length());
			
			lengths.forEach(printer);
		}
		
		separe();
		
		{
			/*
			 * OptionalPrimitive
			 */
			IntStream stream = IntStream.rangeClosed(1, 10);
			OptionalDouble optional = stream.average();
			
			optional.ifPresent(System.out::println);
			
			System.out.println(optional.getAsDouble());
			System.out.println(optional.orElseGet(() -> Double.NaN));
			
		}
		
		separe();
		
		{
			IntStream stream = IntStream.empty();
			
			OptionalInt max = stream.max();
			try {
				System.out.println(max.orElseThrow(NoSuchElementException::new));	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		separe();
		
		{
			
			/*
			 * PrimiviteSummaryStatistics
			 */
			IntStream stream = IntStream.rangeClosed(1, 10);
			
			IntSummaryStatistics stats = stream.summaryStatistics();
			
			System.out.println(stats.getCount());
			
			System.out.println(stats.getMax() - stats.getMin());
		}
		
		separe();
		
		{
			/*
			 * BooleanSupplier
			 * 
			 * boolean getAsBoolean()
			 */
			BooleanSupplier b1 = () -> true;
			BooleanSupplier b2 = () -> Math.random() > .5;
			
			System.out.println(b1.getAsBoolean());
			System.out.println(b2.getAsBoolean());
			
		}
	}

}
