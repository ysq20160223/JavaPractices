package y_2022.data.sort;

import utils.ArrayUtil;
import utils.XLog;

/*
 	场景: 针对部分有序
 	
 	
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] array = { 21, 1, 30, 9, 3, 17 };
		XLog.init().debug(ArrayUtil.print(array));

		insertSort(array);
		XLog.init().debug(ArrayUtil.print(array));
	}

	//
	public static void insertSort(int[] array) {
		for (int out = 1, in = 0; out < array.length; out++) {
			int temp = array[out];
			in = out;
			while (in > 0 && array[in - 1] > temp) {
				array[in] = array[in - 1];
				in--;
			}
			array[in] = temp;
		}
	}

}
