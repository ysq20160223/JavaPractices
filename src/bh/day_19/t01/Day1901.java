package bh.day_19.t01;

import java.io.File;
import java.io.FileReader;
import java.util.Date;

import utils.FileUtils;
import utils.XLog;

public class Day1901 {

	public static void main(String[] args) throws Exception {

		File file = new File("Temp/day1901/BufferedWriter.temp.txt");

		FileUtils.bufferedWriter(file.getAbsolutePath(), new Date().toString());

		FileReader reader = new FileReader(file);
		int len = 0;
		char[] buf = new char[1024];
		while ((len = reader.read(buf)) != -1) {
			XLog.init().debug(new String(buf, 0, len));
		}

		reader.close();
	}

}
