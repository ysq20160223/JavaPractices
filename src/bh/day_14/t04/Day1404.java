package bh.day_14.t04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utils.XLog;

/*
 * 集合的增删改查
 */
public class Day1404 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			list.add("java-" + i); // 1, add
		}
		list.remove(4); // 2, remove

		list.set(2, "java-002"); // 3, set

		for (int i = 0; i < list.size(); i++) { // 4, get
			XLog.init().debug("for list[" + i + "]: " + list.get(i));
		}

		int i = 0;
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			XLog.init().debug("iterator list[" + i++ + "]: " + iterator.next());
		}

	}

}
