package y_2018.t_180712_reflect;

import utils.XLog;

public class Person {

	private String mName;

	private int mAge;

	Person() {

	}

	private Person(int age, String name) {
		mAge = age;
		mName = name;
	}

	protected Person(int age) {
		mAge = age;
	}

	public Person(String name) {
		mName = name;
	}

	private void print(int i, String s) {
		XLog.init().debug(this);
	}

	@Override
	public String toString() {
		return "Person [mName=" + mName + ", mAge=" + mAge + "]";
	}

}
