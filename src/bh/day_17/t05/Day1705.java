package bh.day_17.t05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.XLog;

public class Day1705 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("e");
		list.add("za");
		list.add("aa");
		list.add("daae");
		list.add("baa");

		XLog.init().debug("src list: " + list);

		Collections.shuffle(list); // 使用默认随机源对指定列表进行置换

		XLog.init().debug("After list: " + list);
	}

}
