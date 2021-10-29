package bh.day_19.t16;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import utils.XLog;

/*
 * 字节流转化为字符流的桥梁：读字节流 InputStreamReader extends Reader 
 * 也相当于在字符流中定义了读取字节流的子类
 */
public class Day1916 {

	public static void main(String[] args) throws Exception {

		// InputStream is = System.in;
		// InputStreamReader isr = new InputStreamReader(is);
		// BufferedReader br = new BufferedReader(isr);

		// 标准读取键盘
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = null;

		while (true) {
			line = br.readLine();
			if ("over".equals(line)) {
				break;
			}
			XLog.init().debug(line.toUpperCase());
		}
	}

}
