package bh.day_13.t14;

import utils.XLog;

public class Day1314 {

	public static void main(String[] args) {
		Integer a = new Integer(1);
		Integer b = 1; // 可以赋值为 null

		XLog.init().debug("a==b: " + (a == b));
		XLog.init().debug("a.equals(b): " + a.equals(b));

		b = b + 1; // b.intValue() + 1; 若 b 为null会抛出NullPointerException

		XLog.init().debug("min: " + Byte.MIN_VALUE + ", max: " + Byte.MAX_VALUE);
		// 对于这样直接赋值的 Integer 当值的范围在 [-128, 127] 时不生成新的对象, 直接把缓存中的对象拿来用
		Integer c = 128;
		Integer d = 128;
		XLog.init().debug("c==d: " + (c == d));

		Integer e = 127;
		Integer f = 127;
		XLog.init().debug("e==f: " + (e == f));
		// 当数值为 byte 范围内, 对于新特性, 如果该数值已经存在, 则不会开辟新的空间
	}
}
