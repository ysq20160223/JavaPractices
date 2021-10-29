package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.filechooser.FileSystemView;

public class FileUtils {

	public static File getHomeDir() {
		return FileSystemView.getFileSystemView().getHomeDirectory();
	}

	public static void fileWriter(String path, String content) {

		// FileWriter(String fileName)
		// 根据给定的文件名构造一个 FileWriter 对象。

		// FileWriter(String fileName, boolean append)
		// 根据给定的文件名以及指示是否附加写入数据的 boolean 值来构造 FileWriter 对象。

		FileWriter writer = null;
		try {
			File file = new java.io.File(path);
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
			writer = new FileWriter(file, true); // true:可以续写
			writer.write(content);
		} catch (Exception e) {
			XLog.init().debug(e);
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				XLog.init().debug(e);
			}
		}

	}

	public static void fileReaderWriter(String srcPath, String destPath) throws Exception {
		FileReader reader = null;
		FileWriter writer = null;

		reader = new FileReader(srcPath);

		File file = new java.io.File(destPath);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		writer = new FileWriter(file);

		char[] buf = new char[8];
		int len = 0;

		while ((len = reader.read(buf)) != -1) {
			// writer.write(new String(buf, 0, len)); // 将字符数组封装成String也可以
			writer.write(buf, 0, len);
			XLog.init().debug(new String(buf, 0, len));
			Thread.sleep(1000);
		}
		writer.close();
		reader.close();
	}

	// ----------------------------------------------------------------
	public static void bufferedWriter(String path, String content) throws Exception {
		File file = new java.io.File(path);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		writer.write(content);
		writer.newLine();
		writer.flush(); // 刷新该流的缓冲
		writer.close(); // 关闭缓冲区, 就是在关闭在缓冲区中的数据
	}

}
