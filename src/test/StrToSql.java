package test;


 /**
 * @since zshUtils 
 * @author Ö£Ë®ºé  
 */
public class StrToSql {
	
	public static String sql = "";
	
	public static String createSql(){
		sql+="is";
		return sql;
	}
	public static void main(String[] args) {
		
		String temp = createSql();
		System.out.println("sql======> "+temp);
		
	}
}
