import java.text.SimpleDateFormat;
import java.util.Date;

public class Dooo {
	public static void main(String[] args) {
		SimpleDateFormat f = new SimpleDateFormat("HHmmssSSS");
		Date date = new Date(System.currentTimeMillis());
//		Date date = new Date();
		System.out.println(1+f.format(date));
	}
}
