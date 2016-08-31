package chapter8;

import static lib.TextElements.separe;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import lib.FilePath;

public class ReadFileInformation {

	public static void main(String[] args) throws IOException {
		
		File file = new File(FilePath.PROJECT_PATH + "io/zoo.txt");
//		File file = new File(FilePath.PROJECT_PATH );
		
		System.out.println("File exists: " + (file.exists() ? "Yes" : "No"));
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(""));
		separe();
		
		if(file.exists()){
			System.out.println("Absolute path: " + file.getAbsolutePath());
			System.out.println("Is directory: " + (file.isDirectory() ? "Yes" : "No"));
			System.out.println("Parent path: " + file.getParent());
			
			if(file.isFile()) {
				System.out.println("File size: " + file.length());
				System.out.println("Last modified: " + new Date(file.lastModified()));
			} else {
				separe();
				System.out.println("Subfiles:");
				
				for(File subfile: file.listFiles())
					System.out.println("\t" + subfile.getName());
			}
			
		}
		
		
		
		
	}

}
