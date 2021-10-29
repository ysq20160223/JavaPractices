package bh.day_13.t09;

import utils.XLog;

/**
 * 获取两个字符串最大相同的字符串
 * 
 * @author root
 *
 */

public class Day1309 {

	public static void main(String[] args) {
		String s1 = "abcdef";
		String s2 = "acd";

		XLog.init().debug("getMaxSame: " + getMaxSame(s1, s2));
	}

	private static String getMaxSame(String s1, String s2) {

		String min = s1.length() > s2.length() ? s2 : s1;

		for (int x = 0; x < min.length(); x++) {
			XLog.init().debug("x: " + x);
			for (int y = 0, z = min.length() - x; z != min.length() + 1; y++, z++) {
				String temp = min.substring(y, z);
				XLog.init().debug("y: " + y + ", z: " + z + ", temp: " + temp);
				// if (s1.contains(temp)) {
				// return temp;
				// }
			}
		}

		return null;
	}

}
