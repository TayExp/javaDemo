package learnjava.jdbc;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import learnjava.jdbc.datasourcewarp.DataSourceUtils;

public class DbUtilsTest {
	public static void insert() throws SQLException{
		// 1. 创建queryrunner类
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		// 2. 编写sql
		String sql = "insert into category values(?,?)";
		// 3. 执行sql
		qr.update(sql,"c201","厨电");
	}
	public static void update() throws SQLException{
		// 1. 创建queryrunner类
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		// 2. 编写sql
		String sql = "update category set cid = ? where cname = ?";
		// 3. 执行sql
		System.out.println(qr.update(sql,"c000","厨电"));	
	}
	public static void main(String[] args) throws SQLException {
//		insert();
		update();

	}

}
