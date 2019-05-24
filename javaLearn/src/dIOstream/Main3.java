package dIOstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 writeFile();

	}
	private static void readFile() throws IOException{
		try (InputStream input = new FileInputStream("src/readme.txt")){
			int n;
			while ((n = input.read()) != -1){
				System.out.println(n);
			}
		}
	}
	
	private static void readFileBuffer() throws IOException{
		try (InputStream input = new FileInputStream("src/readme.txt")){
			byte[] buffer = new byte[100];
			int n;
			while ((n = input.read()) != -1){
				System.out.println(n);
			}
		}
	}
	private static void writeFile() throws IOException{
		try (OutputStream output = new FileOutputStream("output.txt")){
			byte[] b1 = "hello".getBytes("UTF-8");
			output.write(b1);
			byte[] b2 = "你好".getBytes("UTF-8");
			output.write(b2);
		}
	}

}
