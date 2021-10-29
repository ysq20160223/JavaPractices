package bh.day_15.t04;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import utils.XLog;

/*
 * 实现自定义对象默认排序(实现 Comparable)和集合自身排序(比较器排序 Comparator子类)
 */
public class Day1504 {

	public static void main(String[] args) {

		// Set<Object> set = new TreeSet<Object>(); // 使用默认排序必须实现 Comparable
		Set<Object> set = new TreeSet<Object>(new NameComparator()); // 按名字排序

		set.add(new Person("yy", 21));
		XLog.init().debug(null);

		set.add(new Person("jj", 1));
		XLog.init().debug(null);

		set.add(new Person("hh", 17));
		XLog.init().debug(null);

		// set.add(new Person("ll", 3));
		// Logcat.init().debug(null);

		for (Iterator<Object> iterator = set.iterator(); iterator.hasNext();) {
			XLog.init().debug(iterator.next());
		}
	}
}

/**
 * 参看 1503 默认按年龄排序
 */
class Person {

	public String name;
	public int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "[name: " + name + ", age: " + age + "]";
	}

}

/**
 * 自定义比较器, 按名字排序
 */
class NameComparator implements Comparator<Object> {

	@Override
	public int compare(Object obj0, Object obj1) {
		Person p0 = (Person) obj0;
		Person p1 = (Person) obj1;

		int num = p0.getName().compareTo(p1.getName());
		if (num > 1) {
			num = 1;
		} else if (num < 0) {
			num = -1;
		} else {
			int result = new Integer(p0.getAge()).compareTo(new Integer(p1.getAge()));
			XLog.init().debug(p0 + ", " + p1 + ", result: " + result);
			return result;
		}

		XLog.init().debug(p0 + ", " + p1 + ", num: " + num);
		return num;
	}
}
