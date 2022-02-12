package fileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileIO {

	public static void main(String[] args) {

		File newFile = new File("newFile.txt");
		File anotherFile = new File("D:\\anotherfile.txt");
		File fileToDelete = new File("D:\\abc\\abc.txt");
		File folder = new File("D:\\abc");
		File folders = new File("D:\\abcd\\abc\\ab\\a");

//		try {
//			newFile.createNewFile();
//		} catch (IOException e) {
//			System.err.println("This file cannot be created");
//		}
//
//		try {
//			anotherFile.createNewFile();
//		} catch (IOException e) {
//			System.err.println("This file cannot be created");
//		}

//		if (newFile.canRead()) {
//			System.out.println("this file has read access");
//		} else {
//			System.out.println("this file doesn't have read access");
//		}
//
//		if (anotherFile.canWrite()) {
//			System.out.println("this file has write access");
//		} else {
//			System.out.println("this file doesn't have write access");
//		}

//		newFile.delete();
//		fileToDelete.delete();
//
//		System.out.println(fileToDelete.exists());
//		System.out.println(newFile.exists());
//		System.out.println(anotherFile.exists());

//		System.out.println(newFile.getName());
//		System.out.println(anotherFile.getName());

//		try {
//			folder.mkdir();
//			folders.mkdirs();
//			fileToDelete.createNewFile();
//			newFile.createNewFile();
//		} catch (IOException e) {
//			System.err.println("This file cannot be created");
//		}

//		System.out.println(newFile.getAbsolutePath());
//		System.out.println(newFile.getCanonicalPath());
//		System.out.println(newFile.isDirectory());
//		System.out.println(newFile.isFile());
//		System.out.println(folder.isDirectory());

//		FileInputStream fin = new FileInputStream(newFile);
//		FileOutputStream fos = new FileOutputStream(fileToDelete);

//		FileWriter writer = null;
//
//		try {
//			writer = new FileWriter("fileToWrite.txt", true);
//			writer.write("this is a new file created and written using java, on the last day of java tutorial");
//			writer.close();
//
//			System.out.println("file write completed");
//		} catch (IOException e) {
//			System.err.println("cannot write into the file");
//		}

//		Path filePath = Path.of("fileToWrite.txt");
		Path filePath = Path.of("D://anotherFiles.txt");

		try {
			System.out.println(Files.readString(filePath));
		} catch (IOException e) {
			System.err.println("File doesn't exist");
		}

	}

}
