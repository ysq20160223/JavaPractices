package bh.day_23.t04;

import java.net.InetAddress;

import utils.XLog;

public class Day2304 {

	public static void main(String[] args) throws Exception {

		InetAddress[] ia = InetAddress.getAllByName("www.baidu.com");
		int length = ia.length;
		for (int i = 0; i < length; i++) {
			XLog.init().debug("HostAddress: " + ia[i].getHostAddress());
			// System.out.println("HostName : " + ia[i].getHostName() );
			// System.out.println("CanonicalHostName : " +
			// ia[i].getCanonicalHostName() );
		}

	}

}
