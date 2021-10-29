package bh.day_02.t15;

import utils.XLog;

/*
 * 交换两数的值
 */
public class Day0215 {

	private static int a = 6, b = 9;

	public static void main(String[] args) {
		XLog.init().debug("Src a: " + a + ", b: " + b);

		methodFirst(a, b);

		methodSecond(a, b);

		methodThird(a, b); // 不建议使用，如果数据过大会出错

		methodFour(a, b);
	}

	private static void methodFour(int a, int b) {
		a = b - a;
		b = b - a; // b -> b - (b - a) -> a
		a = b + a; // a = a + (b - a);
		XLog.init().debug("Four, a: " + a + ", b: " + b);
	}

	private static void methodThird(int a, int b) {
		a = a + b;
		b = a - b; // (a + b) - b
		a = a - b; // (a + b) - [(a + b) - b]
		XLog.init().debug("Third, a: " + a + ", b: " + b);
	}

	private static void methodSecond(int a, int b) {
		a = a ^ b;
		b = a ^ b; // (a ^ b) ^ b = a;
		a = a ^ b; // (a ^ b) ^ a = b;
		XLog.init().debug("Second, a: " + a + ", b: " + b);
	}

	// 通常编程用法
	private static void methodFirst(int a, int b) {
		int temp;
		temp = a;
		a = b;
		b = temp;
		XLog.init().debug("First, a: " + a + ", b: " + b);
	}

}
