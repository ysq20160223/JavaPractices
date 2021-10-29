package bh.day_21.t01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.XLog;

public class Day2101 {

	public static void main(String[] args) throws Exception {
		writeListObj();
		readListObj();

		XLog.init().debug("-------------------------");

		writeHashObj();
		readHashObj();

		XLog.init().debug("-------------------------");

		writeTreeObj();
		readTreeObj();

	}

	public static void readListObj() throws Exception {
		FileInputStream fis = new FileInputStream("Person.object");
		ObjectInputStream ois = new ObjectInputStream(fis);
		@SuppressWarnings("unchecked")
		List<Person> list = (ArrayList<Person>) ois.readObject();

		for (Iterator<Person> it = list.iterator(); it.hasNext();) {
			XLog.init().debug("List p : " + it.next());
		}
		ois.close();
		fis.close();
	}

	public static void writeListObj() throws Exception {
		FileOutputStream fos = new FileOutputStream("Person.object");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		List<Person> list = new ArrayList<>();
		list.add(new Person("AAA", 111));
		list.add(new Person("BBB", 222));
		list.add(new Person("BBB", 22));
		list.add(new Person("BBB", 222));

		list = removeDuplication(list);

		oos.writeObject(list);

		oos.close();
		fos.close();
	}

	public static void readHashObj() throws Exception {
		FileInputStream fis = new FileInputStream("Person.object");
		ObjectInputStream ois = new ObjectInputStream(fis);
		@SuppressWarnings("unchecked")
		Set<Person> set = (HashSet<Person>) ois.readObject();

		for (Iterator<Person> it = set.iterator(); it.hasNext();) {
			XLog.init().debug("Hash p : " + it.next());
		}

		ois.close();
		fis.close();
	}

	public static void writeHashObj() throws Exception {
		FileOutputStream fos = new FileOutputStream("Person.object");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Set<Person> set = new HashSet<Person>();
		set.add(new Person("CCC", 333));
		set.add(new Person("DDD", 444));
		set.add(new Person("DDD", 44));
		set.add(new Person("DDD", 444));

		oos.writeObject(set);
		oos.close();
		fos.close();
	}

	public static void readTreeObj() throws Exception {
		FileInputStream fis = new FileInputStream("Person.object");
		ObjectInputStream ois = new ObjectInputStream(fis);
		@SuppressWarnings("unchecked")
		Set<Person> set = (TreeSet<Person>) ois.readObject();

		for (Iterator<Person> it = set.iterator(); it.hasNext();) {
			XLog.init().debug("Tree p : " + it.next());
		}
		ois.close();
		fis.close();
	}

	public static void writeTreeObj() throws Exception {
		FileOutputStream fos = new FileOutputStream("Person.object");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Set<Person> set = new TreeSet<Person>();
		set.add(new Person("EEE", 555));
		set.add(new Person("FFF", 666));
		set.add(new Person("FFF", 66));
		set.add(new Person("FFF", 666));

		oos.writeObject(set);
		oos.close();
		fos.close();
	}

	public static List<Person> removeDuplication(List<Person> list) {
		List<Person> tempList = new ArrayList<Person>();
		for (int i = 0; i < list.size(); i++) {
			if (!tempList.contains(list.get(i))) {
				tempList.add(list.get(i));
			}
		}
		return tempList;
	}

}

class Person implements Serializable, Comparable<Person> { //

	static final long serialVersionUID = 21L;

	private String name;
	private int age;

	public Person() {

	}

	@Override
	public int compareTo(Person p) {
		int num = name.compareTo(p.name);
		if (num == 0) {
			return new Integer(age).compareTo(new Integer(p.age));
		}
		return num;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + age * 21; //
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person))
			throw new RuntimeException(obj + " can not be caset to Person");
		Person p = (Person) obj;
		boolean flag = name.equals(p.name);
		if (flag) {
			return age == p.age;
		}
		return flag;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "Name: " + name + ", Age: " + age;
	}
}
