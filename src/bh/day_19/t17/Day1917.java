package bh.day_19.t17;

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
 * 1，先将键盘输入的字节流转化为字符流（先读）字节流转字符流
 * 2，再将字符流转化为字节流在控制台输出（后写）字符流转字节流
 * 
 * /---------------------- 读取键盘操作的最常用方法
 * 等待键盘输入，形成字节流   InputStream is = System.in;
 * 将字节流转化为字符流   InputStreamReader isr = new InputStreamReader(is);
 * 缓冲字符流   BufferedReader br = new BufferedReader(isr);
 * 
 * 
 * 输出字节流(这里直接在控制台输出)   OutputStream os = System.out;
 * 将字符流转化为字节流   OutputStreamWriter osw = new OutputStreamWriter(os);
 * 缓冲字符流   BufferedWriter bw = new BufferedWriter(osw);
 */
public class Day1917 {

	private static File file;
	private static String fileName;

	public static void main(String[] args) throws Exception {
		write();
		readWrite();
	}

	private static void write() throws Exception {
		file = new File("Temp/day1917");
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

	private static void readWrite() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(file + "/src_copy.temp.txt")));

		String line = null;

		while ((line = br.readLine()) != null) {
			XLog.init().debug(line.toUpperCase());

			bw.write(line.toUpperCase());
			bw.newLine();
			bw.flush();

			Thread.sleep(500);
		}

		if (br != null)
			br.close();
		if (bw != null)
			bw.close();
	}
}
