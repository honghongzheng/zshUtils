
 /*
  * �ļ�����Test.java
  * ���ߣ�  ֣ˮ��
  * �������ڣ�2016-1-1
  * ������
  * 
  *    
  * �޸ļ�¼
  * �޸��ˣ�
  * �޸����ڣ�
  * �޸����ݣ�
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
 * ������<p>
 *    ���������ƵĹ���
 * @author ֣ˮ��
 * @version 1.0,2016-1-1
 * @see 
 * @since bigData
 *      
 */
public class CopyOfTest {
	
	//��װ��������
		public static Connection getConnection(){
			Connection connection = null;
			try{
				//��������
				Class.forName("oracle.jdbc.driver.OracleDriver");//û���õ�
				connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","demo","demo");
			}catch(Exception e){
				e.printStackTrace();
			}
			return connection;
		}
		//��ѯ
		public static ArrayList<Object> query(String sql){
			Connection connection=null;
			ResultSet rSet =null;
			PreparedStatement pStatement=null;
			try{
				connection =getConnection();
				//SQLִ����
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
			return null;//���ؼ���
		}
		//������
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
		
		//������
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
				//preparedStatement.setAsciiStream(2, inputStream,len);//�ֽڳ���
//				preparedStatement.setBinaryStream(2, inputStream,len);//�ֽ��볤��
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
		
		       //��ȡ���ݿ��clob
				public static void readerClob(){
					Connection connection=null;
					ResultSet rSet =null;
					PreparedStatement pStatement=null;
					String sql = " select * from dmnew";
					try{
						connection =getConnection();
						//SQLִ����
						pStatement= connection.prepareStatement(sql);
						rSet=pStatement.executeQuery();
						while(rSet.next()){
							
//							java.sql.Blob ablob = rs.getBlob(2); //�Ͳ��������������͵��ֶ�һ�� 
//							System.out.println(ablob.length()); //�򵥵ز���Blob��ʵ�� 
//							//ʵ�������ʹ��Clob��API��������κ�������Ĳ��������API 
//							InputStream bis = ablob.getBinaryStream() ; //�õ�Blobʵ�����ֽ��� 
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
//				eclipse�����ã�
//				<[^<]*</
//				http://tool.oschina.net/regex
//				<[^>]*>
				
				
	
	public static void main(String[] args) throws IOException {
		//����clob�����Դ��ı����ֽ��룩
		File file = new File("D:/��ҳ��ѯ.txt");
		int len = (int)file.length();
		System.out.println(len);
		long l = file.length();
		
		//InputStream inputStream = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(  
	                new FileInputStream("D:/��ҳ��ѯ.txt"),"gbK")); 
		inser(null,l,len,br);
		//inputStream.close();
		
		//��ȡclob
		
		//readerClob();
		
		StringBuffer sql = new StringBuffer();
		
	}
}
