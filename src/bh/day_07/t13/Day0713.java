package bh.day_07.t13;

import utils.XLog;

public class Day0713 {

	public static void main(String[] args) {

		D d = new D();
		d.methodA();
		d.methodB();
		d.methodC();
	}

}

interface A {

	void methodA();

	// public abstract void show(); // 接口 A 和 B 不兼容, 两者都定义了 show(), 返回值类型不同
}

interface B {

	public abstract void methodB();

	// public abstract boolean show(); // 接口 A 和 B 不兼容, 两者都定义了 show(), 返回值类型不同
}

interface C extends A, B {
	public abstract void methodC();
}

class D implements C {

	public void methodA() {
		XLog.init().debug("D methodA");
	}

	public void methodB() {
		XLog.init().debug("D methodB");
	}

	public void methodC() {
		XLog.init().debug("D methodC");
	}

}

//