package bh.day_09.t01;

import utils.XLog;

/*
 * 
 * 内部类访问规则:
 * 	内部类可以直接访问外部类中的成员, 包括私有
 *  之所以可以直接访问外部类中的成员, 是因为内部类中持有一个外部类的引用, 格式: 外部类名.this
 * 
 * 1 - 格式:
 * 	外部类名.内部类名   变量名 = 外部类对象.内部类对象;
 * 	Outer.Inner in = new Outer().new Inner();
 *  
 * 2, 当内部类在成员位置上
 * 在外部其他类中, 直接访问static内部类的非静态成员
 * 	new Outer.Inner().function();
 * 
 * 在外部其他类中, 直接访问static内部类的静态成员
 * 	Outer.Inner.function();
 * 
 * 注意: 当内部类定义了静态成员, 该内部类必须是static的
 * 
 * 
 */
public class Day0901 {

	public static void main(String[] args) {

		// 1
		new Outer().outerMethod();
		XLog.init().debug("---\n\n");

		// 2
		Outer.Second os = new Outer().new Second();
		os.fun();
		XLog.init().debug("===\n\n");

		// 3
		// 外部类直接访问 static 修饰的内部类中的 非静态方法
		new Outer.Third().inner();
		XLog.init().debug("+++\n\n");

		// 4
		// 外部类直接访问 static 内部内中的 静态方法
		// 内部类若成员或者变量被静态修饰，则内部类也必须被静态修饰
		Outer.Third.innerStatic();

	}
}

class Outer {

	private int x = 0;

	public void outerMethod() {
		First first = new First(); // 只能在 Outer 类中建立 private 内部类对象
		first.fun();
	}

	// 类只有在另一个类的内部成员位置的时候才可以被 private 修饰
	private class First {

		int x = 1;

		public void fun() {
			int x = 2;
			XLog.init().debug("private 内部类 调用 外部类 中的 成员变量 x: " + Outer.this.x);
			XLog.init().debug("private 内部类 调用 内部类 中的 成员变量 x: " + this.x);
			XLog.init().debug("private 内部类 调用 内部类 中的 局部变量 x: " + x);
		}
	}

	class Second {

		int x = 3;

		// static int xx = 33; // 当内部类中定义了静态成员，该内部类必须是static

		public void fun() {
			int x = 4;
			XLog.init().debug("内部类 调用 外部类 的 成员变量: " + Outer.this.x);
			XLog.init().debug("内部类 调用 内部类 的 成员变量 x: " + this.x);
			XLog.init().debug("内部类 调用 内部类 的 局部变量 x: " + x);
		}
	}

	static class Third {

		int x = 5;

		public void inner() {
			int x = 6;
			XLog.init().debug("static 内部类 非 static 方法调用 内部类 的 成员变量 x: " + this.x);
			XLog.init().debug("static 内部类 非 static 方法调用 内部类 的 局部变量 x: " + x);
		}

		public static void innerStatic() {
			int x = 7;
			XLog.init().debug("static 内部类  static 方法调用 内部类 的 局部变量 x: " + x);
		}
	}
}
