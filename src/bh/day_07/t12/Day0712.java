package bh.day_07.t12;

import utils.XLog;

public class Day0712 {

	public static void main(String[] args) {
		XLog.init().debug("ImpInterface.NUM : " + ImpInterface.NUM);
		XLog.init().debug("Interface.NUM : " + Interface.NUM);
	}

}

interface Interface {

	public static final int NUM = 21; // 变量都是常量，默认被 public static final 修饰

	public abstract void show(); // 方法默认被 public abstract 修饰

}

class ImpInterface implements Interface {

	public void show() {

	}

}
