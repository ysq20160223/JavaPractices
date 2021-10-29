package bh.day_14.t07;

import java.util.Enumeration;
import java.util.Vector;

import utils.XLog;

/*
 * Vector 中的一个枚举方法 Enumeration
 */
public class Day1407 {

	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>();

		for (int i = 0; i < 3; i++) {
			vector.add("vector-" + i);
		}

		for (Enumeration<String> en = vector.elements(); en.hasMoreElements();) {
			XLog.init().debug("vector: " + en.nextElement());
		}
	}

}
