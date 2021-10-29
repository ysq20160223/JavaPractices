package bh.day_19.t20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Date;

import utils.XLog;
import utils.ThreadUtil;

/*
 * 
 * InputStream is = System.in;
 * InputStreamReader isr = new InputStreamReader(is);
 * BufferedReader br = new BufferedReader(isr);
 * 
 * OutputStream os = System.out;
 * OutputStreamWriter osw = new OutputWriter(os);
 * BufferedWriter bw = new BufferedWriter(osw);
 * 
 */
public class Day1920 {

	private static File file;
	private static String fileName;

	public static void main(String[] args) throws Exception {

		initFile();

		ReadWrite();

		XLog.init().debug("over");
	}

	private static void initFile() throws Exception {
		file = new File("Temp/day1920");
		if (!file.exists()) {
			file.mkdirs();
		}
		fileName = file.toString() + "/src.temp.txt";

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
		bw.write(new Date().toString());
		bw.newLine();
		bw.flush();
		bw.close();
	}

	private static void ReadWrite() throws Exception {
		System.setIn(new FileInputStream(fileName)); // 设置输入
		System.setOut(new PrintStream(file + "/src_copy.temp.txt")); // 设置输出

		// 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 2
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;
		while ((line = br.readLine()) != null) {
			if ("over".equals(line))
				break;
			bw.write(line);
			bw.newLine();
			XLog.init().debug(line.toUpperCase());

			ThreadUtil.sleep(500, "");
		}

	}

}
