package bh.day_15.t12;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import utils.XLog;

/*
	泛型限定
		？： 通配符, 也可以理解为占位符
		泛型的限定：
		？ extends E： 可以接收E类型或者E的子类型，上限
		？ super E： 可以接收E类型或者E的父类型，下限	(查看TreeSet比较器)
*/
public class Day1512_01 {

	public static void main(String[] args) {

		treeSetStr();

		XLog.init().debug(null);

		treeSetInt();
	}

	public static void treeSetInt() {
		Set<Integer> set = new TreeSet<Integer>();
		set.add(123);
		set.add(908);
		set.add(589);

		printCollection(set);
	}

	public static void treeSetStr() {
		Set<String> set = new TreeSet<String>();
		set.add("yy");
		set.add("hh");
		set.add("jj");

		printCollection(set);
	}

	public static <T> void printCollection(Set<T> set) { // T和占位符?在这里都一样
		for (Iterator<T> iterator = set.iterator(); iterator.hasNext();) {
			XLog.init().debug(iterator.next());
		}
	}

	// 和上面方法一样，使用占位符有局限性
	// public static void printCollection(Set<?> ts) { // T和占位符?在这里都一样
	// for (Iterator<?> it = ts.iterator(); it.hasNext();) {
	// System.out.println(it.next());
	// }
	// }

}
