package y_2018.t_180415_rename_file;

import java.io.File;

import utils.XLog;

public class RenameFile {

	public static void main(String[] args) {
		String folderPath = "C:/Users/root/Desktop/AesopFables/word/";
		File folder = new File(folderPath);
		if (folder.exists()) {
			File[] files = folder.listFiles();
			if (null != files) {
				for (File f : files) {
					String newName = f.getName().replaceAll(" ", "_");
					XLog.init().debug(f + ", newName: " + newName);
					f.renameTo(new File(folderPath + newName));
				}
			} else {
				XLog.init().warn("files is null");
			}
		} else {
			XLog.init().warn("folder is null");
		}
	}

}
