
 /*
  * 文件名：Test.java
  * 作者：  郑水洪
  * 创建日期：2016年7月28日
  * 描述：
  * 
  *    
  * 修改记录
  * 修改人：
  * 修改日期：
  * 修改内容：
  * 
  *
  */
package base64;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
  * 类描述<p>
  *    此类关联设计的功能
  * @author 郑水洪
  * @version 1.0,2016年7月28日
  * @see 
  * @since zshUtils
  *      
  */
public class Test {
	/**
	 * @Descriptionmap 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	 * @author temdy
	 * @Date 2015-01-26
	 * @param path 图片路径
	 * @return
	 */
	public static String imageToBase64(String path) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	    byte[] data = null;
	    // 读取图片字节数组
	    try {
	        InputStream in = new FileInputStream(path);
	        data = new byte[in.available()];
	        in.read(data);
	        in.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    // 对字节数组Base64编码
	    BASE64Encoder encoder = new BASE64Encoder();
	    return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	/**
	 * @Descriptionmap 对字节数组字符串进行Base64解码并生成图片
	 * @author temdy
	 * @Date 2015-01-26
	 * @param base64 图片Base64数据
	 * @param path 图片路径
	 * @return
	 */
	public static boolean base64ToImage(String base64, String path) {// 对字节数组字符串进行Base64解码并生成图片
	    if (base64 == null){ // 图像数据为空
	        return false;
	    }
	    BASE64Decoder decoder = new BASE64Decoder();
	    try {
	        // Base64解码
	        byte[] bytes = decoder.decodeBuffer(base64);
	        for (int i = 0; i < bytes.length; ++i) {
	            if (bytes[i] < 0) {// 调整异常数据
	                bytes[i] += 256;
	            }
	        }
	        // 生成jpeg图片
	        OutputStream out = new FileOutputStream(path);
	        out.write(bytes);
	        out.flush();
	        out.close();
	        return true;
	    } catch (Exception e) {
	    	System.out.println(e);
	        return false;
	    }
	}
	
	public static void main(String[] args) throws Exception{
		try {
			String str = imageToBase64("D:/Test.png");
			System.out.println("str:"+str);
//			System.out.println(base64ToImage("iVBORw0KGgoAAAANSUhEUgAAABYAAAAVCAYAAABCIB6VAAABu0lEQVQ4jWNsnLLqPwMNABMtDAUBxv0MDBS5+NCUVVjFaeZilr9oAnIlJQz8ZmZYFT/s6mL4dOYMeQZLp6czcKmoYFV8q7KSAV09ToP/IHFYhYTAhv7/94/hVk0NAwOQhoH/f/8yfLp7l0hj0QwWMjcH019v32a42d5OtCEEDeY3NQXTTOzsDLozZ+LU9HrvXoYnq7CnBqwGC0BdzKWgwKCYloZT08sDBxj+4JTFYrAQ1MVHIyIYPt+5AxfnkpFhsFy4kIGVn5/h1tSpDPdWrCBgLJLBvEpKDOyiogx/v39nuLd2LcP/PxAZbllZBuuVK8GGXuvtZThTWgqMScJ5Cm6wIDTtvj1/nuE31FAeOTkGt/37wZZeBEbm2aoqggbCABMoXYKwMDQYXp48CeZzysszeALDEmTo2YYGhlNAQ5mBrpYNDGSA6cGXpplAbgPhv8A0+2TPHoaHO3Yw/GViYvDctYuBV1ERrMgAmDHi3r5liP/wgcG4qYkBpgdfBMKD4jAo7JDAnTVrGMRMTMDhyQMMZzZeXoaXwOx8cfJkgikCbDAu7xypriZCO25Au9LtE47ylFJAMxfTzGAAAvKWT59ouCEAAAAASUVORK5CYII=", "D:/a/1.jpg"));
			System.out.println(base64ToImage("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", "D:/a/2.jpg"));
			
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
	}
}
