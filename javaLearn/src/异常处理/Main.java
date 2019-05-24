package 异常处理;

import java.io.UnsupportedEncodingException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test("UTF-8");
		test("ABC");
	}
	static void test(String encoding){
		System.out.print("Test encoding" + encoding + ":   ");
		try{
			System.out.println("test".getBytes(encoding));
			System.out.println("ok");
		}catch (UnsupportedEncodingException e){
			System.out.println("failed");
			System.out.println(e);
		}
	}

}
