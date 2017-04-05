package test;


 /**
 * @since zshUtils
 * @author Ö£Ë®ºé  
 */
public class StringBufferToSql {
	public static StringBuffer sql = new StringBuffer();
	
	public static String createSql(){
		sql.append("select * from sms");
		return sql.toString();
	}
	
	
	public static void main(String[] args) {
		String temp = createSql();
		System.out.println("sql======> "+temp);
	}
}
