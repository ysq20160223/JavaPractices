package y_2021.t_211029;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {

	public static String time() {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss_SSS", Locale.getDefault());
		return format.format(new Date());
	}

}
