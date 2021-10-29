package bh.day_16.t05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import utils.XLog;

/*
 * HashMap EntrySet
 */
public class Day1605 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < 9; i++) {
			map.put("K" + i, "V" + i);
		}

		Set<Map.Entry<String, String>> set = map.entrySet(); // 取出映射关系
		for (Iterator<Map.Entry<String, String>> it = set.iterator(); it.hasNext();) {
			Map.Entry<String, String> mapEntry = it.next();
			XLog.init().debug("key: " + mapEntry.getKey() + ", value: " + mapEntry.getValue());
		}
	}

}
