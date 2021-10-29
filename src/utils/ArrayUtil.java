package utils;

public class ArrayUtil {

	/**
	 * 折半查找 key 在数组中的下标
	 */
	public static int halfSearch(int[] array, int key) {
		int min = 0;
		int max = array.length;
		int mid = (min + max) / 2;

		while (array[mid] != key) {
			if (key > array[mid]) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
			mid = (min + max) / 2;

			if (max < min)
				return -1;
		}
		return mid;
	}

	/**
	 * 查找 key 在数组中的下标
	 */
	public static int search(int[] array, int key) {
		for (int index = 0; index < array.length; index++) {
			if (array[index] == key) {
				return index;
			}
		}
		return -1;
	}

	/**
	 * 冒泡排序 - 从小到大
	 */
	public static void bubbleSortMin2Max(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 冒泡排序 - 从大到小
	 */
	public static void bubbleSortMax2Min(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] < array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 选择排序 - 从小到大
	 */
	public static void selectSortMin2Max(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					changeValue(i, j, array);
				}
			}
		}
	}

	/**
	 * 选择排序 - 从大到小
	 */
	public static void selectSortMax2Min(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					changeValue(i, j, array);
				}
			}
		}
	}

	/**
	 * 交换数组的值
	 */
	public static void changeValue(int a, int b, int array[]) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	/**
	 * 获取数组最小值
	 */
	public static int getMin(int[] array) {
		int min = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[min] > array[i]) {
				array[min] = array[i];
			}
		}
		return array[min];
	}

	/**
	 * 获取数组最大值
	 */
	public static int getMax(int[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}

	/**
	 * 遍历打印数组
	 */
	public static String print(int[] array) {
		StringBuilder sb = new StringBuilder();
		sb.append("array[").append(array.length).append("] = [");
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				sb.append(array[i]).append(", ");
			} else {
				sb.append(array[i]).append("]");
			}
		}
		return sb.toString();
	}

}
