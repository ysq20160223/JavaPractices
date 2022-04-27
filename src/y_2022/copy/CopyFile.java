package y_2022.copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

import javax.swing.filechooser.FileSystemView;

import utils.XLog;

public class CopyFile {

	public static void main(String[] args) throws Exception {

		File homeFile = FileSystemView.getFileSystemView().getHomeDirectory();
		XLog.init().debug(homeFile);

		// copyImg(new File(homeFile + "\\Img\\BitCoin.png"), 5000);
		// copyImg(new File(homeFile + "\\Img\\nzha.png"), 5000);
		copyImg(new File(homeFile + "\\Img\\Colorful.png"), 4000);
		// copyImg(new File(homeFile + "\\Img\\Dolphin.png"), 5000);
	}

	public static void copyImg(File srcFile, int count) throws Exception {
		// 判断源文件
		if (!srcFile.exists()) {
			XLog.init().warn("srcFile is null");
			return;
		}
		XLog.init().warn("srcFile: " + srcFile);

		// 判断源文件名
		String srcFileName = srcFile.getName();
		if (null == srcFileName || srcFileName.length() <= 0) {
			XLog.init().warn("srcFileName is null");
			return;
		}
		XLog.init().warn("srcFileName: " + srcFileName);

		// 分割源文件名
		String[] srcFileNameSplit = srcFileName.split("\\.");
		XLog.init().warn(Arrays.deepToString(srcFileNameSplit));
		if (null == srcFileNameSplit || srcFileNameSplit.length < 1) {
			XLog.init().warn("srcFileName is error");
			return;
		}

		String prefix = srcFileNameSplit[0]; // 目标文件名
		String suffix = srcFileNameSplit[1]; // 目标文件后缀

		File destDir = new File(srcFile.getParentFile() + "\\" + prefix);
		if (!destDir.exists()) {
			destDir.mkdirs();
		}
		XLog.init().debug("destDir: " + destDir);

		for (int i = 0; i < count; i++) {
			String destFileName = String.format("%s_%06d.%s", prefix, i, suffix);
			File destFile = new File(destDir + "\\" + destFileName);

			FileInputStream in = new FileInputStream(srcFile);
			FileOutputStream out = new FileOutputStream(destFile);

			BufferedInputStream bis = new BufferedInputStream(in);
			BufferedOutputStream bos = new BufferedOutputStream(out);

			for (int len = 0; (len = bis.read()) != -1;) {
				bos.write(len);
			}

			bos.close();
			bis.close();
			XLog.init().debug("" + destFileName);
		}
	}

}
