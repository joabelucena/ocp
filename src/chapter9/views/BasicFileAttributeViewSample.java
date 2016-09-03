package chapter9.views;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

import lib.TextElements;

public class BasicFileAttributeViewSample extends TextElements {

	public static void main(String[] args) throws IOException {

		Path nio = Paths.get("./nio2");
		Path zoo = nio.resolve("zoo.txt");
		
		BasicFileAttributeView view = Files.getFileAttributeView(zoo, BasicFileAttributeView.class);
		BasicFileAttributes data = view.readAttributes();
		
		System.out.println("File path: " + zoo.toAbsolutePath().normalize());
		
		separe();
		
		FileTime lastModifiedTime = FileTime.fromMillis(data.lastModifiedTime().toMillis()+10_000);
		view.setTimes(lastModifiedTime, null, null);
		
	}
}
