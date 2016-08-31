package chapter8.file;

import java.io.*;

import lib.FilePath;

public class CopyFileSample {
	public static void copy(File source, File destination) throws IOException {
		try (InputStream in = new FileInputStream(source);
				OutputStream out = new FileOutputStream(destination)) {
			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		String sourceName = "zoo.txt";
		String destinationName = "zoo_stream_copy.txt";
		
		File source = new File(FilePath.SANDBOX_PATH + sourceName);
		File destination = new File(FilePath.SANDBOX_PATH + destinationName);
		copy(source, destination);
	}
}
