package bh.day_02.t12;
/*

	单与(位与) & : 两边都会运算

	双与 && : 若是左边为false, 右边不运算

*/

import utils.XLog;

public class Day0212 {

	public static void main(String[] args) {

		XLog.init().debug("1 & 3 = " + (1 & 3));
		XLog.init().debug("1 | 3 = " + (1 | 3));

	}

}
