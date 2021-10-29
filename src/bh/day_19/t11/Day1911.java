package bh.day_19.t11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import utils.XLog;
import utils.ThreadUtil;

/*
 * 如果用字节流复制，则在文件中可以正常显示，在控制台可能不能正确显示
 * 比较第一和第二种方法的区别
 * 第三种方法计算文件的大小，如果在文件过大（最好不超过1024KB）的情况下则不适用
 */
public class Day1911 {

	private static String name = "Temp/day1911";
	private static File file;
	private static String fileName;

	public static void main(String[] args) throws Exception {

		createFile();

		write();

		fileFirst();
		// fileSecond();
		// fileThird();
	}

	private static void createFile() {
		file = new File(name);
		if (!file.exists()) {
			XLog.init().debug("mkdirs : " + file.mkdirs());
		}
		fileName = file + "/src.temp.txt";
	}

	private static void write() throws Exception {
		FileOutputStream out = new FileOutputStream(fileName, true);
		out.write(("Date : " + new Date() + "\n").getBytes());
		out.flush();
		out.close();
	}

	public static void fileFirst() throws Exception {
		FileInputStream in = new FileInputStream(fileName);
		FileOutputStream out = new FileOutputStream(file + "/first.temp.txt");

		byte[] buf = new byte[1]; // 可以定义缓冲区为 1 和 1024 的区别
		for (int len = 0; (len = in.read(buf)) != -1;) {
			out.write(buf, 0, len);
			XLog.init().debug(new String(buf, 0, len));
			ThreadUtil.sleep(200, "");
		}
		out.close();
		in.close();
	}

	public static void fileSecond() throws Exception {
		FileInputStream in = new FileInputStream(fileName);
		FileOutputStream out = new FileOutputStream(file + "/second.temp.txt");
		for (int len = 0; (len = in.read()) != -1;) {
			out.write((char) len);
			XLog.init().debug((char) len);
			ThreadUtil.sleep(100, "");
		}
		out.close();
		in.close();
	}

	public static void fileThird() throws Exception {
		FileInputStream in = new FileInputStream(fileName);
		FileOutputStream out = new FileOutputStream(file + "/third.temp.txt");
		int available = in.available();
		XLog.init().debug("available: " + available);
		byte[] buf = new byte[available];
		in.read(buf);
		out.write(buf);
		XLog.init().debug(new String(buf));
		out.close();
		in.close();
	}

}
