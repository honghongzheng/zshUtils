package date$timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @since zshUtils
 * @author Ö£Ë®ºé  
 */
public class CurrentTime {
	public static String getCurrentTime() {
		String returnStr = null;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		Date date = new Date(System.currentTimeMillis());
//		Date date = new Date();
		returnStr = f.format(date);
		return returnStr;
	}
	public static void main(String[] args) throws ParseException {
//		System.out.println(getCurrentTime());
		
		String time2 = "2016-10-10 09:17:20:200";
		String time = "2016-10-10 09:17:21:010";
		SimpleDateFormat sdf  =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		Date date = sdf.parse(time);
		Date date2 = sdf.parse(time2);
		long l = date.getTime();
		long l2 = date2.getTime();
		long temp = l2-l;
		System.out.println(l);
		System.out.println(l2);
		System.out.println(temp);
		System.out.println(":"+(int)Math.abs(temp));
		
		System.out.println("***********************************");
		
		Date dat = new Date(l);
		System.out.println(sdf.format(dat));
		Date dat2 = new Date(l2);
		System.out.println(sdf.format(dat2));
		
		
		
		
	}
}
