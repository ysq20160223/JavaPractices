package bh.day_20.t15;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Date;

import utils.XLog;

/*
 * 读取键盘输入，存储文件并打印控制台
 */
public class Day2015 {

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(new FileOutputStream("Copy.txt", true), true); //
		PrintStream ps = System.out;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String len = null;

		while ((len = br.readLine()) != null) {
			if ("over".equals(len)) {
				pw.println(new Date());
				break;
			}

			XLog.init().debug(len.toUpperCase() + " - "); // 控制台输出
			ps.println(len); // 控制台输出

			pw.println(len.toUpperCase()); // 文件存储

		}

		br.close();
		ps.close();
		pw.close();

	}

}
