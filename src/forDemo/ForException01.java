package forDemo;

/**
 * continue ��������ѭ��������һ��ѭ��
 * @author zhesh
 *
 */
public class ForException01 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
				System.out.println("i="+i);
				System.out.println(i/1);
				if(i==2){
					continue;
				}
			
		}
	}
}
