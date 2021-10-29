package bh.day_17.t18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.XLog;

/*
 * 1, 对集合进行遍历, 只能获取集合元素, 不能对集合进行操作
 * 2, iterator 除了可以遍历,还可以进行 remove 集合中的元素
 * 3, ListIterator 可以对集合进行 CRUD 操作
 * 4, 增强 for 循环具有局限性, 必须有遍历的目标
 */
public class Day1718 {

	public static void main(String[] args) {

		list();

		// map();

	}

	private static void map() {
		HashMap<Integer, String> hashMap = new HashMap<>();

		hashMap.put(1, "a");
		hashMap.put(2, "b");
		hashMap.put(3, "c");

		// 1
		XLog.init().debug("*** keySet ***");
		for (Integer integer : hashMap.keySet()) {
			XLog.init().debug("k: " + integer + ", v: " + hashMap.get(integer));
		}

		// 2
		XLog.init().debug("*** entrySet ***");
		for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
			XLog.init().debug("k: " + entry.getKey() + ", v: " + entry.getValue());
		}
	}

	private static void list() {
		List<String> list = new ArrayList<>();

		list.add("jj");
		list.add("hh");
		list.add("yy");

		// 对集合进行遍历, 只能获取集合元素, 不能对集合进行操作
		// 迭代器除了可以遍历, 还可以进行 remove 集合中的元素的操作
		// 如果是 ListIterator, 还可以在遍历过程中对集合进行增删改查的动作
		for (String s : list) {
			s = "mm";
		}
		XLog.init().debug(list);
	}

}
