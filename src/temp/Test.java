package temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


 /**
 * @since zshUtils
 * @author 郑水洪  
 */
public class Test {
	
	public static void main(String[] args) {
//		Map map = new HashMap<String, Object>();
//		map.put("helo",new Double("123456.234"));
//		double d = map.get("helo")==null?0:(Double)map.get("helo");
//		System.out.println(d);
		
//		String str = "1234567890";
//		String temp = str.substring(3);
//		System.out.println("temp:"+temp);
		
//		Hashtable hashtable = new Hashtable(); 
//		hashtable.put("a", "qewer");
//		Object object = hashtable.get("b");//可以get不存在的key
//		System.out.println();
//		hashtable.put("e", null);//put value不能为空
		
//		StringBuffer sql = new StringBuffer();
//		sql.append("select t.CONTROL_SEQ controlSeq, t.CUST_NAME custName,t.COMPLETE_MAN_NAME completeName,i.approve_name itemName,t.approve_type approveItem, ") 
//			.append(" nvl(t.unit_name,t.work_unit_name)||'关于'||t.cust_name||'申请'||i.approve_name||'的批文' apprTitle ") 
//			.append(" from LZCITY_APPROVE_CONTROL_INFO t left join LZCITY_APPROVE_ITM_DEFINE i on t.approve_type = i.approve_item ")
//			.append(" where t.approve_status = '11' and t.exchange_status = 1 ");
//		System.out.println("获取办件信息列表sql:" + sql.toString());
		
		String sql = "select " + "t.SBLSH," + "t.SXBM," + "t.YWLSH,"
				+ "t.YSLBMMC," + "t.YSLBMZZJGDM," + "t.XZQHDM," + "t.BLRXM,"
				+ "t.BLRGH," + "t.YSLZTDM," + "t.BSLYY," + "t.BJBZSM,"
				+ "t.YSLSJ," + "t.YSLJTDD," + "t.BZ," + "t.BYZD "
				+ "from EX_GDBS_WSYSL t " + "where "
				+ "t.SBLSH is not null and " 
//				+ "t.ID is not null and "
				+ "t.jsbs = '0'";
		System.out.println("材料审核:"+sql);
		
		
		
		String sqlwwww = "select " + "t.SBLSH," + "t.SXBM," + "t.BZGZFCRXM,"
				+ "t.BZGZYY," + "t.BZCLQD," + "t.BZGZSJ," + "t.XZQHDM,"
				+ "t.BZ," + "t.BYZD, "+"t.PATCH_TIMELIMIT " + "from EX_GDBS_BZGZ t "
				+ "where "
//				+ "t.ID is not null and " 
				+ "t.SBLSH is not null and "
				+ "t.jsbs = '0'";
		
		
		System.out.println("补正告知www:"+sqlwwww);
		
		
		
		String sql3 = "select " + "t.SBLSH," + "t.SXBM," + "t.BZSLBLRXM,"
				+ "t.BZCLQD," + "t.BZSJ," + "t.XZQHDM," + "t.BZSLJTDD,"
				+ "t.BZ,t.BYZD, " +"t.RENEW_STATUS "
				+ "from EX_GDBS_BZSL t " + "where "
//				+ "t.ID is not null and " 
				+ "t.SBLSH is not null and "
				+ "t.jsbs = '0'";
		System.out.println("补正受理:"+sql3);
		
//		List<Integer> xhList  = new ArrayList<Integer>();
//		xhList.add(new Integer("2"));
//		System.out.println((int)xhList.get(0));
		
		
		
		
		
		
	}
}
