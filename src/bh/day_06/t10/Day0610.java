package bh.day_06.t10;

/*
 * 懒汉式单例模式（延迟加载）
 * 
 * 双重判断, 多线程安全
 */

public class Day0610 {

	// 1
	private Day0610() {
	}

	// 2
	private static Day0610 day0610;

	// 3
	public static Day0610 getInstance() {
		if (null == day0610) {
			synchronized (Day0610.class) {
				if (null == day0610) {
					day0610 = new Day0610();
				}
			}
		}
		return day0610;
	}

}
