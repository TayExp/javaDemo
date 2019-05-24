//package httpClient;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStreamWriter;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.xml.ws.Response;
//
//import org.omg.CORBA_2_3.portable.OutputStream;
//
//
//class Respense {
//	final int code;
//	final byte[] data;
//	
//	public Respense(int code, byte[] data) {
//		this.code = code;
//		this.data = data;
//	}
//	
//	@Override
//	public String toString(){
//		StringBuilder sb = new StringBuilder(1024);
//		sb.append(code).append("\n");
//		String s = new String(data, StandardCharsets.UTF_8);
//		if (s.length() > 1024) {
//			sb.append(s.substring(0, 1024)).append("\n");
//		} else {
//			sb.append(s);
//		}
//		return sb.toString();
//	}
//}
//
//
//public class HttpClient {
//
//	public static void main(String[] args) {
//		Response resp = get("https://www.douban.com");
//		System.out.println(resp);
//		Map<String,String> postMap = new HashMap<>();
//		postMap.put("form_email", "test");
//		postMap.put("form_password", "password");
//		Response postResp = post("https://www.douban.com/accounts/login", "application/x-www-form-urlencoded",
//				toFormData(postMap));
//		System.out.println(postResp);
//	}
//	
//	static Response get(String theUrl) {
//		System.err.println("GET: " + theUrl);
//		HttpURLConnection conn = null;
//		try {
//			URL url = new URL(theUrl);
//			conn = (HttpURLConnection) url.openConnection();
//			ByteArrayOutputStream responseBuffer = new ByteArrayOutputStream();
//			try (InputStream input = conn.getInputStream()) {
//				byte[] buffer = new byte[1024];
//				for(;;){
//					int n = input.read(buffer);
//					if (n == (-1)) {
//						break;
//					}
//					responseBuffer.write(buffer, 0, n);
//				}
//			}
//			return new Response(conn.getResponseCode(), responseBuffer);
//			
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		} finally {
//			if (conn != null) {
//				conn.disconnect();
//			}
//		}
//		
//	}
//	static Response post(String theUrl, String contentType, String cotentData) {
//		System.err.println("GET: " + theUrl);
//		HttpURLConnection conn = null;
//		try {
//			URL url = new URL(theUrl);
//			conn = (HttpURLConnection) url.openConnection();
//			//
//			conn.setRequestMethod("POST");
//			conn.setDoInput(true);
//			byte[] postData = cotentData.getBytes(StandardCharsets.UTF_8);
//			conn.setRequestProperty("Content-Type", contentType);
//			conn.setRequestProperty("Content-Length", String.valueOf(postData.length));
//			
//			try (OutputStream output = (OutputStream) conn.getOutputStream()) {
//				output.write(postData);
//			}
//			
//			ByteArrayOutputStream responseBuffer = new ByteArrayOutputStream();
//			try (InputStream input = conn.getInputStream()) {
//				byte[] buffer = new byte[1024];
//				for(;;){
//					int n = input.read(buffer);
//					if (n == (-1)) {
//						break;
//					}
//					responseBuffer.write(buffer, 0, n);
//				}
//			}
//			return new Response(conn.getResponseCode(), responseBuffer);
//			
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		} finally {
//			if (conn != null) {
//				conn.disconnect();
//			}
//		}
//		
//	}
//
//}
