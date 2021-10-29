package bh.day_17.t03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.XLog;

public class Day1703 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("e");
		list.add("za");
		list.add("aa");
		list.add("daae");
		list.add("baa");

		XLog.init().debug("src list:" + list);

		Collections.replaceAll(list, "aa", "yy");

		XLog.init().debug("After list:" + list);
	}

}
