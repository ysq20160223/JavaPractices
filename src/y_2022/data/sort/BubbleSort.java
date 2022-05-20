package y_2022.data.sort;

import utils.ArrayUtil;
import utils.XLog;

/*
 	比较次数: N * (N - 1) / 2 约等于 O(N ^ 2)
 	交换次数: N * (N - 1) / 2 约等于 O(N ^ 2)
 	
 	比较后立即交换
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] array = { 21, 1, 30, 9, 3, 17 };
		XLog.init().debug(ArrayUtil.print(array));

		bubbleSort(array);
		XLog.init().debug(ArrayUtil.print(array));
	}

	//
	public static void bubbleSort(int[] array) {
		for (int out = array.length, in = 0; out > 1; out--) {
			for (in = 0; in < out - 1; in++) {
				if (array[in] > array[in + 1]) {
					ArrayUtil.swap(in, in + 1, array);
				}
			}
		}
	}

}
