package strIn;


/**
 * @since DemoJava
 * @author ֣ˮ��  
 */
public class OracleIns {

	//wm_caontact ��ѯ������in�����ַ���
	public static void main(String[] args) { 
		String [] strs ={"1","2","3","4","5","6","7","8","9","4","5","6","7","8","9","4","5","6","7","8","9"};
		System.out.println(test1(strs, "name",""));
	}
	public static String test1(String [] strs,String column,String oldSql){
		StringBuffer inSql = new StringBuffer();
		if(strs.length<=10){
			inSql.append(oldSql);
			inSql.append(" or ").append(column).append(" in (");
			for (int i = 0; i < strs.length; i++) {//0-999
				//inSql.append(strs[i]).append(",");
				inSql.append("'").append(strs[i]).append("'").append(",");
				
			}
			inSql.replace(inSql.length()-1, inSql.length(), ")");
			
			return inSql.substring(3, inSql.length()).toString();//��󷵻ز�׷��
		}else{
			inSql.append(oldSql);
			inSql.append(" or ").append(column).append(" in (");
			for (int i = 0; i < 9; i++) {//0-999
//				inSql.append(strs[i]).append(",");
				inSql.append("'").append(strs[i]).append("'").append(",");
			}
			inSql.append(strs[9]).append(") ");
//			String [strs.length-10] tempArrayStr;
			String [] tempArrayStr = new String [strs.length-10];
			
			for (int i = 10,j=0; i < strs.length; i++,j++) {//0-999
				tempArrayStr[j] = strs[i];
			}
			
			return test1(tempArrayStr,column,inSql.toString());
		}
		//return "hellloooooooooooooooo";
	}
/*	public static String test1(String [] strs,String column,String oldSql){
		StringBuffer inSql = new StringBuffer();
		if(strs.length<=10){
			inSql.append(oldSql);
			inSql.append(" or ").append(column).append(" in (");
			for (int i = 0; i < strs.length; i++) {//0-999
				inSql.append(strs[i]).append(",");
				
			}
			inSql.replace(inSql.length()-1, inSql.length(), ")");
			
			return inSql.substring(3, inSql.length()).toString();//��󷵻ز�׷��
		}else{
			inSql.append(oldSql);
			inSql.append(" or ").append(column).append(" in (");
			for (int i = 0; i < 9; i++) {//0-999
				inSql.append(strs[i]).append(",");
			}
			inSql.append(strs[9]).append(") ");
//			String [strs.length-10] tempArrayStr;
			String [] tempArrayStr = new String [strs.length-10];
			
			for (int i = 10,j=0; i < strs.length; i++,j++) {//0-999
				tempArrayStr[j] = strs[i];
			}
			
			return test1(tempArrayStr,column,inSql.toString());
		}
		//return "hellloooooooooooooooo";
	}
*/	
	/*public static String test1(String [] strs,String column,String oldSql){
		StringBuffer inSql = new StringBuffer();
		if(strs.length<=1000){
			inSql.append(oldSql);
			inSql.append(" or ").append(column).append(" in (");
			for (int i = 0; i < strs.length; i++) {//0-999
				inSql.append(strs[i]).append(",");
				
			}
			inSql.replace(inSql.length()-1, inSql.length(), ")");
			return inSql.toString();//��󷵻ز�׷��
		}else{
			for (int i = 0; i < 999; i++) {//0-999
				inSql.append(oldSql);
				inSql.append(strs[i]).append(",");
				
			}
			inSql.append(strs[999]).append(") or ( in ");
			String [] tempArrayStr = null;
			
			for (int i = 1000,j=0; i < strs.length; i++,j++) {//0-999
				tempArrayStr[j] = strs[i];
			}
			
			test1(tempArrayStr,column,inSql.toString());
		}
		return "hellloooooooooooooooo";
	}*/
}
