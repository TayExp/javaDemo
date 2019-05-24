package learnjava.jdbc.datasourcewarp;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDs {

	public static void main(String[] args) throws SQLException {
		MyDataSource ds = new MyDataSource();
		Connection conn = ds.getConnection();
		conn.close();

	}

}
