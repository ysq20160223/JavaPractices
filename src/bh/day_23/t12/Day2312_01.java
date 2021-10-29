package bh.day_23.t12;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Day2312_01 {

	public static void main(String[] args) throws Exception {
		// 1
		ServerSocket ss = new ServerSocket(8888);
		while (true) {
			// 2
			Socket s = ss.accept();
			String ip = s.getInetAddress().getHostAddress();
			System.out.println("IP : " + ip);
			// 3
			InputStream is = s.getInputStream();
			// 4
			byte[] buf = new byte[1024];
			int length = is.read(buf);
			System.out.println(new String(buf, 0, length));

			// --
			Thread.sleep(2000);
			OutputStream os = s.getOutputStream();
			os.write("Hello Client, This is Server!".getBytes());
			// --
			// 5
			s.close();
			ss.close();
		}

	}

}
