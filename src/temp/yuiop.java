package temp;

import java.io.File;


/**
 * @since zshUtils
 * @author ֣ˮ��  
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
			if(f.isDirectory()){ // �����жϸ�·���Ƿ����ļ��У�������Ǿ��Լ������ɣ��˴�ʡ�Բ����ļ��е����
				File[] fileList = f.listFiles();// �õ����ļ����µ������ļ����ļ����б�	
				for(File fs : fileList) {  //  ѭ�����б�
					if(fs.isFile()) {  // ����õ���Ϊ�ļ�������ʾ
						System.out.println("���ļ�");
					}
					if(fs.isDirectory()){
						System.out.println("������Ŀ¼");
					}
					
				}
			}
		}else{
			System.out.println("�޴�Ŀ¼");
		}

	}
}
