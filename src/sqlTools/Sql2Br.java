package sqlTools;

import java.io.File;
import java.io.FileInputStream;

import utils.Tools;

public class Sql2Br {
	public static void main(String[] args) throws Exception {
		
		System.out.println(System.getProperty("user.dir")+File.separator+"file"+File.separator);
		//根路径
		String rootPath= System.getProperty("user.dir")+File.separator+"file"+File.separator;
		System.out.println("根路径:"+rootPath);
		
		//添加换行符
		Tools.sql2Br(new FileInputStream(rootPath+"sqlTools.txt"));
		
			 
		
	}
}