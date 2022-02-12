package exceptions;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionHandling {

	public static void main(String[] args) throws InterruptedException {

//		System.out.println("Program started");
//		Thread.sleep(2000);
//		System.out.println("waited 2 seconds");

//		try {
//			
//		} catch (NoSuchFileException nsf) {
//			// do things when the exeption occurs
//		} finally {
//			// statement execute in any case
//		}

		String dateText = "2007-03-13";

		SimpleDateFormat format = new SimpleDateFormat("yyyy-dd-MM");

		Date date = null;

//		try {
//			date = format.parse(dateText);
//			throw new NoSuchElementException();
//		} catch (ParseException | NoSuchElementException e) {
//			date = new Date();
//			System.out.println("Couldnot parse the date in given format");
//		} catch (NoSuchFieldError e) {
//			System.out.println("fdsjkfsh");
//		} finally {
//			System.out.println("reached finally block");
//			System.out.println(date);
//		}

		try (FileReader fr = new FileReader("hh.txt")) {
			char[] a = new char[10];
			fr.read(a);

			for (char c : a)
				System.out.println(c);

		} catch (IOException e) {
			System.out.println(" file doesn't exist");
		}

		Thread.sleep(3000);

		System.out.println("waited 3 seconds");

	}
	// ctrl + shift + o
	// ctrl + shift + f

}
