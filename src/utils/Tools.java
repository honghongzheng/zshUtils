package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {
	private static Pattern pattern2 = Pattern.compile("\\s{2,}");

	public static String xmlToString(InputStream inputstream) throws UnsupportedEncodingException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream,"gb2312"));
		StringBuffer xmlStringBuffer = new StringBuffer();
		String lineString = "";
		try {
			while((lineString = bufferedReader.readLine()) != null){
				xmlStringBuffer.append(lineString).append(System.getProperty("line.separator"));
			}
			return xmlStringBuffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	} 
	
	public static String xmlToStringNoLine(InputStream inputstream) throws UnsupportedEncodingException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream,"gb2312"));
		StringBuffer xmlStringBuffer = new StringBuffer();
		String lineString = "";
		try {
			while((lineString = bufferedReader.readLine()) != null){
				xmlStringBuffer.append(lineString);
			}
			return xmlStringBuffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	} 
	
	public static  String sqlDealBlank(String sql){
		Matcher m2 = pattern2.matcher(sql);
		StringBuffer realSqlSb = new StringBuffer();
		String lastSql="";
		int lastIndex2 = 0;
		while (m2.find()) {
			realSqlSb.append(sql.substring(lastIndex2, m2.start()));
			realSqlSb.append(" ");
			lastIndex2 = m2.end();
		}
		realSqlSb.append(sql.substring(lastIndex2));
		lastSql = realSqlSb.toString();
		return lastSql;
	}
	public static String sqlDealRoom(String sql,String [] param){
		if(sql.contains("?")){
			String str = sql.replaceFirst("\\?","'"+param[0]+"'");
			String [] temp = createArray(param);
			if(str.contains("?")){
				sqlDealRoom(str,temp);
			}
			return str;
		}
		return sql;
	}
	
	public static String []  createArray(String params []){
		if(params.length>1){
			String temp [] = new String [params.length-1];
			System.arraycopy(params, 1, temp, 0, temp.length);
			for (int i = 0; i < temp.length; i++) {
				System.out.println(temp[i]);
			}
			return temp;
		}
		return params;
	}
	
	

	
	public static List<Map<String, Object>>  getSql(List<Map<String, Object>> lists){
		Map<String, Object> map = lists.get(0);
		String sqlStr = map.get("sql").toString();
		String[] params ;
		params=(String[]) map.get("arr");
		
		if(params.length>0){
			String temp [] = new String [params.length-1];
			System.arraycopy(params, 1, temp, 0, temp.length);
			String str = sqlStr.replaceFirst("\\?", "'"+params[0]+"'");
			List<Map<String, Object>> listsTemp = new ArrayList<Map<String,Object>>();
			Map<String, Object> tempMap = new HashMap<String, Object>();
			tempMap.put("sql", str);
			tempMap.put("arr", temp);
			listsTemp.add(tempMap);
			return getSql(listsTemp);
		}
		
		System.out.println("sql=>"+sqlStr);
		return lists;
	}
	
	
		public static String [] strToArray(String str){
			String [] temp = str.split(",");
			return temp;
		} 
	
		public static void main(String[] args) {
			//String stri = "10345300145586105012440000,建设工程地震安全性评价结果审定及抗震设防要求确定,null,null,2,华软万家123";
		//	String [] temp =  strToArray(stri);
//			for (int i = 0; i < temp.length; i++) {
//				System.out.println(temp[i]);
//			}
		}
		
		public static String newSql(InputStream sqlInputstream,InputStream paramInputstream) throws UnsupportedEncodingException{
			String sqlString = xmlToStringNoLine(sqlInputstream);
			String paramString = xmlToStringNoLine(paramInputstream);
			
			String [] param= strToArray(paramString);
			
			
			List<Map<String, Object>> lists = new ArrayList<Map<String,Object>>();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sql",sqlString);
			map.put("arr", param);
			lists.add(map);
			List<Map<String, Object>> lastLists = getSql(lists);
			Map<String, Object> lastMap= lastLists.get(0);
			System.out.println(":"+sqlString);
			System.out.println(""+paramString);
			System.out.println("sql:"+lastMap.get("sql"));
			
			
			return lastMap.get("sql").toString();
		}
	/*public static void main(String[] args) {
		List<Map<String, Object>> lists = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sql", "select * from class c left join student t on t.classid = c.id where 1 = 1 and c.id in (?, ?, ?)");
		String params [] = new String[]{"1","2","3"};
		map.put("arr", params);
		lists.add(map);
		getSql(lists);
		
	}*/
//	
//	public static void main(String[] args) {
//		
//		String sql="select * from class c left join student t on t.classid = c.id where 1 = 1 and c.id in (?, ?, ?)";
//		String params [] = new String[]{"1","2","3"};
//		
//		for(){
//			
//		}
//		String str = sql.replaceFirst("\\?", "'9999'");
//		System.out.println("str="+str);
//		
//		
//	}

		public static String insertSql(String insertSql) {
			String []  temp =  insertSql.split(",");
			String result ="" ;
			for (int i = 0; i < temp.length; i++) {
				String te= "#{"+temp[i].trim()+"},";
				result += te;
			}
			return result;
		}

		public static void insertBrSql(String insertBrSql) {
			String []  temp =  insertBrSql.split(",");
			String result ="" ;
			for (int i = 0; i < temp.length; i++) {
				System.out.println("#{"+temp[i].trim()+"},");
			}
//			return result;
		}

		public static String updateSql(String delLine) {
			String []  temp =  delLine.split(",");
			String result ="" ;
			for (int i = 0; i < temp.length; i++) {
				String te= temp[i].trim()+"=#{"+temp[i].trim()+"},";
				result += te;
			}
			return result;
		}

		public static void updateBrSql(String delLine) {
			String []  temp =  delLine.split(",");
			String result ="" ;
			for (int i = 0; i < temp.length; i++) {
				System.out.println(temp[i].trim()+"=#{"+temp[i].trim()+"},");
			}
//			return result;
			
		}
		
		
		public static void sql2Br(InputStream inputstream) throws UnsupportedEncodingException{
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream,"gb2312"));
			StringBuffer xmlStringBuffer = new StringBuffer();
			String lineString = "";
			try {
				while((lineString = bufferedReader.readLine()) != null){
					xmlStringBuffer.append(lineString);
				}
				String sql =  xmlStringBuffer.toString();
				String [] arrSql = sql.split(",");
				for (int i = 0; i < arrSql.length; i++) {
					System.out.println(arrSql[i]+",");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		
		public static void sqlNotBlank(InputStream inputstream) throws UnsupportedEncodingException{
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream,"gb2312"));
			StringBuffer xmlStringBuffer = new StringBuffer();
			String lineString = "";
			try {
				while((lineString = bufferedReader.readLine()) != null){
					xmlStringBuffer.append(lineString);
				}
				String sql =  xmlStringBuffer.toString();
				String [] arrSql = sql.split(",");
				for (int i = 0; i < arrSql.length; i++) {
					System.out.println(arrSql[i].trim()+",");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 

	
}
