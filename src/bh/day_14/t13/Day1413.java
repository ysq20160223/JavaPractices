package bh.day_14.t13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import utils.XLog;

/*
 * |--Set
 * 		|--HashSet
 * 			通过元素的两个方法，hashCode和equals来完成的
 * 			如果元素的HashCode相同，才会判断equals
 * 			如果元素的HashCode不同，不会调用equals
 * 
 * 	注意：对于判断元素是否存在，以及删除等操作，
 * 	依赖的方法是元素的hashCode和equals方法
 * 
 */

public class Day1413 {

	public static void main(String[] args) {
		Set<Object> hs = new HashSet<Object>();
		hs.add(new Person("yy", 21));
		XLog.init().debug(null);

		hs.add(new Person("hh", 17));
		XLog.init().debug(null);

		hs.add(new Person("hh", 17));
		XLog.init().debug(null);

		hs.add(new Person("jj", 1));
		XLog.init().debug(null);

		for (Iterator<Object> it = hs.iterator(); it.hasNext();) {
			XLog.init().debug(it.next());
		}
	}

}

class Person {

	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		int result = name.hashCode() + age * 21; // * 21 为了提高效率
		XLog.init().debug("hashCode: " + this + ", return: " + result);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		XLog.init().debug("equals: " + this + ", obj: " + obj);

		if (!(obj instanceof Person)) {
			return false;
		}
		Person p = (Person) obj;
		return name.equals(p.name) && age == p.age;
	}

	@Override
	public String toString() {
		return "Person[name: " + name + ", age: " + age + "]";
	}

}

//
