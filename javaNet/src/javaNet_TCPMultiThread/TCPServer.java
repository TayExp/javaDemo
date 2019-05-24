package javaNet_TCPMultiThread;

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
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(9090);
		System.out.println("TCP server ready.");
		for(;;){
			Socket sock = ss.accept();
			System.out.println("Accept from " + sock.getRemoteSocketAddress());
			TimeHandeler handler = new TimeHandeler(sock);
			handler.start();//处理这个连接
			
		}
	}

}

class TimeHandeler extends Thread {
	Socket sock;
	
	public TimeHandeler(Socket sock) {
		this.sock = sock;
	}
	
	@Override
	public void run(){
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(sock.getInputStream(), StandardCharsets.UTF_8))){
			try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()))){
				for(;;) {
					String cmd = reader.readLine();
					if ("q".equals(cmd)){
						writer.write("bye!\n");
						writer.flush();
						break;
					} else if("time".equals(cmd)) {
						writer.write(LocalDateTime.now().toString() + "\n");
						writer.flush();
					} else {
						writer.write("Sorry?\n");
						writer.flush();
					}
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				this.sock.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
}