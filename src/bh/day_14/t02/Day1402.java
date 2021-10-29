package bh.day_14.t02;

import java.util.ArrayList;
import java.util.List;

import utils.XLog;

/*
 * 1，add方法的参数类型是Object,以便于接收任意类型对象
 * 
 * 2，集合中存储的都是对象的引用（地址）
 */
public class Day1402 {

	public static void main(String[] args) {
		// method_first();

		method_second(); //
	}

	public static void method_second() {
		// 构造一个初始容量为 10 的空列表
		// 此类大致上等同于 Vector 类，除了此类是不同步的
		List<String> list01 = new ArrayList<String>();
		List<String> list02 = new ArrayList<String>();

		// add方法的参数类型是Object,以便于接收任意类型对象
		for (int i = 0; i < 3; i++) {
			list01.add("java-" + i);
		}
		list01.set(0, "java-00");

		for (int i = 2; i < 5; i++) {
			list02.add("java-" + i);
		}
		XLog.init().debug("list01 size: " + list01.size());
		XLog.init().debug("list01: " + list01);

		XLog.init().debug("list02 size: " + list02.size());
		XLog.init().debug("list02: " + list02);

		list01.retainAll(list02); // list01 仅保留和 list02 相同的元素
		// list01.removeAll(list02); // list01 删除和 list02 相同的元素

		XLog.init().debug("list01 size: " + list01.size());
		XLog.init().debug("list01: " + list01);
	}

	public static void method_first() {
		List<String> list = new ArrayList<String>();

		// add方法的参数类型是Object,以便于接收任意类型对象
		for (int i = 0; i < 3; i++) {
			list.add("java-" + i);
		}
		XLog.init().debug("Before size: " + list.size());
		XLog.init().debug("Before: " + list);

		list.remove(1);

		XLog.init().debug("After size: " + list.size());
		XLog.init().debug("After: " + list);
	}

}
