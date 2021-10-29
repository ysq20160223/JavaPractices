package bh.day_14.t03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utils.XLog;

/*
 * 遍历集合
 */
public class Day1403 {

	public static void main(String[] args) {
		iterator();
	}

	public static void iterator() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			list.add("java-" + i);
		}

		// Iterator<String> it = list.iterator(); // 产生局部变量
		// while (it.hasNext()) {
		// Print.println(it.next());
		// }

		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			XLog.init().debug(iterator.next());
		}
	}

}
