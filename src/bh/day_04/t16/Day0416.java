package bh.day_04.t16;

import utils.XLog;

/*
 * 十进制转十六进制
 */
public class Day0416 {

	public static void main(String[] args) {
		String[] array = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

		// Random random = new Random();
		//
		// int r = random.nextInt(100);
		// logger.debug("random : " + r);

		String result = decimalToHex(array, 60);
		XLog.init().debug("result : 0x" + result);
	}

	public static String decimalToHex(String[] array, int arg) {
		StringBuffer sb = new StringBuffer();
		while (arg != 0) {
			int temp = arg & 15;
			sb.append(array[temp]);
			arg = arg >>> 4;
		}
		return sb.reverse().toString();
	}

}
