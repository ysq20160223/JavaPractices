package y_2016.t_161022.t_02_des_aes_pbe;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import utils.XLog;

public class AES {

	private static String src = "Secure";

	public static void main(String[] args) throws Exception {
		jdKAES();
	}

	public static void jdKAES() throws Exception {
		// 生成 key
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		byte[] keyBytes = secretKey.getEncoded();

		// 转换 key
		Key key = new SecretKeySpec(keyBytes, "AES");

		// 加密
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] result = cipher.doFinal(src.getBytes());
		XLog.init().debug("jdk AES encrpty : " + Base64.encodeBase64String(result));

		// 解密
		cipher.init(Cipher.DECRYPT_MODE, key);
		result = cipher.doFinal(result);
		XLog.init().debug("jdk AES decrpty : " + new String(result));
	}

}
