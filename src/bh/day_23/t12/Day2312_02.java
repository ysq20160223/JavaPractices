package bh.day_23.t12;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Day2312_02 {

	public static void main(String[] args) throws Exception {
		// 1
		Socket s = new Socket("localHost", 8888);
		// 2
		OutputStream os = s.getOutputStream();
		// 3
		os.write("Hello Server, This is Client!".getBytes());
		// --
		InputStream is = s.getInputStream();
		byte[] buf = new byte[1024];
		int length = is.read(buf);
		System.out.println(new String(buf, 0, length));
		// --
		// 4
		os.close();
		s.close();
	}

}
