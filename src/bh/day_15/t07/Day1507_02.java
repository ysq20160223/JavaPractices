package bh.day_15.t07;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import utils.XLog;

/*
 * 泛型格式：通过<>来定义要操作的引用数据类型
 * 
 * 在使用java提供的对象时，什么时候写泛型呢
 * 
 * 通常在集合框架中很常见
 * 
 * 只要见到<>就要定义泛型
 * 
 * 其实<>就是用来接收类型的
 * 
 * 当使用集合时，将集合中要存储的数据类型作为参数传递到<>中即可
 */
public class Day1507_02 {

	public static void main(String[] args) {

		Set<String> set = new TreeSet<String>(new LengthComparator());
		set.add("elb");
		set.add("d");
		set.add("pm");
		set.add("mji");

		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			XLog.init().debug(iterator.next());
		}
	}

}

class LengthComparator implements Comparator<String> {
	@Override
	public int compare(String s0, String s1) {
		int num = new Integer(s0.length()).compareTo(new Integer(s1.length()));
		if (num == 0) {
			return s0.compareTo(s1);
		}
		return num;
	}
}
