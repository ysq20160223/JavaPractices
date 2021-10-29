package bh.day_03.t12;

import utils.XLog;

/*
 * For For 循环嵌套
 */
public class Day0312 {

	public static void main(String[] args) {

		method_First();

		method_Second();

		method_Third();

		method_Four();

		method_Five();

		method_Six();

		method_Seven();
	}

	public static void method_First() {
		XLog.init().debug("---------------First");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void method_Second() {
		XLog.init().debug("---------------Second");
		for (int i = 0; i < 5; i++) {
			for (int j = i; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void method_Third() {
		XLog.init().debug("---------------Third");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void method_Four() {
		XLog.init().debug("---------------Four");
		for (int i = 0; i < 5; i++) {
			for (int k = 0; k < i; k++) {
				System.out.print(" ");
			}
			for (int j = i; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void method_Five() {
		XLog.init().debug("---------------Five");
		for (int i = 0; i < 5; i++) {
			for (int k = i; k < 5 - 1; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void method_Six() {
		XLog.init().debug("---------------Six");
		for (int i = 0; i < 5; i++) {
			for (int k = i; k < 5 - 1; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			for (int m = 0; m < i; m++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void method_Seven() {
		XLog.init().debug("---------------Seven");
		for (int i = 0; i < 5; i++) {
			for (int k = 0; k < i; k++) {
				System.out.print(" ");
			}
			for (int j = i; j < 5; j++) {
				System.out.print("*");
			}
			for (int m = i + 1; m < 5; m++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
