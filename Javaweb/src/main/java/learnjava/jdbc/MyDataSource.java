

package learnjava.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

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
		return pool.removeFirst();
	}
	
	// 归还连接
	public static void addBack(Connection conn){
		pool.addLast(conn);
	}
	public static void main(String[] args) {
		
	}
}
