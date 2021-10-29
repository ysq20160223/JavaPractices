package bh.day_06.t09;

/*
 * 饿汉式单例模式
 */

public class Day0609 {

	// 1
	private Day0609() {
	}

	// 2
	private static Day0609 day0609_01 = new Day0609();

	// 3
	public static Day0609 getInstance() {
		return day0609_01;
	}

}
