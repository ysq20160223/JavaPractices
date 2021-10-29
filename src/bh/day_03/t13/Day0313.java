package bh.day_03.t13;

import utils.XLog;

/*
 *  打印99乘法表
 */

public class Day0313 {

	public static void main(String[] args) {
		mul(1, 9);

		XLog.init().debug("---------------------------------");

		mul(11, 19);
	}

	private static void mul(int start, int end) {
		for (int i = start; i <= end; i++) {
			for (int j = start; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
	}

}
