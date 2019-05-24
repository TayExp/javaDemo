package learnjava.jdbc.datasourcewarp;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import learnjava.jdbc.JdbcUtils;

public class C3p0Test {

	public static void main(String[] args) throws Exception {
		ComboPooledDataSource ds = new ComboPooledDataSource("c3p0-config");
		Connection conn = ds.getConnection();
		String sql = "insert into category values(?,?);";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, "c119");
		st.setString(2, "miao");
		int i = st.executeUpdate();
		System.out.println(i);
		JdbcUtils.closeResource(conn, st, null);
	}

}
