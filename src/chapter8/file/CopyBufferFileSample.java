package chapter8.file;

import java.io.*;

import lib.FilePath;

public class CopyBufferFileSample {
	
	public static void copy(File source, File destination) throws IOException {
		try (InputStream in = new BufferedInputStream(new FileInputStream(
				source));
				OutputStream out = new BufferedOutputStream(
						new FileOutputStream(destination))) {
			byte[] buffer = new byte[1024];
			int lengthRead;
			while ((lengthRead = in.read(buffer)) > 0) {
				out.write(buffer, 0, lengthRead);
				out.flush();
			}
		}
	}

	public static void main(String[] args) throws IOException {

		String sourceName = "zoo.txt";
		String destinationName = "zoo_buffer_copy.txt";

		File source = new File(FilePath.SANDBOX_PATH + sourceName);
		File destination = new File(FilePath.SANDBOX_PATH + destinationName);
		copy(source, destination);
	}
}
