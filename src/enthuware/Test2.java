package enthuware;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Serializable;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lib.TextElements;

@SuppressWarnings("all")
class Outer {
	private void Outer() {
	}

	protected class Inner {
	}
}

class X extends Thread {
	public synchronized void run() {
		System.out.println("x");
	}
}

@SuppressWarnings("all")
public class Test2 extends TextElements {

	public static void main(String[] args) throws Exception {
		{
			int i = 1;
			char c = (char) i;

			char ch = 1;
			System.out.println(c);
			System.out.println(ch == c);
		}

		separe();

		{

			FileWriter fw = new FileWriter("c:\\temp\\test.txt");
			BufferedWriter bfw = new BufferedWriter(fw);

		}

		separe();

		{
			Thread a = new Thread();

			List<Outer> l = new ArrayList<>();

			l.stream().sorted().forEach(System.out::print);

			AtomicInteger ai = new AtomicInteger();
		}

		separe();

		{
			// FileReader fr = new FileReader("");
			// BufferedReader r = new BufferedReader(fr);

		}

		separe();

		{
			new X().start();

			PreparedStatement e;
			Statement x;

			Deque d = new ArrayDeque<>();

		}

		separe();

		{
			AtomicInteger ai = new AtomicInteger();
			Stream<String> stream = Stream.of("old", "king", "cole", "was",
					"a", "merry", "old", "soul").parallel();
			stream.filter(e -> {
				ai.incrementAndGet();
				return e.contains("o");
			}).allMatch(x -> x.indexOf("o") > 0);
			System.out.println("AI = " + ai);
		}

		separe();

		{
			System.out.println(Paths.get("x").relativize(Paths.get("a/b/x")));

			System.out.println(Paths.get("x").resolve(Paths.get("/a/b/x")));
		}

		separe();

		{

			BinaryOperator<String> bo = (s1, s2) -> s1.concat(s2);
			List<String> names = new ArrayList<>();
			names.add("Bill");
			names.add("George");
			names.add("Obama");
			String finalvalue = names.stream().reduce("Hello : ", bo);
			System.out.println(finalvalue);
		}

		separe();

		{
			System.out.println(Arrays.asList("w", "o", "l", "f").stream()
					.reduce("x", String::concat));
		}

		separe();

		{

			Arrays.asList("w", "o", "l", "f").stream()
					.collect(Collectors.groupingBy(String::length))
					.forEach((a, b) -> System.out.println(a + ": " + b));
			
		}

	}
}
