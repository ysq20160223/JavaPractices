package y_2016.t_161022.t_05_rsa_dsa_ecdsa;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Hex;

import utils.XLog;

public class DSA {

	private static String src = "Secure";

	public static void main(String[] args) throws Exception {
		jdkDSA();
	}

	public static void jdkDSA() throws Exception {
		// 1.初始化密钥
		KeyPairGenerator keyPairGene = KeyPairGenerator.getInstance("DSA");
		keyPairGene.initialize(512);
		KeyPair keyPair = keyPairGene.generateKeyPair();
		DSAPublicKey dsaPubKey = (DSAPublicKey) keyPair.getPublic();
		DSAPrivateKey dsaPriKey = (DSAPrivateKey) keyPair.getPrivate();

		// 2.进行签名
		PKCS8EncodedKeySpec pkcs8EnKeySpec = new PKCS8EncodedKeySpec(dsaPriKey.getEncoded());
		KeyFactory keyFac = KeyFactory.getInstance("DSA");
		PrivateKey priKey = keyFac.generatePrivate(pkcs8EnKeySpec);
		Signature signature = Signature.getInstance("SHA1withDSA");
		signature.initSign(priKey);
		signature.update(src.getBytes());
		byte[] result = signature.sign();
		XLog.init().debug("jdk dsa sign : " + Hex.encodeHexString(result));

		// 3.验证签名
		X509EncodedKeySpec x509EnKeySpec = new X509EncodedKeySpec(dsaPubKey.getEncoded());
		keyFac = KeyFactory.getInstance("DSA");
		PublicKey pubKey = keyFac.generatePublic(x509EnKeySpec);
		signature = Signature.getInstance("SHA1withDSA");
		signature.initVerify(pubKey);
		signature.update(src.getBytes());
		boolean bool = signature.verify(result);
		XLog.init().debug("jdk dsa verify : " + bool);

	}

}
