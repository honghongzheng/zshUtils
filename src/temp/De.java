package temp;

import java.io.File;


 /**
 * @since zshUtils
 * @author ֣ˮ��  
 */
public class De {
	public static void main(String[] args) {
		System.out.println();
		File file = new File("F:/temp/087754114/����.jpg");
		if (file.exists()) {
			boolean bool = file.delete();
			System.out.println(bool);
		}
	}
	
}
