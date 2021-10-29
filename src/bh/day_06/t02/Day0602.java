package bh.day_06.t02;

import java.util.Arrays;

import utils.XLog;

/*
 * 验证主函数的参数
 */
public class Day0602 {

	public static void main(String[] args) {
		String[] arr = { "a", "b", "c", "d", "e" };
		Test0602.main(arr);
	}

}

class Test0602 {

	public static void main(String[] args) {
		XLog.init().debug("length: " + Arrays.deepToString(args));
	}

}