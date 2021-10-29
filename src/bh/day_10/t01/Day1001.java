package bh.day_10.t01;

import utils.XLog;

public class Day1001 {

	public static void main(String[] args) {
		try {
			XLog.init().debug("result: " + div(2, 0));
		} catch (Exception e) {
			XLog.init().debug(e.toString());
			return;
		} finally {
			XLog.init().debug("finally");
		}
		XLog.init().debug("over");
	}

	public static int div(int a, int b) {
		return a / b;
	}

}
