package bh.day_02.t08;

import utils.XLog;

/*
 * 0-127 的 char 类型
 * 
 * 类型转换 : 自动类型提升
 * 
 */
public class Day0208 {

	public static void main(String[] args) {

		// byte b = 3;
		// b = b + 1; // cannot convert from int to byte - 编译失败
		// mLogger.debug("b : " + b);

		for (int i = 0; i < 128; i++) {
			XLog.init().debug(i + ": (" + (char) i + ")");
		}

	}
}
