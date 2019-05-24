package learnjava.jdbc;
//提取工具类
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

// 工具类
public class JdbcUtils {
	static final String DRIVERCLASS;
	static final String URL;
	static final String USER;
	static final String PASSWORD;
	static{
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		DRIVERCLASS = bundle.getString("driverClass");
		URL = bundle.getString("url");
		USER = bundle.getString("user");
		PASSWORD = bundle.getString("password");
		try{
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException E){
			E.printStackTrace();
		}
 	}
	
	public static Connection getConnection() throws SQLException {
		// 获取链接
		return DriverManager.getConnection(URL, USER, PASSWORD);
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
