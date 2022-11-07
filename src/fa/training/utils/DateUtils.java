package fa.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat formatFromDB = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date convertDate(String date) {
		if(date == null) {
	           return null;
	       } else { // parse your date format with date formatter
	           try {
	               return format.parse((String) date);
	           } catch (ParseException e) {
	               throw new RuntimeException(e);
	           }
	        }
	}
	
	public static String convertDateFromDB(Date date) {
		if(date == null) {
	           return null;
	       } else { // parse your date format with date formatter
	           try {
	               return formatFromDB.format(date);
	           } catch (Exception e) {
	               throw new RuntimeException(e);
	           }
	        }
	}
	
}
