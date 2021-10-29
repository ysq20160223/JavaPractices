package bh.day_13.t01;

import utils.XLog;

/*
 * String : 一旦被初始化就不可以被改变
 */
public class Day1301 {

	public static void main(String[] args) {
		String s1 = "abc"; // s1是一个类类型变量, "abc"是一个对象
		String s2 = new String("abc");

		// s1 和 s2 有什么区别
		// s1 在内存中有一个对象
		// s2 在内存中有两个对象

		XLog.init().debug("s1 hashCode: " + s1.hashCode());
		XLog.init().debug("s2 hashCode: " + s2.hashCode());

		XLog.init().debug("s1 == s2: " + (s1 == s2));
		XLog.init().debug("s1.equals(s2): " + s1.equals(s2));

	}

}
