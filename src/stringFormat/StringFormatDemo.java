package stringFormat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * @Title:StringFormatDemo
 * @Description:TODO
 * @author:zsh
 * @date:2017年4月5日
 * @version 1.0,2017年4月5日
 * @{tags}
  */
public class StringFormatDemo {
	public static void main(String[] args) {
//		StringBuilder sb = new StringBuilder();
//		sb.append("Hello")
		
		
		StringBuffer dicSQL = new StringBuffer();
		dicSQL.append("SELECT type.type_code, type.type_name, t.dict_key, t.dict_value, t.sort ");
		dicSQL.append("FROM t_dictionary t JOIN t_dictionary_type type ON t.dict_type_id = type.id ");
		dicSQL.append("ORDER BY t.sort ");
//		System.out.println(dicSQL.toString());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type_code", 23);
		map.put("dict_key", 9);
		map.put("dict_value", 9);
		String st= String.format("%S%S%S%S", map.get("type_code"), map.get("dict_key"), map.get("dict_value"));
		System.out.println(st);
	}
}
