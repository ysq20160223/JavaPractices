package bh.day_15.t06;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import utils.XLog;

/*
 * 泛型：JDK1.5版本以后出现的新特性。用于解决安全问题，是一个安全机制
 * 好处：
 * 1，将运行时期出现问题ClassCastException, 转移到了编译时期,
 * 		方便于程序员解决问题，让运行事情问题减少, 安全
 * 2，避免了强制转换麻烦
 */
public class Day1506 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			list.add("java-" + i);
		}

		for (ListIterator<String> iterator = list.listIterator(); iterator.hasNext();) {
			String s = iterator.next();// 指定泛型不用强转
			XLog.init().debug(s);
		}
	}

}
