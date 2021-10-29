package bh.day_15.t08;

import utils.XLog;

/*
 * 泛型类：什么时候定义泛型类？
 * 当类中要操作的引用数据类型不确定的时候
 * 早期定义Object来完成扩展
 * 现在定义泛型类来完成扩展
 */
public class Day1508 {
	public static void main(String[] args) {
		Tool<Person> tool = new Tool<Person>();
		tool.set(new Person());
	}
}

class Worker {
	public Worker() {
		XLog.init().debug("Create Worker Objcet");
	}
}

class Person {
	public Person() {
		XLog.init().debug("Create Person Objcet");
	}
}

class Tool<T> {
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}
}
