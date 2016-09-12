package enthuware;

import java.io.Closeable;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

import lib.TextElements;

enum Card {
	HEART, CLUB, SPADE, DIAMOND;
}

class Device implements Closeable {

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub

	}
}

class Book {
	private String isbn;

	public Book(String isbn) {
		this.isbn = isbn;
	}

	public boolean equals(Object o) {
		return (o instanceof Book && ((Book) o).isbn.equals(this.isbn));
	} }

public class Test1 extends TextElements {

	public static void main(String[] args) {
		{
			for (Card c : Card.values())
				System.out.print(c + " ");

			Thread a = new Thread();

			// a.j

			Period p = Period.between(LocalDate.now(),
					LocalDate.of(2015, Month.SEPTEMBER, 1));
			System.out.println(p);
			// Duration d = Duration.between(LocalDate.now(),
			// LocalDate.of(2015, Month.SEPTEMBER, 1));
			// System.out.println(d);
		}

		separe();

		{
			try (Device dev = new Device()) {

			} catch (IOException e) {

			}
		}

		separe();

		{
			List<List<String>> names = Arrays.asList(Arrays.asList("John"),
					Arrays.asList("Due", "Linda"));

			names.stream().flatMap(s -> s.stream())
					.filter(mov -> mov.contains("n"))
					.peek(mov -> System.out.println(mov)).map(mov -> mov)
					.max((s1, s2) -> s1.compareTo(s2));
		}

		separe();

		{
			Map<String, Double> map = new HashMap<>();
			
			map.put("jojo", 123.0);
			
			map.computeIfAbsent("gabi", (a)->{
				System.out.println(a);
				
				return 123.0;
			});
			
			
			
		}

		separe();

		{
			String[] sa = { "a", "aa", "aaa", "aaaa" };

			Arrays.sort(sa);
			String search = "";
			if (args.length != 0)
				search = args[0];
			System.out.println(Arrays.binarySearch(sa, search));
		}
		
		separe();
		
		{
			Test1 t = new Test1();
			
			t.print();
			
		}
		
		separe();
		
		{
			Book b = new Book("123");
			Book c = new Book("123");
			
			System.out.println(b.hashCode());
			System.out.println(c.hashCode());
		}
		
		separe();
		
		{
			Locale loc = new Locale("a","b");
			
			System.out.println(loc);
		}
		
		separe();
		
		{
			Queue<String> q = new LinkedList<>();
			
		}
	}
	
	public static void print(){
		System.out.println("Hello");
	}
}
