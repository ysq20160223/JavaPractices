package bh.day_17.t04;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import utils.XLog;

public class Day1704 {
	public static void main(String[] args) {
		src();

		reverseOrder();
	}

	public static void reverseOrder() {
		Set<String> set = new TreeSet<>(Collections.reverseOrder(new LengthComparator()));
		set.add("e");
		set.add("za");
		set.add("aa");
		set.add("daae");
		set.add("baa");

		XLog.init().debug("reverseOrder set: " + set);
	}

	public static void src() {
		Set<String> set = new TreeSet<>();
		set.add("e");
		set.add("za");
		set.add("aa");
		set.add("daae");
		set.add("baa");

		XLog.init().debug("src set: " + set);
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
