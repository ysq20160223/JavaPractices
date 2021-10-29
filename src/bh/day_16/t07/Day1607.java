package bh.day_16.t07;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import bh.day_16.Student;
import utils.XLog;

/*
 * TreeMap Comparator
 */
public class Day1607 {

	public static void main(String[] args) {

		// Map<Student, String> map = new TreeMap<Student, String>(); // 默认排序
		Map<Student, String> map = new TreeMap<Student, String>(new NameComparator());

		map.put(new Student("hh", 17), "HH");
		XLog.init().debug(null);

		map.put(new Student("jj", 1), "JJ");
		XLog.init().debug(null);

		map.put(new Student("jj", 1), "JJJ"); // key 相同, 覆盖 value
		XLog.init().debug(null);

		map.put(new Student("yy", 21), "YY");
		XLog.init().debug(null);

		XLog.init().debug("*** entrySet ***");
		Set<Map.Entry<Student, String>> entrySet = map.entrySet();
		for (Iterator<Map.Entry<Student, String>> it = entrySet.iterator(); it.hasNext();) {
			Map.Entry<Student, String> me = it.next();
			Student s = me.getKey();
			// String add = me.getValue();
			XLog.init().debug(s + ", Address: " + map.get(s));
		}
	}

}

// 先按名字排序, 后按年龄排序
class NameComparator implements Comparator<Student> {
	@Override
	public int compare(Student s0, Student s1) {
		int flag = s0.getName().compareTo(s1.getName());
		if (flag > 1) {
			flag = 1;
		} else if (flag < 0) {
			flag = -1;
		}

		XLog.init().debug("nameCompare : " + s0 + " - " + s1 + " : " + flag);

		if (flag == 0) {
			return new Integer(s0.getAge()).compareTo(s1.getAge());
		}
		return flag;
	}
}
