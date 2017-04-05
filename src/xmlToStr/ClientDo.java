package xmlToStr;

import java.io.File;
import java.io.FileInputStream;

import utils.Tools;

public class ClientDo {
//	public static void main(String[] args) throws Exception {
//		
//		System.out.println(System.getProperty("user.dir")+File.separator+"file"+File.separator);
//		String rootPath= System.getProperty("user.dir")+File.separator+"file"+File.separator;
//		System.out.println("rootPath:"+rootPath);
////		String xmlStr = Tools.xmlToString(new FileInputStream(rootPath+"111.xml"));
////		String xmlStr = Tools.xmlToStringNoLine(new FileInputStream(rootPath+"111.xml"));
//		String xmlStr = Tools.xmlToStringNoLine(new FileInputStream(rootPath+"sql.txt"));
//		System.out.println("=>"+xmlStr);
//		System.out.println(Tools.sqlDealBlank(xmlStr));
//		
//		String sql="select * from class c left join student t on t.classid = c.id where 1 = 1 and c.id in (?, ?, ?)";
//		//占位符替换
//		String params [] = new String[]{"1","2","3"};
//		
//		String str = sql.replaceFirst("\\?", "'9999'");
//		System.out.println("str="+str);
//		
//		
//		
//		
//		
//		
//	}
	public static void main(String[] args) throws Exception {
		
		System.out.println(System.getProperty("user.dir")+File.separator+"file"+File.separator);
		//根路径
		String rootPath= System.getProperty("user.dir")+File.separator+"file"+File.separator;
		System.out.println("根路径:"+rootPath);
		
		/*//把xml文件转回字符串
		String xmlStr = Tools.xmlToString(new FileInputStream(rootPath+"111.xml"));
		System.out.println("xml转字符串"+xmlStr);
		
		
		//把xml文件转回字符串，去掉换行
		String xmlStrDelLine = Tools.xmlToStringNoLine(new FileInputStream(rootPath+"111.xml"));
		System.out.println("把xml文件转字符串，去掉换行:"+xmlStrDelLine);
		
		*/
		//去掉换行符
		String delLine = Tools.xmlToStringNoLine(new FileInputStream(rootPath+"helo.txt"));
		System.out.println("去掉换行=>"+delLine);
		
		
//
//		//sql
//		String sqlLog = Tools.newSql(new FileInputStream(rootPath+"logsql.txt"),new FileInputStream(rootPath+"logparam.txt"));
//		System.out.println("log日志sql：=>"+sqlLog);
//	
		
		
		
		
		
	}
}