package gSecAES;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES_ECB_Cipher {
	
	static final String CIPHER_NAME = "AES/ECB/PKCS5Padding";

	//加密
	public static byte[] encrypt(byte[] key, byte[] input) throws GeneralSecurityException{
		Cipher cipher = Cipher.getInstance(CIPHER_NAME);
		SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
		cipher.init(Cipher.ENCRYPT_MODE, keySpec);
		return cipher.doFinal(input);
	}
	
	//解密
	public static byte[] decrypt(byte[] key, byte[] input) throws GeneralSecurityException{
		Cipher cipher = Cipher.getInstance(CIPHER_NAME);
		SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
		cipher.init(Cipher.DECRYPT_MODE, keySpec);
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
