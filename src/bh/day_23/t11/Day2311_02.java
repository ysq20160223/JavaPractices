package bh.day_23.t11;

import java.io.OutputStream;
import java.net.Socket;

public class Day2311_02 {

	public static void main(String[] args) throws Exception {
		// 1
		Socket s = new Socket("localHost", 8888);
		// 2
		OutputStream os = s.getOutputStream();
		// 3
		os.write("Tcp Client Send data to Server".getBytes());
		// 4
		s.close();
	}

}
