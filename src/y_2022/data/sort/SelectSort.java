package y_2022.data.sort;

import utils.ArrayUtil;
import utils.XLog;

/*
  	比较次数: N * (N - 1) / 2 约等于 O(N ^ 2)
 	交换次数: O(N)
 	
 	比较后存储下标, 一次for循环之后交换
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] array = { 21, 1, 30, 9, 3, 17 };
		XLog.init().debug(ArrayUtil.print(array));

		selectSort(array);
		XLog.init().debug(ArrayUtil.print(array));
	}

	//
	public static void selectSort(int[] array) {
		for (int out = 0, in = 0; out < array.length - 1; out++) {
			int min = out;
			for (in = out + 1; in < array.length; in++) {
				if (array[in] < array[min]) {
					min = in;
				}
			}
			ArrayUtil.swap(out, min, array);
			XLog.init().debug("out: " + out + "; " + ArrayUtil.print(array));
		}
	}

}
