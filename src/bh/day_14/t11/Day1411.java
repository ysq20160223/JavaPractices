package bh.day_14.t11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import utils.XLog;

/*
 * 去除 ArrayList中的重复对象，必须覆盖 public boolean equals(Object object)方法
 * 
 * contain 和  remove 底层判断都是 equals 方法
 */
public class Day1411 {

	public static void main(String[] args) {

		List<Object> list = new ArrayList<Object>();
		list.add(new Person("a", 0));
		list.add(new Person("b", 1));
		list.add(new Person("b", 1));
		list.add(new Person("c", 2));

		// 因 ArrayList 所存储的为可重复，若要判断重复对象需调用 contains 方法

		for (Iterator<Object> iterator = list.iterator(); iterator.hasNext();) {
			XLog.init().debug("next: " + iterator.next());
		}

		XLog.init().debug("start remove Redundat");
		List<Object> tempList = removeRedundant(list);
		if (null != tempList && tempList.size() > 0) {
			list.clear();
			list.addAll(tempList);
		}

		for (Iterator<Object> iterator = list.iterator(); iterator.hasNext();) {
			XLog.init().debug("next: " + iterator.next());
		}
	}

	public static List<Object> removeRedundant(List<Object> list) {
		List<Object> tempList = new ArrayList<Object>();
		for (ListIterator<Object> iterator = list.listIterator(); iterator.hasNext();) {
			Object obj = iterator.next();
			if (!tempList.contains(obj)) {
				XLog.init().debug("add: " + obj + "\n");
				tempList.add(obj);
			} else {
				XLog.init().debug("contain already: " + obj + "\n");
			}
		}
		return tempList;
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
	public boolean equals(Object obj) {
		// obj 为集合中已存在的数据
		// 当执行contains时，将要添加的对象调用自身 equals 方法与原集合中已存在的数据进行比较
		XLog.init().debug("equals: " + this + ", obj: " + obj);

		if (!(obj instanceof Person)) { // 判断容器之前存储的obj元素是否是Person
			throw new ClassCastException(obj + " can not be cast to Person");
		}

		Person p = (Person) obj;
		// 判断第二个对象是否和第一个对象相同, 判断第三个对象是否和第一个、第二个相同
		return name.equals(p.name) && age == p.age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person[name: " + name + ", age: " + age + "]";
	}

}

//
