package test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapDemo {
	public static <T> void main(String[] args) {
		Map<String,	String> map=new HashMap<String,String>();
		map.put("1", "1");
		map.put("33", "3");
		map.put("2", "2");
		System.out.println(map.toString());
		TreeMap<String, String> map2=new TreeMap<String,String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		map2.put("1", "1");
		map2.put("33", "3");
		map2.put("2", "2");
		System.out.println(map2.toString());
		Map<String, String> map3=new LinkedHashMap<>();
		map3.put("1", "1");
		map3.put("3", "3");
		map3.put("2", "2");
		System.out.println(map3.toString());
		
	}
}
