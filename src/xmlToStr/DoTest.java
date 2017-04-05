package xmlToStr;


 /**
 * @since zshUtils
 * @author Ö£Ë®ºé  
 */
public class DoTest {
	public static void main(String[] args) {
		String str [] = new String []{"1","2 ","3  ii     "};
		for (int i = 0; i < str.length; i++) {
			int len = str[i]==null?0:str[i].toString().trim().length();
			System.out.println("len="+len);
		}
	}
}
