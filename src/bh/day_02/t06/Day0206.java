package bh.day_02.t06;

import utils.XLog;

/*
 * 测试负数的二进制 (对应正数的二进制取反再加+)
 * 
 * 结论 : 负数的最高位为1
 */
public class Day0206 {

	public static void main(String[] args) {

		XLog.init().debug("Integer.toBinaryString(6) : " + Integer.toBinaryString(6));

		// 00000000 00000000 00000000 00000110 // 正6
		// 11111111 11111111 11111111 11111001 // 正6取反
		// 00000000 00000000 00000000 00000001 // 正6+1
		// 11111111 11111111 11111111 11111010 // -6的二进制

		XLog.init().debug("Integer.toBinaryString(-6) : " + Integer.toBinaryString(-6));
	}

}
