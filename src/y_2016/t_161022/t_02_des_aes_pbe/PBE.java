package y_2016.t_161022.t_02_des_aes_pbe;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;

import utils.XLog;

public class PBE {

	private static String src = "Secure";

	public static void main(String[] args) throws Exception {
		jdkPBE();
	}

	public static void jdkPBE() throws Exception {
		// 初始化
		SecureRandom secureRandom = new SecureRandom();
		byte[] seed = secureRandom.generateSeed(8);

		// 口令与秘钥
		String password = "pwd";
		PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");
		Key key = factory.generateSecret(pbeKeySpec);

		// 加密
		PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(seed, 100);
		Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
		cipher.init(Cipher.ENCRYPT_MODE, key, pbeParameterSpec);
		byte[] result = cipher.doFinal(src.getBytes());
		XLog.init().debug("jdk pbe encrypt : " + Base64.encodeBase64String(result));

		// 解密
		cipher.init(Cipher.DECRYPT_MODE, key, pbeParameterSpec);
		result = cipher.doFinal(result);
		XLog.init().debug("jdk pbe decrypt : " + new String(result));
	}
}
