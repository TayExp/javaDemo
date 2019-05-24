package gSecAES;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES_CBC_Cipher {

	static final String CIPHER_NAME = "AES/CBC/PKCS5Padding";

	//加密
	public static byte[] encrypt(byte[] key, byte[] input) throws GeneralSecurityException{
		Cipher cipher = Cipher.getInstance(CIPHER_NAME);
		SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
		//CBC模式需要生成一个16bytes的initialization vector
		SecureRandom sr = SecureRandom.getInstanceStrong();
		byte[] iv = sr.generateSeed(16);
		IvParameterSpec ivps = new IvParameterSpec(iv);
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivps);
		byte[] data = cipher.doFinal(input);
		//IV不需要保密
		byte[] res = new byte[iv.length+data.length];
		System.arraycopy(iv, 0, res, 0, 16);
		System.arraycopy(data, 0, res, 16, data.length);
		return res;
	}
	
	//解密
	public static byte[] decrypt(byte[] key, byte[] input) throws GeneralSecurityException{
		byte[] iv = new byte[16];
		byte[] data = new byte[input.length - 16];
		System.arraycopy(input, 0, iv, 0, 16);
		System.arraycopy(input, 16, data, 0, data.length);
		
		Cipher cipher = Cipher.getInstance(CIPHER_NAME);
		SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
		IvParameterSpec ivps = new IvParameterSpec(iv);
		cipher.init(Cipher.DECRYPT_MODE, keySpec,ivps);
		
		return cipher.doFinal(input);
	}
	public static void main(String[] args) throws UnsupportedEncodingException, GeneralSecurityException {
		String message = "Hello, world! encrypted using AES";
		System.out.println("Message:" + message);
		byte[] key = "1234567890abcdef".getBytes("UTF-8");
		byte[] data = message.getBytes(StandardCharsets.UTF_8);
		byte[] encrypted = encrypt(key, data);
		System.out.println("Encypted data: " + Base64.getEncoder().encodeToString(encrypted));
		byte[] decrypted = decrypt(key, encrypted);
		System.out.println("Decypted data: " + new String(decrypted,"UTF-8"));
		
		
	}


}
