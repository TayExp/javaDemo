package javaNet_TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(9090);
		System.out.println("TCP server ready.");
		Socket sock = ss.accept();//返回新建立的客户端连接
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(sock.getInputStream(), StandardCharsets.UTF_8))){
			try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()))){
				String cmd = reader.readLine();
				if ("time".equals(cmd)){
					writer.write(LocalDateTime.now().toString()+"\n");
					writer.flush();
				} else {
					writer.write("Sorry?\n");
					writer.flush();//以流的形式先写入缓存区，满了才发送到网络上，使用flush强制发送
				}
			}
		}
		sock.close();
		ss.close();
	}

}
