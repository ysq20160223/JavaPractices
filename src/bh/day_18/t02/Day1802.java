package bh.day_18.t02;

import utils.ThreadUtil;

/*
 * 
 */
public class Day1802 {

	public static void main(String[] args) throws Exception {
		Runtime runtime = Runtime.getRuntime();

		Process process = runtime.exec("D:/Program Files (x86)/KuGou/KGMusic/KuGou.exe");

		ThreadUtil.sleep(3000, null);

		process.destroy(); // 只能终止本程序开启的程序

	}

}
