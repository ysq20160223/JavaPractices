package y_2022.copy;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import utils.XDate;
import utils.XLog;

public class CopyPath {

	public static void main(String[] args) throws Exception {
		File generatedDir = new File("D:\\Test\\");
		if (!generatedDir.exists()) {
			generatedDir.mkdirs();
		}

		List<String> dirList = new ArrayList<>();
		List<String> fileList = new ArrayList<>();
		File rootFile = new File("E:\\");
		File[] files = rootFile.listFiles();
		if (null != files && files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				String fileName = file.getName();
				if (file.isDirectory()) {
					File dir = new File(generatedDir + "\\" + fileName);
					if (!dir.exists()) {
						dir.mkdirs();
					}
					dirList.add("\"" + fileName + "\"");
				} else {
					File f = new File(generatedDir + "\\" + fileName);
					if (!f.exists()) {
						FileOutputStream out = new FileOutputStream(f);
						out.write(XDate.yyMdHmsSSS().getBytes());
						out.flush();
						out.close();
					}
					fileList.add("\"" + fileName + "\"");
				}
				XLog.init().debug(files[i]);
			}
			XLog.init().debug(dirList);
			XLog.init().debug(fileList);
		}
	}

}
