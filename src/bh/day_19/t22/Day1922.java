package bh.day_19.t22;

import java.io.File;
import java.io.PrintStream;
import java.util.Properties;

public class Day1922 {

	public static void main(String[] args) throws Exception {
		Properties p = System.getProperties();

		p.list(System.out); // 输出到控制台

		File file = new File("Temp/day1922");
		if (!file.exists()) {
			file.mkdirs();
		}

		p.list(new PrintStream(file + "/Print_Properties.temp.txt")); // 输出到文件

	}

}
