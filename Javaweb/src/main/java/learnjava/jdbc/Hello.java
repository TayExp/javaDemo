package learnjava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;



public class Hello {
	//@Test
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		// 注册驱动
		DriverManager.registerDriver(new Driver());
		Class.forName("com.mysql.jdbc.Driver");
		// 获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day0328?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC", "root", "199602");
		// crud 
		String sql = "select * from category";
		// 创建预编译的语句执行者
		PreparedStatement st = conn.prepareStatement(sql);
		// 设置参数
		
		// 执行sql
		ResultSet rs = st.executeQuery();
		// 处理结果
		while(rs.next()){
			System.out.println(rs.getString("cid") + "::" + rs.getString("cname"));
		}
		// 释放资源
		rs.close();
		st.close();
	}
}
