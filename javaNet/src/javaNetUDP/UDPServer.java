package javaNetUDP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;



public class UDPServer {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		DatagramSocket ds = new DatagramSocket(9090);
		System.out.println("UDP server ready.");
		for(;;){
			// receive:
			byte[] buffer = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			ds.receive(packet);
			byte[] data = packet.getData();
			String s = new String(data, StandardCharsets.UTF_8);
			System.out.println("Packet received from: " + packet.getSocketAddress());
			// send:
			String resp = LocalDateTime.now().toString();
			packet.setData(resp.getBytes(StandardCharsets.UTF_8));
			ds.send(packet);
			
		}
	}

}