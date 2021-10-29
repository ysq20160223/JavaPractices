package bh.day_15.t07;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import utils.XLog;

public class Day1507_01 {

	public static void main(String[] args) {

		Set<Person> set = new TreeSet<Person>();
		set.add(new Person("yy", 21));
		set.add(new Person("jj", 1));

		// set.add(new Person("jj", 1));

		set.add(new Person("hh", 17));
		set.add(new Person("ll", 3));

		for (Iterator<Person> iterator = set.iterator(); iterator.hasNext();) {
			XLog.init().debug(iterator.next());
		}
	}

}

class Person implements Comparable<Person> {

	private String mName;
	private int mAge;

	public Person(String name, int age) {
		mName = name;
		mAge = age;
	}

	public String getName() {
		return mName;
	}

	public int getAge() {
		return mAge;
	}

	@Override
	public int compareTo(Person p) {
		int num = new Integer(mAge).compareTo(new Integer(p.mAge));
		if (num == 0) {
			return this.mName.compareTo(p.mName);
		}
		return num;
	}

	@Override
	public String toString() {
		return "[name: " + mName + ", age: " + mAge + "]";
	}

}
