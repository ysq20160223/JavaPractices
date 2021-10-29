package bh.day_15.t12;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import utils.XLog;

public class Day1512_02 {

	public static void main(String[] args) {
		List<Person> alP = new ArrayList<Person>();
		alP.add(new Person("p - aaa"));
		alP.add(new Person("p - eee"));
		alP.add(new Person("p - ccc"));
		printCollection(alP);

		XLog.init().debug(null);

		List<Student> alS = new ArrayList<Student>();
		alS.add(new Student("s - fff"));
		alS.add(new Student("s - eee"));
		alS.add(new Student("s - ccc"));
		printCollection(alS);
	}

	public static void printCollection(List<? extends Person> list) { // 只打印Person以及其子类
		for (ListIterator<? extends Person> li = list.listIterator(); li.hasNext();) {
			XLog.init().debug(li.next().getName());
		}
	}

}

class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class Student extends Person {
	public Student(String name) {
		super(name);
	}
}
