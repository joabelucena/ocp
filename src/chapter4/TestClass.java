package chapter4;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestClass {

	public static void main(String[] args) {

		{

			NavigableSet<String> myset = new TreeSet<>();
			myset.add("a");
			myset.add("b");
			myset.add("c");
			myset.add("aa");
			myset.add("bb");
			myset.add("cc");

			System.out.println(myset);

			System.out.println(myset.floor("a"));
			System.out.println(myset.ceiling("aaa"));
			System.out.println(myset.lower("a"));
			System.out.println(myset.higher("bb"));

			IntStream s1 = IntStream.of(1, 2, 3);

			AtomicInteger ai = new AtomicInteger();
		}
		
		{
			AtomicInteger ai = new AtomicInteger();
			Stream<Integer> stream = Stream.of(11, 11, 22, 33).parallel();
			stream.filter(e -> {
				ai.incrementAndGet();
				return e%2==0; })
				.forEach(System.out::print);
			
			System.out.println();
			
			System.out.println(ai);
			
			System.out.println("???");
		}
		
		{
			Map<Integer, String> aa = new HashMap<>();
			
			aa.put(1, "Java");	aa.put(2, "Oracle");
			
			System.out.println(aa.values());
		}
	}

}
