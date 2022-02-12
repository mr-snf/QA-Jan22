package dateAndTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateAndTime {

	public static void main(String[] args) throws ParseException {

//		System.out.println(System.currentTimeMillis());

		long var = System.currentTimeMillis() - 10000000;

		Date date = new Date();

		Date past = new Date(var);

//		System.out.println(date);
//
//		System.out.println(past);
//
//		System.out.println(date.after(past));
//		System.out.println(past.before(date));
//
//		System.out.println(date.compareTo(past));
//		System.out.println(past.compareTo(date));
//		System.out.println(past.compareTo(past));
//
//		String dateVal = date.toString();
//
//		System.out.println(dateVal);

		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss:SS a G z");

//		System.out.println(format.format(past));

		// ---------------------------------------------//

//		String dateFromSW = "Jan 25, 2022 04:29:52:188 am AD NPT"; // 2022-01-25
//
//		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss:SS a G z");
//
//		SimpleDateFormat changed = new SimpleDateFormat("yyyy-MM-dd");
//
//		SimpleDateFormat timeOnly = new SimpleDateFormat("HH:mm:ss:SS");
//
//		Date parsedDate = formatter.parse(dateFromSW);
//
//		System.out.println(changed.format(parsedDate));
//		System.out.println(timeOnly.format(parsedDate));

//		LocalDate
//		LocalDateTime
//		ZonedDateTime
//		GregorianCalendar cal = new GregorianCalendar();
//
//		GregorianCalendar cal2 = new GregorianCalendar(2019, 5, 14, 8, 15, 25);
//
//		System.out.println(cal2);
//
//		System.out.println(cal2.get(Calendar.YEAR));
//		System.out.println(cal2.get(Calendar.MONTH));
//		System.out.println(cal2.get(Calendar.HOUR));
		String dateToFormat = "2000/12/16 16:55:23:541 UTC"; // Dec 16, 2000 04:55 PM Change the string to this date
															// format
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SS z");

		Date newDate = format2.parse(dateToFormat);
		SimpleDateFormat format3 = new SimpleDateFormat("MMM dd, yyyy hh:mm a");
		System.out.println(format3.format(newDate));

	}

}
