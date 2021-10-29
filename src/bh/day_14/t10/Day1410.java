package bh.day_14.t10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import utils.XLog;

/*
 * 去除ArrayList中的重复的String元素（ArrayList是可重复的）
 * String可实现默认排序
 */

public class Day1410 {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		list.add("java-0");
		list.add("java-0");
		list.add("java-1");
		list.add("java-3");
		list.add("java-3");
		list.add("java-5");

		for (Iterator<Object> iterator = list.iterator(); iterator.hasNext();) {
			XLog.init().debug(iterator.next());
		}
		XLog.init().debug("Remove Redundant After");

		List<Object> tmpList = removeRedundant(list);
		if (null != tmpList && tmpList.size() > 0) {
			list.clear();
			list.addAll(tmpList);
		}

		for (ListIterator<Object> iterator = list.listIterator(); iterator.hasNext();) {
			XLog.init().debug(iterator.next());
		}
	}

	public static List<Object> removeRedundant(List<Object> list) {
		List<Object> tmpList = new ArrayList<Object>();
		for (ListIterator<Object> iterator = list.listIterator(); iterator.hasNext();) {
			Object obj = iterator.next();
			if (!tmpList.contains(obj)) {
				tmpList.add(obj);
			}
		}
		return tmpList;
	}

}

//
