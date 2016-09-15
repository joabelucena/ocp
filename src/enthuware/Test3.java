package enthuware;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lib.TextElements;

abstract class A {
	abstract void x();
}

class Course {
	private String id;
	private String category;

	public Course(String id, String category) {
		this.id = id;
		this.category = category;
	}

	public String toString() {
		return id + " " + category;
	}

	public String getCategory() {
		return category;
	}
}

public class Test3 extends TextElements {

	public static class Inner {

	}

	public static void main(String[] args) {
		{
			Duration d = Duration.ofHours(25);
			System.out.println(d);
		}

		separe();

		{
			AtomicInteger ai = new AtomicInteger();

		}

		separe();

		{
			List<String> l1 = Arrays.asList("a", "b");
			List<String> l2 = Arrays.asList("1", "2");

			Stream.of(l1, l2).flatMap((x) -> Stream.of(x))
					.forEach((x) -> System.out.println(x));
			Stream.of(l1, l2).flatMap((x) -> x.stream())
					.forEach((x) -> System.out.println(x));

			NavigableMap<String, String> map;

		}

		separe();

		{
			List<Course> s1 = Arrays.asList(new Course("OCAJP", "Java"),
					new Course("OCPJP", "Java"), new Course("C#", "C#"),
					new Course("OCEJPA", "Java"));

			Map<String, List<Course>> books = s1.stream().collect(
					Collectors.groupingBy(c -> c.getCategory()));

			System.out.println(books);

			books.forEach((m, n) -> System.out.println(n));
		}

		separe();

	}

}
