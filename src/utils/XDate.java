package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XDate {

	public static String yyMdHmsSSS() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd__HH:mm:ss__SSS");
		Date date = new Date(System.currentTimeMillis());
		return simpleDateFormat.format(date);
	}

}
