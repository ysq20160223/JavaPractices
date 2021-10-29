package bh.day_15.t05;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import utils.XLog;

/*
 * 需求：实现按字符串长度进行排序
 */
public class Day1505 {

	public static void main(String[] args) {
		Set<Object> set = new TreeSet<Object>(new StringLengthComparator());
		set.add("x");
		set.add("exb");
		set.add("jxf");
		set.add("pk");

		for (Iterator<Object> it = set.iterator(); it.hasNext();) {
			XLog.init().debug(it.next());
		}
	}

}

class StringLengthComparator implements Comparator<Object> {
	@Override
	public int compare(Object obj0, Object obj1) {
		String s0 = (String) obj0;
		String s1 = (String) obj1;

		int num = new Integer(s0.length()).compareTo(new Integer(s1.length()));
		if (num == 0) {
			return s0.compareTo(s1);
		}
		return num;
	}
}
