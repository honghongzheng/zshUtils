package sqlTools;

import java.io.File;
import java.io.FileInputStream;

import utils.Tools;

public class SqlTools {
	public static void main(String[] args) throws Exception {
		
		System.out.println(System.getProperty("user.dir")+File.separator+"file"+File.separator);
		//根路径
		String rootPath= System.getProperty("user.dir")+File.separator+"file"+File.separator;
		System.out.println("根路径:"+rootPath);
		
		//去掉换行符
		String delLine = Tools.xmlToStringNoLine(new FileInputStream(rootPath+"sqlTools.txt"));
		System.out.println("去掉换行=>"+delLine);
		
		
//*************************************************插入*********************************************		
//		组装保存
//		String insertSql =  Tools.insertSql(delLine);
//		System.out.println("insertSql:"+insertSql);
		
//		换行sql
//		 Tools.insertBrSql(delLine);
//		 
//*************************************************更新*********************************************		 
			//组装保存
//			String updateSql =  Tools.updateSql(delLine);
//			System.out.println("updateSql:"+updateSql);
//			
//			换行sql
//			 Tools.updateBrSql(delLine);
			 
		
	}
}