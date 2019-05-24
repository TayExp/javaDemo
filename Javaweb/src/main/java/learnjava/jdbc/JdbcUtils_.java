package learnjava.jdbc;
//提取工具类
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 工具类
public class JdbcUtils_ {
	// 获取链接
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day0328"
				+ "?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC", "root", "199602");
		return conn;
	}
	// 释放资源
	public static void closeResource(Connection conn, Statement st, ResultSet rs){
		closeResultSet(rs);
		closeStatement(st);
		closeConn(conn);
	}
	private static void closeConn(Connection conn) {
		if(conn != null){
			try{
				conn.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
			conn = null;
		}
		
	}
	private static void closeStatement(Statement st) {
		// 释放语句执行者
		if(st != null){
			try{
				st.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
			st = null;
		}
	}
	private static void closeResultSet(ResultSet rs) {
		// 释放结果集
		if(rs != null){
			try{
				rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
			rs = null;
		}
	}
}
