package bh.day_17.t06;

import java.util.Arrays;
import java.util.List;

import utils.XLog;

/*
 * 1, 将数组变成集合不可以使用集合的增删方法, 因为数组的长度是固定的
 * 
 * 2, 如果数组中的元素都是对象, 那么变成集合时, 数组中的元素就直接转成集合中的元素,
 * 		如果数组中的元素是基本数据类型,那么会将数组作为集合中的元素存在
 * 
 *  注意: 将数组变成集合, 不可以使用集合的增删方法, 因为数组是固定长度
 */
public class Day1706 {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 7 };
		XLog.init().debug(Arrays.toString(arr));

		XLog.init().debug("-----------------------------");

		String[] strArr = { "a", "cc", "z", "xyz" };
		List<String> list = Arrays.asList(strArr); // 数组转换为集合

		XLog.init().debug("list: " + list);

		// list.add("add"); // java.lang.UnsupportedOperationException
	}
}
