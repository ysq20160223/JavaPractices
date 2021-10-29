package bh.day_02.t09;

import utils.XLog;

/*
 * 求余数 (求余数若有负数只看左边)
 */

public class Day0209 {

	public static void main(String[] args) {
		XLog.init().debug("1 % 5 = " + 1 % 5);
		XLog.init().debug("5 % 1 = " + 5 % 1);
		XLog.init().debug("-1 % 5 = " + -1 % 5);
		XLog.init().debug("1 % -5 = " + 1 % -5);
	}

}
