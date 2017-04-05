package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Demo;

/**
 * 类描述<p>
 *    mysql:3306,SQL SERVER:1433,ORACLE:1521
 * @author 郑水洪
 * @version 1.0,2015-7-22
 * @see 
 * @since JdbcDemo
 *      
 */
public class JdbcUtils {
	//封装公共连接
	public static Connection getConnection(){
		Connection connection = null;
		try{
			//加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");//没有用到
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","fontdb","11");
		}catch(Exception e){
			e.printStackTrace();
		}
		return connection;
	}
	//查询
	public static ArrayList<Object> query(String sql){
		Connection connection=null;
		ResultSet rSet =null;
		PreparedStatement pStatement=null;
		try{
			connection =getConnection();
			//SQL执行器
			pStatement= connection.prepareStatement(sql);
			rSet=pStatement.executeQuery();
			while(rSet.next()){
				rSet.getString("colum");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rSet!=null){
					rSet.close();
				}
				if (pStatement!=null) {
					pStatement.close();
				}
				if (connection!=null) {
					connection.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;//返回集合
	}
	//插入
	public static boolean inser(Object o){
		boolean bool=false;
		String sql=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try{
			connection=getConnection();
			preparedStatement=connection.prepareStatement(sql);
			sql="insert into emp (id,name) values(?,?)";
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, "heloo");
			int back=preparedStatement.executeUpdate();
			if(back>0)
			{
				bool=true;
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(preparedStatement!=null){
					preparedStatement.close();
				}
				if (connection!=null) {
					connection.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return bool;
	}
	
	
	//插入
		public static void  inserTime(){
			boolean bool=false;
			String sql=null;
			String sql1=null;
			String sql2=null;

			Connection connection=null;
			PreparedStatement preparedStatement=null;
			PreparedStatement preparedStatement1=null;
			PreparedStatement preparedStatement2=null;
			ResultSet rSet = null;
			try{
				connection=getConnection();
				sql = "select * from spku";
				preparedStatement=connection.prepareStatement(sql);
//				
//				sql="insert into demo (id,name) values(?,?)";
//				preparedStatement.setInt(1, 1);
//				preparedStatement.setString(2, "heloo");
				rSet = preparedStatement.executeQuery();
				Demo demo = new Demo();
				while(rSet.next()){
					demo.setTimeOne(rSet.getTimestamp("timeone"));
					demo.setName("123");
				}
				/*sql1 = "insert into demo(timeone,name) values(?,?)";
				preparedStatement1=connection.prepareStatement(sql1);
				preparedStatement1.setTimestamp(1, demo.getTimeOne());
				preparedStatement1.setString(2, demo.getName());
				preparedStatement1.executeUpdate();*/
				
				System.out.println("demo.getTimeOne():"+demo.getTimeOne());
				//.String.valueOf(exGdbsBzgz.getBzgzsj()).substring(0, String.valueOf(exGdbsBzgz.getBzgzsj()).length()-2)+
				sql2 = "update demo t set t.name='hahahh' where t.timeone=to_date('"+
						String.valueOf(demo.getTimeOne()).substring(0, String.valueOf(demo.getTimeOne()).length()-2)
				+"','yyyy-MM-dd HH24:mi:ss')";
				preparedStatement2=connection.prepareStatement(sql2);
			
				preparedStatement2.executeUpdate();
				
				
//				preparedStatement.setString(2, "heloo");
				
							
			}catch(Exception e){
				e.printStackTrace();
			}finally{
			
				
			}
		}
		
		public static void main(String[] args) {
			inserTime();
		}
}
