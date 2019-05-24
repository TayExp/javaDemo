package learnjava.jdbc.datasourcewarp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import learnjava.jdbc.JdbcUtils;

public class C3p0Test2 {

	public static void main(String[] args) throws Exception {
		try {
			//user = new UserService().login(username, password);
			ComboPooledDataSource ds = new ComboPooledDataSource("c3p0-config");
			Connection conn = ds.getConnection();
			String sql = "select * from user where username=? and password=?;";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "tom");
			st.setString(2, "123");
			ResultSet rs = st.executeQuery();
			if(!rs.next()) {
				System.out.println("用户名或密码错误。");
			}else {
				//不为空
				System.out.println("欢迎回来。");
			}
			JdbcUtils.closeResource(conn, st, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
