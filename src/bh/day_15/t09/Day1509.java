package bh.day_15.t09;

import utils.XLog;

/*
 * 特殊之处：
 * 		静态方法不可以访问类上定义的泛型
 * 		如果静态方法操作的应用数据类型不确定，可以将泛型定义在方法上
 */
public class Day1509 {
	public static void main(String[] args) {
		Generic<String> g = new Generic<String>();
		g.show("hh");
		// g.show(17);// 编译失败
		g.print("yy");
		g.print(21);

		Generic.method("static");
	}
}

class Generic<T> {
	public void show(T t) {
		XLog.init().debug("show: " + t);
	}

	public <E> void print(E e) {
		XLog.init().debug("print: " + e);
	}

	//
	public static <F> void method(F f) {
		XLog.init().debug("static method: " + f);
	}
}
