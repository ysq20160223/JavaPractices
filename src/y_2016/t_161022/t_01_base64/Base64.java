package y_2016.t_161022.t_01_base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import utils.XLog;

@SuppressWarnings({})
public class Base64 {

	private static String src = "Secure";

	public static void main(String[] args) throws Exception {
		jdkBase64();
		XLog.init().debug("jdkBase64 over");

		ccBase64();
		XLog.init().debug("ccBase64 over");

		bcBase64();
		XLog.init().debug("bcBase64 over");
	}

	public static void jdkBase64() throws Exception {
		BASE64Encoder enco = new BASE64Encoder();
		String encode = enco.encode(src.getBytes());
		XLog.init().debug("jdk encode : " + encode);

		BASE64Decoder deco = new BASE64Decoder();
		String decode = new String(deco.decodeBuffer(encode));
		XLog.init().debug("jdk decode : " + decode);
	}

	public static void ccBase64() {
		byte[] enco = org.apache.commons.codec.binary.Base64.encodeBase64(src.getBytes());
		XLog.init().debug("cc  encode : " + new String(enco));

		byte[] deco = org.apache.commons.codec.binary.Base64.decodeBase64(enco);
		XLog.init().debug("cc decode : " + new String(deco));
	}

	public static void bcBase64() {
		byte[] enco = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		XLog.init().debug("bc encode : " + new String(enco));

		byte[] dencoder = org.bouncycastle.util.encoders.Base64.decode(enco);
		XLog.init().debug("bc decode : " + new String(dencoder));
	}

}
