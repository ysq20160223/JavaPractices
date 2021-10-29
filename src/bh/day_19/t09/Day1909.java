package bh.day_19.t09;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.util.Date;

import utils.XLog;

public class Day1909 {

	private static String name = "Temp/day1909";
	private static File file;
	private static String fileName;

	public static void main(String[] args) throws Exception {
		write();
		read();
	}

	private static void read() throws Exception {
		LineNumberReader reader = new LineNumberReader(new FileReader(fileName));
		BufferedWriter writer = new BufferedWriter(new FileWriter(file + "/copy.temp.txt"));
		String len = null;
		while ((len = reader.readLine()) != null) {
			writer.write(reader.getLineNumber() + " " + len);
			writer.newLine();
			XLog.init().debug(reader.getLineNumber() + " " + len);
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

		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

		writer.write(new Date().toString());
		writer.newLine();

		for (int i = 0; i < 3; i++) {
			writer.write("i = " + i);
			writer.newLine();
			writer.flush();// 刷新该流的缓冲
		}
		writer.close();
	}
}
