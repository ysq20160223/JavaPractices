package bh.day_16.t03;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import utils.XLog;

/*
 * Map
 * 		|--HashTable： 底层是哈希表数据结构，不可以存入null键和null值
 * 			该集合是线程同步的，JDK1.0 效率低
 * 		|--HashMap： 底层是哈希表数据结构，允许使用null键和null值，该集合是不同步的，
 * 			将HashTable替代，JDK1.2 效率高
 * 		|--TreeMap: 底层是二叉树数据结构，线程不同步，可以用于给map集合中的键进行排序
 * 
 * 添加元素时，如果出现相同的键，那么后添加的值会覆盖原有的键所对应的值，并返回被覆盖的值 
 * 		例: android SharedPrefres存储
 * 
 * 和Set很像： Set底层就是使用了Map集合
 * 
 */
public class Day1603 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("01", "jj");
		map.put("03", "ll");
		map.put("17", "hh");
		map.put("21", "yy");

		XLog.init().debug("map: " + map);

		// 2, remove,clear
		XLog.init().debug("remove: " + map.remove("03"));
		XLog.init().debug("remove after, map: " + map);

		// 3, 添加相同的键, 后添加的值会覆盖原有键对应值,并会返回被覆盖的值
		XLog.init().debug(map.put("03", "ll") + ", " + map.put("03", "LL"));
		XLog.init().debug("map: " + map);

		// 4, contains
		XLog.init().debug("is containsKey 01: " + map.containsKey("01"));
		XLog.init().debug("is containsValue jj: " + map.containsValue("jj"));

		Collection<String> collection = map.values();
		XLog.init().debug("collection: " + collection);
	}
}
