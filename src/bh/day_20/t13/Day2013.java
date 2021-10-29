package bh.day_20.t13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;

import utils.XLog;

public class Day2013 {

	public static void main(String[] args) throws Exception {

		// loadProperties(); // 打印 //

		storeProperties(); // 存储并打印

		XLog.init().debug("----------------------------------- Read File");

		// BufferedReader br = new BufferedReader(new InputStreamReader(new
		// FileInputStream(new File("info.txt")))); // 读字节流转字符流
		BufferedReader br = new BufferedReader(new FileReader(new File("info.txt")));
		for (String len; (len = br.readLine()) != null;) {
			XLog.init().debug(len);
		}
		br.close();

	}

	public static void loadProperties() throws Exception { // 打印
		Properties prop = new Properties();
		prop.load(new BufferedReader(new InputStreamReader(new FileInputStream(new File("info.txt"))))); // 读字节流转字符流
		// prop.load(new BufferedReader(new FileReader(new File("info.txt"))));
		prop.list(System.out);
	}

	public static void storeProperties() throws Exception { // 存储并打印
		Properties prop = new Properties();
		for (int i = 0; i < 5; i++) {
			prop.setProperty("n" + i, "v" + i);
		}

		prop.store(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("info.txt"), true))),
				"-----"); // 写字符流转字节流
		// prop.store(new BufferedWriter(new FileWriter(new File("info.txt"),
		// true)));
		prop.list(System.out);
	}

}
