import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Test{
	private static String className = "com.mysql.jdbc.Driver";
//	private static String url = "jdbc:mysql://192.168.10.178:3306/ehome2";
	private static String url = "jdbc:mysql://112.74.211.63:8085/ehome2";
	private static String user = "root";
	private static String password = "hsmysql";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void realseConn(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static List<Map<String, Object>> queryAll(String sql, Map<Integer, Object> conditionMap) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			if (conditionMap != null && conditionMap.size() != 0) {

				int paramNum = conditionMap.size();
				for (int i = 1; i <= paramNum; i++) {

					Object paramValue = conditionMap.get(i);

					if ("java.lang.Integer".equalsIgnoreCase(paramValue.getClass().getName())) {
						pstmt.setInt(i, Integer.parseInt(paramValue.toString()));
					} else if ("java.lang.String".equalsIgnoreCase(paramValue.getClass().getName())) {
						pstmt.setString(i, paramValue.toString());
					}
				}
			}

			rs = pstmt.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnNum = rsmd.getColumnCount();
			while (rs.next()) {
				Map<String, Object> dataMap = new HashMap<String, Object>(0);
				for (int i = 1; i <= columnNum; i++) {
					dataMap.put(rsmd.getColumnName(i), rs.getObject(i));
				}
				resultList.add(dataMap);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			realseConn(conn, pstmt, rs);
		}

		return resultList;
	}

//
//	public static void 1() {
//		String sql = "select * from  where id=? and name=?";
//		Map<Integer, Object> conditionMap = new HashMap<Integer, Object>();
//		conditionMap.put(1, 5);
//		conditionMap.put(2, "e");
//		List<Map<String, Object>> resultList = .queryAll(sql, conditionMap);
//		System.out.println(resultList);
//	}
//
//	public static void 2() {
//		String sql = "select * from user where id=? and username=?";
//		Map<Integer, Object> conditionMap = new HashMap<Integer, Object>();
//		conditionMap.put(1, 1);
//		conditionMap.put(2, "admin");
//		List<Map<String, Object>> resultList = .queryAll(sql, conditionMap);
//		System.out.println(resultList);
//	}
//
//	public static void 3() {
//		String sql = "select * from user";
//		List<Map<String, Object>> resultList = .queryAll(sql, null);
//		System.out.println(resultList);
//	}
	
	public static String getValue(Map map,String key){
		return map.get(key.toUpperCase())==null? "":map.get(key.toUpperCase()).toString();
	}
	
	public static void  listWrite(List<List<Map<String, Object>>> bigList,String typ) throws Exception{
		for (int i = 0; i < bigList.size(); i++) {
			List<Map<String, Object>> list = bigList.get(i);
			String fileName = "";//文件名
			String tbName ="";//表名
			Workbook wb = null;
			Sheet sheet1 = null;
			try {
				if ("xls".equals(typ)) {  
					wb = new HSSFWorkbook();  
				} 
				else if("xlsx".equals(typ))
				{  
					wb = new XSSFWorkbook();  
				}  
				else  
				{  
					System.out.println("您的文档格式不正确！");
					throw new Exception("您的文档格式不正确！");
				}
				//列名
				Set<String> set =new HashSet<String>();
				Map<String, Object> columnMap = new HashMap<String, Object>();
				if(list==null || (list!=null && list.size()==0)){
//					MoveThread.log.info("=================导出excel数据源为空,不生成excel===============");
					System.out.println ("=================导出excel数据源为空,不生成excel===============");
					continue;
				}
				columnMap = list.get(0);//行数据
				Object [] columnArray =null;
				if (set!=null && set.isEmpty()) {
					set = columnMap.keySet();//第一次初始化
					if("".equals(Test.getValue(columnMap, "file_name"))){
						fileName = Test.getValue(columnMap, "tb_name");
					}else{
						fileName = Test.getValue(columnMap, "file_name");
					}
					tbName = Test.getValue(columnMap, "tb_name");
					columnArray = set.toArray();//可以转换为数组
				}
				//创建sheet对象  
				sheet1 = (Sheet) wb.createSheet("rr");//
				
				Row row = (Row) sheet1.createRow(0);
				for (int l = 0; l < columnArray.length; l++) {
					Cell cell = row.createCell(l);
					cell.setCellValue(columnArray[l]==null?"":columnArray[l].toString());
				}
				//循环写入行数据  
				for (int j = 0; j < list.size(); j++) {
					
						Map<String, Object> map = list.get(j);
						Map<String, Object> columnData = new HashMap<String, Object>();
						columnData = list.get(j);//行数据
						Row row2 = (Row) sheet1.createRow(j+1);
						for (int l = 0; l < columnArray.length; l++) {
							Cell cell = row2.createCell(l);
							cell.setCellValue(Test.getValue(map, columnArray[l]==null?"":columnArray[l].toString()));
						}
				}
				//创建文件流  
				OutputStream stream = new FileOutputStream("D:/"+"2222sqqdfs"+"."+typ);  
				//写入数据  
				wb.write(stream);  
				//关闭文件流  
				stream.close(); 
//				System.out.println("1234567890-");
			} catch (Exception e) {
				throw new Exception("导出excel时,"+fileName+"文件(表名"+tbName+")出错:"+e);
			}
			
		}

}

	
	public static void main(String[] args) throws Exception {
//		1();
//		2();
//		3();
//		String sql = "select * from sys_user where ";
		String sql = "select t.id,t.USER_ID,t.USERNAME,t.password,t.name,t.LAST_LOGIN,t.cityName from sys_user t where createDate between '2016-08-22 00:00:00' and '2016-08-26 00:00:00'";
		 List<List<Map<String, Object>>> bigList = new ArrayList<List<Map<String, Object>>>();
		List<Map<String , Object>> maps = queryAll(sql,null);
		bigList.add(maps);
		listWrite(bigList,"xls");
	}
	
	
}