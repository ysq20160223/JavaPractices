package bh.day_04.t10;

import utils.ArrayUtil;
import utils.XLog;

/*
 * 选择排序 - 选择固定一位和其他位比较
 * 
 * 1, 选择第一个元素和后面所有的元素比较,将最小值放在第一位
 * 2, 选择第二个元素和后面的所有元素比较,将除了比第一位数大,比所有数小的元素放在第二位
 * 3, 以此类推
 */
public class Day0410 {

	public static void main(String[] args) {

		int[] array = new int[] { 0, 9, 1, 8, 2, 7, 3, 6, 4, 5 };
		ArrayUtil.print(array);

		ArrayUtil.selectSortMin2Max(array);
		XLog.init().debug(ArrayUtil.print(array));

		ArrayUtil.selectSortMax2Min(array);
		XLog.init().debug(ArrayUtil.print(array));
	}

}
