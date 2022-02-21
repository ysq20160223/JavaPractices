package y_2022.copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.filechooser.FileSystemView;

import utils.XLog;

public class Copy {

	public static void main(String[] args) throws Exception {

		File homeFile = FileSystemView.getFileSystemView().getHomeDirectory();
		XLog.init().debug(homeFile);

		// copyImg(homeFile + "\\Img\\BitCoin.png", homeFile + "\\Img\\BitCoin",
		// "BitCoin", 5000);
		copyImg(homeFile + "\\Img\\nzha.png", homeFile + "\\Img\\nzha", "nzha", 5000);
	}

	/**
	 * 
	 */
	public static void copyImg(String srcPath, String desPath, String name, int count) throws Exception {
		for (int i = 0; i < count; i++) {
			String num = String.format("\\%s_%06d.png", name, i);

			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcPath));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desPath + num));

			for (int len = 0; (len = bis.read()) != -1;) {
				bos.write(len);
			}

			bos.close();
			bis.close();
			XLog.init().debug("" + num);
		}
	}

}
