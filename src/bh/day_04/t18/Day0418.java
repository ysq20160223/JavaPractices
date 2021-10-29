package bh.day_04.t18;

import java.util.Scanner;

import utils.XLog;

/*
 * 进制转化
 */

public class Day0418 {

	private static String[] array = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

	public static void main(String[] args) {
		XLog.init().debug("Please input a number : ");

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		String bin = transformToBin(input);
		XLog.init().debug(input + " to bin : " + bin);

		String oct = transformToOct(input);
		XLog.init().debug(input + " to oct : " + oct);

		String hex = transformToHex(input);
		XLog.init().debug(input + " to hex : " + hex);

		sc.close();
	}

	public static String transformToBin(int num) {
		return transform(num, 1, 1);
	}

	public static String transformToOct(int num) {
		return transform(num, 7, 3);
	}

	public static String transformToHex(int num) {
		return transform(num, 15, 4);
	}

	private static String transform(int num, int base, int move) {
		StringBuilder sb = new StringBuilder();

		if (num == 0) {
			return 0 + "";
		}

		while (num != 0) {
			int temp = num & base;
			sb.append(array[temp]);
			num = num >>> move;
		}
		return sb.reverse().toString();
	}

}
