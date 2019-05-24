

package learnjava.jdbc.datasourcewarp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import learnjava.jdbc.JdbcUtils;

/**
 * 简易的连接池
 * @author miaohj
 *
 */
public class MyDataSource {
	static LinkedList<Connection> pool = new LinkedList<>();
	// 初始化，放入3个连接
		static {
			for(int i = 0; i < 3; i++){
				try{
					Connection conn = JdbcUtils.getConnection();
					pool.add(conn);
				} catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	
		// 从连接池中获得连接
	public static Connection getConnection() throws SQLException{
		if(pool.isEmpty()){
			Connection conn = JdbcUtils.getConnection();
			pool.add(conn);
		}
		ConnectionWarp myConn = new ConnectionWarp(pool.removeFirst(), pool);
		return myConn;
	}
	
	// 归还连接
}
