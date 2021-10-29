package bh.day_07.t11;

import utils.XLog;

/*
 * 1，被final修饰的类不可以被继承
 * 2，被final修饰的方法不可以被覆写
 * 3，被final修饰的变量不可以被二次赋值
 */

public class Day0711 {

	public static void main(String[] args) {
		XLog.init().debug("runtime: " + new ExtendsGetTime().getTime());
	}

}

abstract class GetTime {
	// 若用final修饰 GetTime 类，提示错误: 无法从最终GetTime进行继承
	final public long getTime() {
		long start = System.currentTimeMillis(); // 记录初始时间

		runCode(); // 需要执行的代码

		long end = System.currentTimeMillis(); // 结束时间

		return end - start;
	}

	public abstract void runCode();

}

class ExtendsGetTime extends GetTime {

	public void runCode() {
		for (int i = 0; i < 100000; i++) {
			XLog.init().debug("i: " + i);
		}
	}

	// 提示错误: ExtendsGetTime 中的 getTime() 无法覆盖 GetTime 中的 getTime()
	/*
	 * public long getTime(){
	 * 
	 * }
	 */

}
