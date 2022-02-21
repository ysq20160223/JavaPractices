package bh.day_19.t12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.filechooser.FileSystemView;

import utils.ThreadUtil;
import utils.XLog;

public class Day1912 {

	private static String src = "color.png";
	private static String path = "Temp\\day1912\\";

	public static void main(String[] args) throws Exception {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}

		file_Reader_Writer(); // 1

		file_Input_Output_Stream(); // 2

		buffered_Input_Output_Stream(); // 3

		char_Byte(); // 4 图片无法正常显示

	}

	/**
	 * 先把字节流转换为字符流，再将字符流转换为字节流，图片无法正常显示
	 */
	private static void char_Byte() throws Exception {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(src)));
		BufferedWriter bufw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(path + "04_abnormal.temp.png")));

		for (String len; (len = bufr.readLine()) != null;) {
			bufw.write(len);
			// bufw.newLine();
			bufw.flush();
		}
		XLog.init().debug("four end");
		bufw.close();
		bufr.close();

	}

	/**
	 * 用带有缓冲的字节流复制图片，效率最高
	 */
	private static void buffered_Input_Output_Stream() throws Exception {

		FileSystemView fsv = FileSystemView.getFileSystemView();
		File com = fsv.getHomeDirectory();

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + "03_normal.temp.png"));

		// byte[] buf = new byte[1024];
		// for (int len = 0; (len = bis.read(buf)) != -1;) {
		// bos.write(buf, 0, len);
		// }

		for (int len = 0; (len = bis.read()) != -1;) {
			bos.write(len);
		}
		XLog.init().debug("third end");

		bos.close();
		bis.close();

	}

	/**
	 * 用字节流复制图片，效率一般
	 */
	private static void file_Input_Output_Stream() throws Exception {
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(path + "02_normal.temp.png");

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = fis.read(buf)) != -1) {
			fos.write(buf, 0, len);

			ThreadUtil.sleep(1);
		}
		XLog.init().debug("second end");
		fos.close();
		fis.close();
	}

	/**
	 * 用字符流复制图片，图片无法正常显示
	 */
	private static void file_Reader_Writer() throws Exception {
		FileReader fr = new FileReader(src);
		FileWriter fw = new FileWriter(path + "01_abnomal.temp.png");

		int len = 0;
		char[] buf = new char[1024];
		while ((len = fr.read(buf)) != -1) {
			fw.write(buf, 0, len);
			fw.flush();
		}
		XLog.init().debug("first end");
		fw.close();
		fr.close();

	}

}
