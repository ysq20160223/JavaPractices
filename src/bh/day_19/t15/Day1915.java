package bh.day_19.t15;

import java.io.InputStream;

import utils.XLog;

/*
 * 读取键盘录入
 */
public class Day1915 {

	public static void main(String[] args) throws Exception {
		InputStream is = System.in;
		StringBuilder sb = new StringBuilder();
		while (true) {
			int ch = is.read();
			if (ch == '\r') {
				continue;
			} else if (ch == '\n') {
				if ("over".equals(sb.toString()))
					break;
				XLog.init().debug(sb.toString().toUpperCase());
				sb.delete(0, sb.length());
			} else {
				sb.append((char) ch);
			}
		}
	}

}
