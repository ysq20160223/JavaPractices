package bh.day_17.t01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import utils.XLog;

/*

	Collections
		binarySearch
		sort
		max

 */

public class Day1701 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("e");
		list.add("e");
		list.add("za");
		list.add("baa");

		XLog.init().debug("src list: " + list);

		// ------------

		binarySearch(list, "aa");

		sort(list);

		// sort(list, new LengthComparator());

	}

	public static void binarySearch(List<String> list, String s) {
		int index = Collections.binarySearch(list, s);
		XLog.init().debug("binarySearch index: " + index);
	}

	public static void sort(List<String> list, Comparator<String> comparator) {
		Collections.sort(list, comparator);
		XLog.init().debug("After list: " + list + ", max: " + Collections.max(list, comparator));
	}

	public static void sort(List<String> list) {
		Collections.sort(list);
		XLog.init().debug("After list:" + list + ", max: " + Collections.max(list));
	}

}

class LengthComparator implements Comparator<String> {
	@Override
	public int compare(String s0, String s1) {
		int num = new Integer(s0.length()).compareTo(new Integer(s1.length()));
		if (num == 0)
			return s0.compareTo(s1);
		return num;
	}
}
