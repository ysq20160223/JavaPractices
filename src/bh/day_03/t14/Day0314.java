package bh.day_03.t14;

import utils.XLog;

public class Day0314 {

	public static void main(String[] args) {

		outer: for (int x = 0; x < 5; x++) {
			inner: for (int y = 0; y < 5; y++) {
				if (3 == y) {
					break inner;
				}
				if (3 == x) {
					break outer;
				}
				XLog.init().debug("x: " + x + ", y: " + y);
			}
		}

	}

}
