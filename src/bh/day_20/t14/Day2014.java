package bh.day_20.t14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;

import utils.XLog;

public class Day2014 {

	public static void main(String[] args) throws Exception {
		getCountTime();

		printData();

	}

	public static void printData() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("RunCount.ini"))));
		for (String len; (len = br.readLine()) != null;) {
			XLog.init().debug(len);
		}
		br.close();
	}

	public static void getCountTime() throws Exception {
		File file = new File("RunCount.ini");
		if (!file.exists()) {
			file.createNewFile();
		}
		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		prop.load(fis);

		int runCount = 0;
		String value = prop.getProperty("RunCount");

		if (value != null) {
			runCount = Integer.parseInt(value);
		}
		prop.setProperty("RunCount", ++runCount + "");

		FileOutputStream fos = new FileOutputStream(file, true); //
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);

		prop.store(bw, " ----- ");

		fos.close();
		fis.close();
		br.close();
	}

}
