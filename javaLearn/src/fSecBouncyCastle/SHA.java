package fSecBouncyCastle;

import java.math.BigInteger;
import java.security.MessageDigest;
public class SHA {
	public static byte[] sha1(byte[] input){
		MessageDigest md;
		try{
			md = MessageDigest.getInstance("SHA-1");
		}catch (Exception e){
			throw new RuntimeException(e);
		}
		md.update(input);
		return md.digest();
	}
	public static void main(String[] aegs) throws Exception{
		String s = "SHA1算法测试";
		byte[] r = sha1(s.getBytes("UTF=8"));
		System.out.println(String.format("%040x", new BigInteger(1,r)));;
	}
}
