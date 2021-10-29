package bh.day_15.t02;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import utils.XLog;

/**
 * 原理参看 D1501.java 描述
 * 
 * 根据年龄排序
 *
 */

public class Day1502 {

	public static void main(String[] args) {

		Set<Object> set = new TreeSet<Object>();

		set.add(new Person("yy", 21));
		XLog.init().debug(null);

		// ----------------------------------
		set.add(new Person("jj", 1));
		XLog.init().debug(null);

		set.add(new Person("jj", 1)); // 年龄和名字一样, 视为同一对象
		XLog.init().debug(null);

		set.add(new Person("zz", 1)); // 年龄相同, 名字不同, 根据名字排序
		XLog.init().debug(null);
		// ----------------------------------

		set.add(new Person("hh", 17));
		XLog.init().debug(null);

		set.add(new Person("ll", 3));
		XLog.init().debug(null);

		for (Iterator<Object> it = set.iterator(); it.hasNext();) {
			XLog.init().debug(it.next());
		}
	}
}

class Person implements Comparable<Object> {

	private String mName;
	private int mAge;

	public Person(String name, int age) {
		this.mName = name;
		this.mAge = age;
	}

	public String getName() {
		return mName;
	}

	public int getAge() {
		return mAge;
	}

	@Override
	public int compareTo(Object obj) {
		if (!(obj instanceof Person)) {
			throw new RuntimeException("Class Cast Exception");
		}

		Person p = (Person) obj;

		if (mAge > p.mAge) {
			XLog.init().debug("this: " + this + ", obj: " + obj + ", return: 1");
			return 1;
		}

		if (mAge == p.mAge) {
			int result = mName.compareTo(p.mName);
			XLog.init().debug("this: " + this + ", obj: " + obj + ", result: " + result);
			return result;
		}

		XLog.init().debug("this: " + this + ", obj: " + obj + ", return: -1");

		return -1;
	}

	@Override
	public String toString() {
		return "[Name: " + mName + ", Age: " + mAge + "]";
	}

}
