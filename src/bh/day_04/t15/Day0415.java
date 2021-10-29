package bh.day_04.t15;

import java.util.Random;

import utils.XLog;

/*
 * 十进制转十六进制
 */
public class Day0415 {

	public static void main(String[] args) {
		Random random = new Random();
		int r = random.nextInt(100);
		XLog.init().debug("random Decimal : " + r);

		String result = decimalToHex(r);
		XLog.init().debug("result Hex : " + result);
	}

	public static String decimalToHex(int arg) {
		StringBuffer sb = new StringBuffer();
		while (arg > 0) {
			int temp = arg % 16;
			if (temp > 9) {
				sb.append((char) (temp - 10 + 'A'));
			} else {
				sb.append(temp);
			}
			arg = arg >> 4;
		}
		return sb.reverse().toString();
	}

}
