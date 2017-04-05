
 /*
  * 文件名：Test.java
  * 作者：  郑水洪
  * 创建日期：2016-1-1
  * 描述：
  * 
  *    
  * 修改记录
  * 修改人：
  * 修改日期：
  * 修改内容：
  * 
  *
  */
package clob$blob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


 /**
 * 类描述<p>
 *    此类关联设计的功能
 * @author 郑水洪
 * @version 1.0,2016-1-1
 * @see 
 * @since bigData
 *      
 */
public class CopyOfTest {
	
	//封装公共连接
		public static Connection getConnection(){
			Connection connection = null;
			try{
				//加载驱动
				Class.forName("oracle.jdbc.driver.OracleDriver");//没有用到
				connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","demo","demo");
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
		//创建表
		public static boolean createTb(){
			boolean bool=false;
			StringBuffer sql= new StringBuffer();
			sql.append(" ");
			sql.append(" create table DMNEW");
			sql.append(" (");
			sql.append(" id    NUMBER,");
			sql.append(" erjin BLOB,");
			sql.append(" txt   CLOB");
			sql.append(" )");
			sql.append(" tablespace DEMO");
			sql.append(" pctfree 10");
			sql.append(" initrans 1");
			sql.append(" maxtrans 255");
			sql.append(" storage");
			sql.append(" (");
			sql.append(" initial 64");
			sql.append(" minextents 1");
			sql.append(" maxextents unlimited");
			sql.append(" )");
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			try{
				connection=getConnection();
				preparedStatement=connection.prepareStatement(sql.toString());
				preparedStatement.executeUpdate();
				
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
		//http://www.chengxuyuans.com/oracle/64860.html
		
		//创建表
		public static boolean inser(InputStream inputStream,long len,int i,Reader reader){
			boolean bool=false;
			StringBuffer sql= new StringBuffer();
			sql.append(" insert into dmnew (id,txt) values(?,?)");
			
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			try{
				connection=getConnection();
				preparedStatement=connection.prepareStatement(sql.toString());
				
				preparedStatement.setInt(1, 2);
				preparedStatement.setClob(2, reader, len);
				//preparedStatement.setAsciiStream(2, inputStream,len);//字节长度
//				preparedStatement.setBinaryStream(2, inputStream,len);//字节码长度
				preparedStatement.execute();
				
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
		
		       //读取数据库的clob
				public static void readerClob(){
					Connection connection=null;
					ResultSet rSet =null;
					PreparedStatement pStatement=null;
					String sql = " select * from dmnew";
					try{
						connection =getConnection();
						//SQL执行器
						pStatement= connection.prepareStatement(sql);
						rSet=pStatement.executeQuery();
						while(rSet.next()){
							
//							java.sql.Blob ablob = rs.getBlob(2); //和操作其它基本类型的字段一样 
//							System.out.println(ablob.length()); //简单地操作Blob的实例 
//							//实际你可以使用Clob的API对其进行任何它允许的操作，请查API 
//							InputStream bis = ablob.getBinaryStream() ; //得到Blob实例的字节流 
//							
//							
							//rSet.getString("colum");
							java.sql.Clob clob = rSet.getClob("txt");
							InputStream inputStream = clob.getAsciiStream();
							
							File file = new File("D://out.txt");
							OutputStream os = new FileOutputStream(file);
							
							int c = inputStream.read();
							while(c!=-1){
								os.write((char)c);
								c = inputStream.read();
							}
							
							os.flush();
							os.close();
							inputStream.close();
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
				}
				// [\t]+  ==>sql.append("
				// \s+\R  ==>");\r\n
//				eclipse可以用：
//				<[^<]*</
//				http://tool.oschina.net/regex
//				<[^>]*>
				
				
	
	public static void main(String[] args) throws IOException {
		//插入clob（可以存文本或字节码）
		File file = new File("D:/分页查询.txt");
		int len = (int)file.length();
		System.out.println(len);
		long l = file.length();
		
		//InputStream inputStream = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(  
	                new FileInputStream("D:/分页查询.txt"),"gbK")); 
		inser(null,l,len,br);
		//inputStream.close();
		
		//读取clob
		
		//readerClob();
		
		StringBuffer sql = new StringBuffer();
		
	}
}
