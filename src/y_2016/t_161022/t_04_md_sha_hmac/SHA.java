package y_2016.t_161022.t_04_md_sha_hmac;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;

import utils.XLog;

public class SHA {

	private static String src = "Secure";

	public static void main(String[] args) throws Exception {
		jdkSHA1();

		bcSHA1();
		bcSHA224();

		ccSHA1();
	}

	private static void jdkSHA1() throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(src.getBytes());
		byte[] sha1 = md.digest();
		XLog.init().debug("jdk SHA1 : " + Hex.encodeHexString(sha1));
	}

	private static void bcSHA1() throws Exception {
		SHA1Digest digest = new SHA1Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] sha1 = new byte[digest.getDigestSize()];
		digest.doFinal(sha1, 0);
		XLog.init().debug("bc SHA1 : " + org.bouncycastle.util.encoders.Hex.toHexString(sha1));
	}

	private static void bcSHA224() throws Exception {
		SHA224Digest digest = new SHA224Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] sha224 = new byte[digest.getDigestSize()];
		digest.doFinal(sha224, 0);
		XLog.init().debug("bc SHA224 : " + org.bouncycastle.util.encoders.Hex.toHexString(sha224));
	}

	private static void ccSHA1() {
		XLog.init().debug("cc SHA1:" + DigestUtils.sha1Hex(src));
	}
}
