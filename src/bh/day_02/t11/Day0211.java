package bh.day_02.t11;

import utils.XLog;

/*
 * 转型
 * 
 * char 类型可以存储一个汉字
 */
public class Day0211 {

	public static void main(String[] args) {

		short s = 1;
		// s = s + 1; // 编译失败 （s+1后转为 int 型）
		// s += 1; // 编译通过, 自动转换, 只赋值
		XLog.init().debug("(short s = 1; s += 1) = " + (s += 1));

		char c = '中';
		XLog.init().debug("c : " + c);

	}

}
