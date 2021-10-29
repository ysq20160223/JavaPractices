package bh.day_09.t04;

import utils.XLog;

/*
 * 内部类定义在局部时：
 * 		1，不可以被成员修饰符修
 * 		2，可以直接访问外部类中的成员，因为还持有外部类中引用，
 * 		但是不可以访问它所在的局部中的变量，只能访问被final修饰的局部变量
 * 
 * 匿名内部类：
 * 		1，匿名内部类其实就是内部类的简写格式
 * 		2，定义匿名内部类的前提：内部类必须是继承一个类或者实现接口
 * 		3，匿名内部类的格式：new 父类或者 接口（）{定义子类的内容}；
 * 		4，其实匿名内部类就是一个匿名子类对象，而且这个对象有点胖，可以理解为带内容的对象
 * 		5，匿名内部类中的定义的方法最好不要超过3个
 */
public class Day0904_01 {

	public static void main(String[] args) {

		// 方法1，创建匿名内部类对象（没调用方法）
		new Outer() {
			@Override
			public void outer() {
				XLog.init().debug("This is Anonymity InnerClass Object");
			}
		};

		// 方法2，创建匿名内部类的对象并调用方法
		new Outer() {
			@Override
			public void outer() {
				XLog.init().debug("This is Anonymity InnerClass and call function");
			}
		}.outer();

		// 方法3，引用多态，创建匿名内部类的对象
		Outer outer = new Outer() {
			@Override
			public void outer() {
				XLog.init().debug("Hava name InnerClass");
			}

			// public void inner() {
			// System.out.println("This is inner function");
			// }
		};
		outer.outer();// 对象调用方法，效果和方法2一样
		// outer.inner(); // 编译失败，只能调用父类的函数（多态的局限性）

	}

}

abstract class Outer {
	abstract public void outer();
}
