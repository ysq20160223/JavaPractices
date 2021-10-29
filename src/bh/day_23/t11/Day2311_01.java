package bh.day_23.t11;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Day2311_01 {

	public static void main(String[] args) throws Exception {
		// 1
		ServerSocket ss = new ServerSocket(8888);
		// 2
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println("ip : " + ip);
		// 3
		InputStream is = s.getInputStream();
		// 4
		byte[] buf = new byte[1024];
		int length = is.read(buf);
		System.out.println(new String(buf, 0, length));
		// 5
		s.close();
		ss.close();
	}

}
