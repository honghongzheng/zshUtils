package sort;

import java.util.*;

/**
 * 对map排序
 * @author Administrator
 * 总结：Collections可以对List进行排序；如果想对Map进行排序，可以将Map转化成List，进行排序；
 *
 */
public class SortMap {
	public static void main(String[] args) {
		Map<String, Integer> maps = new HashMap<String, Integer>();   
		maps.put("boy", 8);   
		maps.put("cat", 7);   
		maps.put("dog", 1);   
		maps.put("apple", 5);   
		
		Iterator i = maps.entrySet().iterator();   
		while (i.hasNext()) {   
			Map.Entry<String, Integer> entry1 = (Map.Entry<String, Integer>) i.next();   
		}   
		List<Map.Entry<String, Integer>> info = new ArrayList<Map.Entry<String, Integer>>(maps.entrySet());   
		Collections.sort(info, new Comparator<Map.Entry<String, Integer>>() {   
			public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {   
				return obj1.getValue().compareTo(obj2.getValue()); 
			}   
		}); 
		for (int j = 0; j < info.size(); j++) {
			System.out.println(info.get(j).getKey());
		}
	}
}
