package bh.day_19.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;

import utils.XLog;
import utils.ThreadUtil;

public class Day1902 {

	private static String name = "Temp/day1902";
	private static File file;
	private static String fileName;

	public static void main(String[] args) throws Exception {

		XLog.init().debug("------------------------------ write start");
		write();
		XLog.init().debug("------------------------------ write end ");

		XLog.init().debug("------------------------------ read start");
		read();
		XLog.init().debug("------------------------------ read end ");
	}

	private static void read() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		BufferedWriter writer = new BufferedWriter(new FileWriter(file + "/copy.temp.txt"));

		String data = null;
		while ((data = reader.readLine()) != null) {
			writer.write(data);
			writer.newLine();
			// 写入一个行分隔符。
			// 行分隔符字符串由系统属性 line.separator 定义，
			// 并且不一定是单个新行 ('\n') 符

			XLog.init().debug(data);

			ThreadUtil.sleep(100, "");
		}
		reader.close();
		writer.close();
	}

	private static void write() throws Exception {
		file = new File(name);
		if (!file.exists()) {
			XLog.init().debug("mkdirs : " + file.mkdirs());
		}

		fileName = file + "/BufferedWriter.temp.txt";

		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

		writer.write(new Date().toString());
		writer.newLine();

		for (int i = 0; i < 3; i++) {
			writer.write("i = " + i);
			writer.newLine();
			writer.flush(); // 刷新该流的缓冲
		}
		writer.close();
	}
}
