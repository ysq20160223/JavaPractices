package bh.day_04.t14;

import java.util.Random;

import utils.XLog;

/*
 * 十进制转二进制 (/2%2)
 */
public class Day0414 {

	public static void main(String[] args) {
		Random random = new Random();
		int ran = random.nextInt(10);
		XLog.init().debug("random : " + ran);

		String result = decimalToBinary(ran);
		XLog.init().debug("result : " + result);
	}

	private static String decimalToBinary(int arg) {
		StringBuffer sb = new StringBuffer();
		while (arg > 0) {
			sb.append(arg % 2);
			arg = arg >> 1;
		}
		return sb.reverse().toString();
	}

}
