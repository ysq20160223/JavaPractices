package y_2016.t_161022.t_05_rsa_dsa_ecdsa;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Hex;

import utils.XLog;

public class RSA {

	private static String src = "Secure";

	public static void main(String[] args) throws Exception {
		jdkRSA();
	}

	// 用java的 jdk 里面相关方法实现 rsa的 签名及签名验证
	public static void jdkRSA() throws Exception {
		// 1.初始化密钥
		KeyPairGenerator keyPairGene = KeyPairGenerator.getInstance("RSA");
		keyPairGene.initialize(512);
		KeyPair keyPair = keyPairGene.generateKeyPair();
		RSAPublicKey rsaPubKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey rsaPriKey = (RSAPrivateKey) keyPair.getPrivate();

		// 2.进行签名
		PKCS8EncodedKeySpec pkcs8EnKeySpec = new PKCS8EncodedKeySpec(rsaPriKey.getEncoded());
		KeyFactory keyFac = KeyFactory.getInstance("RSA");
		PrivateKey priKey = keyFac.generatePrivate(pkcs8EnKeySpec);
		Signature signature = Signature.getInstance("MD5withRSA");
		signature.initSign(priKey);
		signature.update(src.getBytes());
		byte[] result = signature.sign();
		XLog.init().debug("jdk rsa sign : " + Hex.encodeHexString(result));

		// 3.验证签名
		X509EncodedKeySpec x509EnKeySpec = new X509EncodedKeySpec(rsaPubKey.getEncoded());
		keyFac = KeyFactory.getInstance("RSA");
		PublicKey pubKey = keyFac.generatePublic(x509EnKeySpec);
		signature = Signature.getInstance("MD5withRSA");
		signature.initVerify(pubKey);
		signature.update(src.getBytes());
		boolean bool = signature.verify(result);
		XLog.init().debug("jdk rsa verify : " + bool);

	}

}
