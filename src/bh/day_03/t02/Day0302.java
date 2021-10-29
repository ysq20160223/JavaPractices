package bh.day_03.t02;

import java.util.Scanner;

import utils.XLog;

/*
 * 测试  if-else 语句
 */
public class Day0302 {

	public static void main(String[] args) {
		XLog.init().debug("Please Input a Number : ");
		Scanner sc = new Scanner(System.in);

		int i = sc.nextInt();
		if (i > 12 || i < 1) {
			XLog.init().debug("Input Error : " + i);
		} else if (2 < i & i < 6) {
			XLog.init().debug("Month " + i + " is Spring!");
		} else if (5 < i & i < 9) {
			XLog.init().debug("Month " + i + " is Summer!");
		} else if (8 < i & i < 12) {
			XLog.init().debug("Month " + i + " is Autumn!");
		} else {
			XLog.init().debug("Month " + i + " is Winter!");
		}
		sc.close();
	}

}
