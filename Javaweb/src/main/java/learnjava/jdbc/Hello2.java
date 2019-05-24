package learnjava.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hello2 {

	public static void main(String[] args) throws ClassNotFoundException {
		// 插入
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql1="insert into category values(?,?)";
			String sql2 = "update category set cname = ? where cid = ?";
			String sql3="delete from category where cid = ?";
//			插入
			st = conn.prepareStatement(sql1);
			st.setString(1, "c011");
			st.setString(2, "mm");
			//更新
//			st = conn.prepareStatement(sql2);
//			st.setString(1, "手机");
//			st.setString(2, "c006");
			//删除
//			st = conn.prepareStatement(sql3);
//			st.setString(1, "c006");
			int i = st.executeUpdate();
			if(i == 1)
				System.out.println("succed");
			else
				System.out.println("failed");
		} catch (SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtils.closeResource(conn, st, rs);
			
		}
		
		
	}

}
