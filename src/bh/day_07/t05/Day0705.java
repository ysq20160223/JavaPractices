package bh.day_07.t05;

import utils.XLog;

public class Day0705 {

	public static void main(String[] args) {
		Middle middle = new Middle();
		middle.show();

		Bottom bottom = new Bottom();
		bottom.show();
	}

}

class Top {
	int a = 0;
	int b = 1;
}

class Middle extends Top {

	int a = 10;

	public void show() {
		XLog.init().debug("a: " + a);
		XLog.init().debug("b: " + b);
	}
}

class Bottom extends Middle {

	int b = 11;

	public void show() {
		XLog.init().debug("a: " + a);
		XLog.init().debug("b: " + b);
	}
}

//
