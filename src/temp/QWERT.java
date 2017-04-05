package temp;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


 /**
 * @since zshUtils
 * @author 郑水洪  
 */
public class QWERT {
	public static void main(String[] args) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());   
        String tsStr = "";   
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");   
        try {   
            //方法一   
            tsStr = sdf.format(ts);   
            System.out.println(tsStr);   
            //方法二   
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
		if (obj instanceof Timestamp) {//如果是时间戳
			String tsStr = "";
			SimpleDateFormat sdf =  new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			try {   
				//方法一   
				tsStr = sdf.format(obj);   
			} catch (Exception e) {   
				
			}
			return tsStr;
		}else{
			throw new Exception("时间戳为空或时间戳类型转化出错");
		}
		
	}
	
	
	
	
	
	
}
