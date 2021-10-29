package bh.day_08.t05;

import utils.XLog;

/*
 * 多态 (polymorphism : [,pɒlɪ'mɔːfɪz(ə)m])
 * 
 * 注意点: 成员变量不具备多态性.
 * 
 * 通过引用变量来访问其包含的实例变量，系统总是试图访问它编译时类型所定义的成员变量，而不是运行时类型所定义的成员变量
 * 
 * Java的引用变量有两个类型，一个是编译时类型，一个是运行时类型，编译时类型由声明该变量时使用的类型决定，运行时类型由实际赋给该变量的对象决定。
 * 如果编译时类型和运行时类型不一致，会出现所谓的多态。
 * 因为子类其实是一种特殊的父类，因此java允许把一个子类对象直接赋值给一个父类引用变量，无须任何类型转换，或者被称为向上转型，由系统自动完成
 * 
 * 非静态变量 : 不覆盖
 * 非静态方法 : 覆盖
 * 
 * 静态变量: 不覆盖
 * 静态方法: 不覆盖
 * 
 */

public class Day0805 {

	public static void main(String[] args) {

		Animal animal = new Dog();

		XLog.init().debug("name: " + animal.name); // 非静态成员变量不具备多态性
		XLog.init().debug("staticName: " + animal.staticName); // 静态成员变量不具备多态性

		animal.method(); // 非静态成员方法具备多态性
		animal.staticMethod(); // 静态方法不具备多态性

	}

}

abstract class Animal {

	public String name = "little_a";

	public static String staticName = "static_little_a";

	public void method() {
		XLog.init().debug("This is Animal Object method");
	}

	public static void staticMethod() {
		XLog.init().debug("This is Animal static Method");
	}

}

class Dog extends Animal {

	public String name = "little_d";

	public static String staticName = "static_little_d";

	public void method() {
		XLog.init().debug("This is Dog Object method");
	}

	public static void staticMethod() {
		XLog.init().debug("This is Dog static Method");
	}

}
