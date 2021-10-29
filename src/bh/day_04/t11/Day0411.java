package bh.day_04.t11;

import utils.ArrayUtil;
import utils.XLog;

/*
 * 冒泡排序 - 相邻位置比较
 * 
 */
public class Day0411 {

	public static void main(String[] args) {
		int[] array = new int[] { 0, 9, 1, 8, 2, 7, 3, 6, 4, 5 };
		XLog.init().debug(ArrayUtil.print(array));

		ArrayUtil.bubbleSortMin2Max(array);
		XLog.init().debug(ArrayUtil.print(array));

		ArrayUtil.bubbleSortMax2Min(array);
		XLog.init().debug(ArrayUtil.print(array));
	}

}
