package bh.day_14.t12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import utils.XLog;

public class Day1412 {

	public static void main(String[] args) {

		Set<Object> set = new HashSet<Object>();
		XLog.init().debug("add java-0 ? " + set.add("java-0"));
		XLog.init().debug("add java-0 ? " + set.add("java-0"));

		set.add("java-1");
		set.add("java-2");
		set.add("java-3");
		set.add("java-1");

		for (Iterator<Object> it = set.iterator(); it.hasNext();) {
			XLog.init().debug(it.next());
		}
	}

}
