package bh.day_16;

import utils.XLog;

public class Student implements Comparable<Student> {

	private String name;
	private int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/* 判断元素是否相同 */
	@Override
	public int hashCode() {
		int hashCode = name.hashCode() + age * 21;
		XLog.init().debug("hashCode: " + hashCode + ", " + this);
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student)) {
			throw new ClassCastException("Class_Cast_Exception");
		}
		Student student = (Student) obj;

		boolean isEqual = name.equals(student.name) && age == student.age;
		XLog.init().debug("isEqual: " + isEqual);

		return isEqual;
	}
	/* 判断元素是否相同 */

	// 在 TreeMap 或 TreeSet 中调用
	@Override
	public int compareTo(Student s) {
		int result = new Integer(age).compareTo(new Integer(s.age));
		if (0 == result) {
			result = name.compareTo(s.name);
		}
		XLog.init().debug("Def compareTo: " + result + ", this: " + this + ", s: " + s);
		return result;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return "[Name: " + name + ", Age: " + age + "]";
	}
}