package bh.day_04.t09;

import utils.ArrayUtil;
import utils.XLog;

/*
 * 获取最值
 */
public class Day0409 {

	public static void main(String[] args) {
		int[] array = new int[] { 0, 9, 1, 8, 2, 7, 3, 6, 4, 5 };
		ArrayUtil.print(array);
		XLog.init().debug("Max: " + ArrayUtil.getMax(array));
		XLog.init().debug("Min: " + ArrayUtil.getMin(array));
	}

}
