package temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




/**
 * @since DemoJava
 * @author Ö£Ë®ºé  
 */
public class CopyOfRegularDemo {

	public static void main(String[] args) {
//		execute();
//		test1();
		test2();
		
	}

	public static void test2(){
		Pattern pattern2 = Pattern.compile("outside_pl_name[0-9]+$");
		StringBuffer realSqlSb = new StringBuffer();
		String completeSql = "outside_pl_name1";
		Matcher m2 = pattern2.matcher(completeSql);
		int lastIndex2 = 0;
		while (m2.find()) {
			System.out.println(m2.start());
			System.out.println(m2.end()); 
			System.out.println(lastIndex2);
			System.out.println(completeSql.substring(m2.start(), m2.end()));
			
		}
		/*while (m2.find()) {
			realSqlSb.append(completeSql.substring(lastIndex2, m2.start()));
			realSqlSb.append(" ");
			lastIndex2 = m2.end();
		}*/
//		realSqlSb.append(completeSql.substring(lastIndex2));
//		//this.realSql = realSqlSb.toString();
//		System.out.println("============>"+realSqlSb.toString());
	}
	
	
}