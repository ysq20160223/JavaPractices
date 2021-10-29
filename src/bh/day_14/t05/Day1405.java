package bh.day_14.t05;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import utils.XLog;

/*
 * ArrayList 的特有遍历方法 ListIterator， 线程同步, 可以在遍历的过程中 增删改查
 */

public class Day1405 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < 3; i++) {
			list.add("java-" + i);
		}

		// 错误方式: 出现并发修改异常, ava.util.ConcurrentModificationException
		// for (Iterator<String> iterator = list.iterator();
		// iterator.hasNext();) {
		// Object object = iterator.next(); // 正确, 迭代器方法, 取出
		// if (null != object && object.equals("java-1")) {
		// // list.add("java-add"); // 错误, 迭代器方法中不能用集合的方法
		// iterator.remove(); // 正确, 迭代器方法, 移除
		// }
		// }

		// 正确方式
		for (ListIterator<String> iterator = list.listIterator(); iterator.hasNext();) {
			Object object = iterator.next();
			if (null != object && object.equals("java-0")) {
				iterator.add("java-add");
			}
		}

		XLog.init().debug(list); // 和for循环遍历一样

		for (ListIterator<String> iterator = list.listIterator(); iterator.hasNext();) {
			XLog.init().debug("ListIterator: " + iterator.next());
		}
	}
}

//
