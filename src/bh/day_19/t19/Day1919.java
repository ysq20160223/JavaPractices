package bh.day_19.t19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;

import utils.XLog;

/*
 * 转化流:
 */
public class Day1919 {

	private static File file = new File("Temp/day1919");
	private static String fileName = file + "/src.temp.txt";

	private static String writeCharset = "GBK"; // GBK UTF-8
	private static String readCharset = "GBK";

	public static void main(String[] args) throws Exception {
		writer();

		reader();
	}

	public static void reader() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), readCharset));

		char[] buf = new char[1024];
		for (int len = 0; (len = reader.read(buf)) != -1;) {
			XLog.init().debug(new String(buf, 0, len));
		}

		reader.close();
	}

	public static void writer() throws Exception {
		if (!file.exists()) {
			file.mkdirs();
		}

		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(fileName, false), writeCharset));

		writer.write(new Date().toString());
		writer.newLine();
		writer.write("中国");
		writer.newLine();

		writer.flush();
		writer.close();
	}
}
