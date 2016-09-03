package chapter9.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import lib.TextElements;

public class StreamPathWalk extends TextElements {

	public static void main(String[] args) throws IOException {

		Path nio = Paths.get("nio2/tree");

		{
			/*
			 * Path walk(path) throws IOException
			 */
			Files.walk(nio).filter(p -> p.toString().endsWith(".txt"))
					.forEach(System.out::println);

		}

		separe();

		{
			/*
			 * Stream<Path> find(Path, int depth, BiPredicate<Path,
			 * BasicFileAttributes> matcher) throws IOException
			 */
			Files.find(
					nio,
					3,
					(p, a) -> p.getFileName().toString().startsWith("a")
							&& a.isDirectory()).forEach(System.out::println);
		}

		separe();

		{
			/*
			 * Stream list(Path path) trhows IOException
			 */
			Files.list(nio).filter(p -> p.toString().endsWith(".txt"))
					.map(p -> p.toAbsolutePath())
					.forEach(System.out::println);

		}
		
		separe();
		
		{
			/*
			 * Stream<String> lines(Path path) throws IOException
			 */
			
			Files.lines(nio.resolve("zoo.txt"))
				.forEach(System.out::println);
		}
	}

}
