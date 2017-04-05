package Regular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




/**
 * @since DemoJava
 * @author 郑水洪  
 */
public class RegularDemo {

	public static void main(String[] args) {
//		execute();
//		test1();
		test2();
		
	}

	public static void test2(){
		Pattern pattern2 = Pattern.compile("\\s{2,}");
		StringBuffer realSqlSb = new StringBuffer();
		String completeSql = "select *                   from  emp where name=                             'hel'";
		Matcher m2 = pattern2.matcher(completeSql);
		int lastIndex2 = 0;
		while (m2.find()) {
			realSqlSb.append(completeSql.substring(lastIndex2, m2.start()));
			realSqlSb.append(" ");
			lastIndex2 = m2.end();
		}
		realSqlSb.append(completeSql.substring(lastIndex2));
		//this.realSql = realSqlSb.toString();
		System.out.println("============>"+realSqlSb.toString());
	}
	
	public static void test1(){
		int lastIndex = 0;
		int start = 36;
		StringBuffer completeSql = new StringBuffer();
		String oldSql = "from WebserviceRegister t where 1=1 {1} {2} ";
		System.out.println("oldSql.substring(lastIndex, start):"+oldSql.substring(lastIndex, start));
		completeSql.append(oldSql.substring(lastIndex, start));
		System.out.println("打印oldSql:"+completeSql.toString());
		
	}
	public static void execute() {
		Pattern pattern = Pattern.compile("\\{\\d+\\}");
		Pattern pattern2 = Pattern.compile("\\s{2,}");

		String oldSql = "from WebserviceRegister t where 1=1 {1} {2} ";
		String realSql;

		HashMap whereMap = new HashMap();
		HashMap valueMap = new HashMap();
		List paramList = new ArrayList();
		whereMap.put("{1}", "=and t.name like ?");
		whereMap.put("{2}", "and t.unitCode = ?}");
		valueMap.put("{1}", "dfghjk");
		valueMap.put("{2}", "789320");
		Matcher m1 = pattern.matcher(oldSql);
		StringBuffer completeSql = new StringBuffer();
		int lastIndex = 0;
		while (m1.find()) {
			int start = m1.start();
			int end = m1.end();
			String msg = m1.group();
			System.out.println("oldSql.substring(lastIndex, start):"+oldSql.substring(lastIndex, start));
			completeSql.append(oldSql.substring(lastIndex, start));
			System.out.println("completeSql:"+completeSql);
			System.out.println("msg:"+msg);
			Object whereParm = whereMap.get(msg);
			if (whereParm != null && !whereParm.equals("")) {
				Object value = valueMap.get(msg);
				if (value != null) {
					paramList.add(value);
					completeSql.append(whereParm);
					//printDetail("模版替换"+msg+"为："+whereParm);
				} else {
					//printDetail("模版"+msg+"值为空："+value);
				}
			} else {
				//printDetail("没有找到模版"+msg+"对应的值");
			}
			lastIndex = end;
		}
		if (lastIndex == 0) {
			completeSql.append(oldSql);
		}

		StringBuffer realSqlSb = new StringBuffer();
		Matcher m2 = pattern2.matcher(completeSql);
		int lastIndex2 = 0;
		while (m2.find()) {
			realSqlSb.append(completeSql.substring(lastIndex2, m2.start()));
			realSqlSb.append(" ");
			lastIndex2 = m2.end();
		}
		realSqlSb.append(completeSql.substring(lastIndex2));
		//this.realSql = realSqlSb.toString();
		System.out.println("============>"+realSqlSb.toString());

		//printDetails();
	}
}