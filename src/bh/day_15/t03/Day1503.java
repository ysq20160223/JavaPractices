package bh.day_15.t03;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import utils.XLog;

/*
 * TreeSet：可以对Set集合中的元素进行排序
 * 		底层数据是二叉树，保证元素唯一性的依据： compareTo
 * 
 * 第一种排序方式：
 * 	让元素自身具备比较性
 * 	元素需要实现Comparable接口, 覆盖compareTo方法这种方式也称为元素的自然顺序(默认顺序)
 * 
 * 第二种排序方式：
 * 	当元素自身不具备比较性时, 或者具备的比较性不是所需要的, 这时就需要让集合自身具备比较性在集合初始化就具备比较方式
 * 
 * 当两种排序都存在时, 以比较器为主 : 定义一个类, 实现Comparator,覆盖compare方法
 */
public class Day1503 {

	public static void main(String[] args) {

		Set<Object> set = new TreeSet<Object>();

		set.add(new Person("yy", 21));
		set.add(new Person("jj", 1));
		set.add(new Person("hh", 17));
		set.add(new Person("ll", 3));

		for (Iterator<Object> iterator = set.iterator(); iterator.hasNext();) {
			XLog.init().debug(iterator.next());
		}
	}

}

class Person implements Comparable<Object> {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Object obj) {
		return 1; // 按创建的顺序排列
		// return 0; //只能有一个，人为设置全部都一样
		// return -1; //按创建的倒序排列
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
