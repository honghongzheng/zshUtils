package forDemo;


/**
 * �����쳣��������ִ��forѭ��
 * @author zhesh
 *
 */
public class ForException {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			try{
				System.out.println("i="+i);
				System.out.println(i/1);
				if(i==2){
					System.out.println("i="+i);
					System.out.println(i/0);
				}
			}catch (Exception e) {
				try{
					System.out.println("�쳣1��"+e);
					int j=1/0;
				}catch (Exception ex) {
					// TODO: handle exception
					System.out.println("�쳣2��"+ex);
				}
			}
		}
		
	}
}
