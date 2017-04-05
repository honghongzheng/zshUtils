package temp;

import java.io.File;


/**
 * @since zshUtils
 * @author 郑水洪  
 */
public class yuiop {
	public static void main(String[] args) {
		String newPathDir = "F:/temp/kkkkk/pppp";
		File file = new File(newPathDir);
		file.mkdirs();
		System.out.println(file.exists());
//		file.delete();
		System.out.println(file.exists());
		File f =new File("F:/temp/kkkkk");
		if(f.exists()){
			if(f.isDirectory()){ // 首先判断该路径是否是文件夹，如果不是就自己结束吧，此处省略不是文件夹的情况
				File[] fileList = f.listFiles();// 得到该文件夹下的所有文件和文件夹列表	
				for(File fs : fileList) {  //  循环该列表
					if(fs.isFile()) {  // 如果得到的为文件，则提示
						System.out.println("有文件");
					}
					if(fs.isDirectory()){
						System.out.println("有其他目录");
					}
					
				}
			}
		}else{
			System.out.println("无此目录");
		}

	}
}
