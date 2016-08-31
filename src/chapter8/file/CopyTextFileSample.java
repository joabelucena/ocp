package chapter8.file;

import java.io.*;
import java.util.*;

import lib.FilePath;

public class CopyTextFileSample {
	public static List<String> readFile(File source) throws IOException {
		List<String> data = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
			String s;
			while ((s = reader.readLine()) != null) {
				data.add(s);
			}
		}
		return data;
	}

	public static void writeFile(List<String> data, File destination)
			throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(
				destination))) {
			for (String s : data) {
				writer.write(s);
				writer.newLine();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String sourceName = "zoo.txt";
		String destinationName = "zoo_text_copy.txt";

		File source = new File(FilePath.SANDBOX_PATH + sourceName);
		File destination = new File(FilePath.SANDBOX_PATH + destinationName);
		
		List<String> data = readFile(source);
		for (String record : data) {
			System.out.println(record);
		}
		writeFile(data, destination);
	}
}