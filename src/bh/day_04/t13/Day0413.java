package bh.day_04.t13;

import java.util.Scanner;

import utils.ArrayUtil;
import utils.XLog;

/*
 * 1, 查询从键盘输入的数据是否在数组中
 * 
 * 2, 折半查找
 */
public class Day0413 {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 3, 9, 10, 17, 21, 30 };
		XLog.init().debug(ArrayUtil.print(array));

		//
		XLog.init().debug("Please input a number : ");
		Scanner sc = new Scanner(System.in);

		int key = sc.nextInt();
		int index = ArrayUtil.search(array, key);
		XLog.init().debug(key + " search index : " + index);

		//
		index = ArrayUtil.halfSearch(array, key);
		XLog.init().debug(key + " half Search index : " + index);

		sc.close();

	}

}
