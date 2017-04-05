package forDemo;


 /**
 * @since zshUtils
 * @author Ö£Ë®ºé  
 */
public class TestFor {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println("i="+i);
			if (2==i) {
				try {
					throw new Exception();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//continue;
				}
			}
		}
	}
}
