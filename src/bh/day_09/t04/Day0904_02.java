package bh.day_09.t04;

import utils.XLog;

public class Day0904_02 {

	public static void main(String[] args) {
		// 1，Test中有一个静态方法function()
		// 2，方法function() 返回一个接口 Interface 的子类对象
		// 3，Interface子类对象调用方法method()

		Test.function().method();

		// ------------------------
		new Object() {
			public void function() {
				XLog.init().debug("Object -> function");
			}
		}.function();

	}

}

interface Interface {

	public abstract void method();

}

class Test {

	static Interface function() {
		return new Interface() { // 返回 接口 的子类对象
			// @Override
			public void method() {
				XLog.init().debug("Test -> function -> method");
			}
		};
	}

}
