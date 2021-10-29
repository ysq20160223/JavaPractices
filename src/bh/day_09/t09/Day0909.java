package bh.day_09.t09;

import utils.XLog;

/*
 * 自定义异常
 */
public class Day0909 {

	public static void main(String[] args) {
		try {
			int i = new Test().devide(1, 0);
			XLog.init().debug("i: " + i);
		} catch (CustomException e) {
			XLog.init().debug("e: " + e);
		}
	}
}

class CustomException extends Exception {

	private static final long serialVersionUID = 1L;
	private int value;

	public CustomException() {
	}

	public CustomException(String msg, int value) {
		super(msg);
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}

class Test {
	public int devide(int a, int b) throws CustomException {
		if (b <= 0) {
			throw new CustomException("illegal value", b);
		}
		return a / b;
	}
}

//
