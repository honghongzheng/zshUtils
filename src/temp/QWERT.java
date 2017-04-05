package temp;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


 /**
 * @since zshUtils
 * @author ֣ˮ��  
 */
public class QWERT {
	public static void main(String[] args) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());   
        String tsStr = "";   
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");   
        try {   
            //����һ   
            tsStr = sdf.format(ts);   
            System.out.println(tsStr);   
            //������   
            tsStr = ts.toString();   
            System.out.println(tsStr);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
       /* Timestamp ts = new Timestamp(System.currentTimeMillis()); 
        System.out.println(TimestampToDateStr(ts));*/
        try {
			System.out.println(TimestampToDateStr(null));
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public static String TimestampToDateStr(Object obj) throws Exception{
		if (obj instanceof Timestamp) {//�����ʱ���
			String tsStr = "";
			SimpleDateFormat sdf =  new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			try {   
				//����һ   
				tsStr = sdf.format(obj);   
			} catch (Exception e) {   
				
			}
			return tsStr;
		}else{
			throw new Exception("ʱ���Ϊ�ջ�ʱ�������ת������");
		}
		
	}
	
	
	
	
	
	
}
