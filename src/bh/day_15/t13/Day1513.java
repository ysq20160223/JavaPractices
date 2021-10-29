package bh.day_15.t13;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import utils.XLog;

public class Day1513 {

	public static void main(String[] args) {
		Set<Person> setP = new TreeSet<Person>(new NameComparator());
		setP.add(new Person("P - des"));
		setP.add(new Person("P - exg"));
		setP.add(new Person("P - pne"));
		printCollection(setP);

		XLog.init().debug(null);

		Set<Student> setS = new TreeSet<Student>(new NameComparator());
		setS.add(new Student("S - des"));
		setS.add(new Student("S - exg"));
		setS.add(new Student("S - pne"));
		printCollection(setS);
	}

	public static void printCollection(Set<? extends Person> set) {
		for (Iterator<? extends Person> it = set.iterator(); it.hasNext();) {
			XLog.init().debug(it.next().getName());
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

class NameComparator implements Comparator<Person> {
	@Override
	public int compare(Person p0, Person p1) {
		return p0.getName().compareTo(p1.getName());
	}
}
