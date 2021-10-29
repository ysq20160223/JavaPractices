package bh.day_09.t06;

import utils.XLog;

public class Day0906 {

	public static void main(String[] args) {
		int a = 6;
		int b = 0;

		Test test = new Test();

		try {
			int x = test.divide(a, b);
			XLog.init().debug(a + " / " + b + " = " + x);
		} catch (Exception e) {
			XLog.init().debug(e); // java.lang.ArithmeticException
		}

		XLog.init().debug(" ----- Over! -----");
	}

}

class Test {
	public int divide(int a, int b) {
		return a / b;
	}
}

//
