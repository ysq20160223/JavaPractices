package bh.day_16.t04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import utils.XLog;

/*
 * HashMap KeySet
 * 
 * map集合的两种取出方式：
 * 
 * 1，keySet：将map中所有的键存入到Set集合，因为Set具备迭代器
 * 		所以可以迭代方式取出所有的键，再根据get方法可以获取每一个键对应的值
 */
public class Day1604 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < 9; i++) {
			map.put("K" + i, "V" + i);
		}

		// Set<String> keySet = map.keySet();
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			XLog.init().debug("key: " + key + ", value: " + map.get(key));
		}
	}
}
