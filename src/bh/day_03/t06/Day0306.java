package bh.day_03.t06;

import utils.XLog;

/*
 *  计算正数的累加
 *  
 *  recursion([rɪ'kɜːʃ(ə)n]) : 递归
 */

public class Day0306 {

	public static void main(String[] args) {
		XLog.init().debug("add: " + add(1000));
		XLog.init().debug("recursionAdd: " + recursionAdd(1000));
	}

	private static int add(int n) {

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			// sum = sum + i;
			sum += i;
		}
		return sum;
	}

	// 3 + recursionAdd(3 - 1) => 3 + 2 + recursionAdd(2 - 1) => 3 + 2 + 1
	// 递归思想
	private static int recursionAdd(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("argument < 0");
		} else if (0 == n) {
			return n;
		} else {
			return n + recursionAdd(n - 1);
		}
	}

}
