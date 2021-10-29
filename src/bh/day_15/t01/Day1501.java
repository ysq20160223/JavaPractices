package bh.day_15.t01;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import utils.XLog;

/*
 * Set:无序，不可以重复元素
 * 		|--HashSet:数据结构是哈希表，线程是非同步的
 * 			保证元素唯一性的原理： hashCode, equals(重要)
 * 
 * 		|--TreeSet：可以对Set集合中的元素进行排序
 * 			底层数据是二叉树
 * 			保证元素唯一性的依据： 实现 Comparable接口, 覆盖 compareTo 抽象方法, 按返回值排序
 * 				新添加的元素默认和列表中的第二个元素开始比较
 * 				返回 -1: 前面
 * 				返回 0: 相同元素
 * 				返回 1: 后面
 * 			这种方式也称为元素的自然顺序，或者叫做默认顺序
 */

public class Day1501 {

	public static void main(String[] args) {
		Set<Object> set = new TreeSet<Object>();

		set.add("cc");
		set.add("cc");

		set.add("aa");
		set.add("bb");

		for (Iterator<Object> iterator = set.iterator(); iterator.hasNext();) {
			XLog.init().debug(iterator.next());
		}
	}

}
