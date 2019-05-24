package learnjava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcSelect {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8";
	static final String JDBC_USER = "root";
	static final String JDBC_PASSWORD = "password";
	
	public static void main(String[] args) throws SQLException {
		List<Student> students = getAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
		for (int i = 1; i<=4; i++) {
			List<Student> list = getStudentOfClass(i);
			System.out.println("Student of class" + i + ": ");
			for (Student student: list) {
				System.out.println(student);
			}
		}
	}

	static List<Student> getStudentOfClass(long theClassId) throws SQLException {
		try (Connection conn = getConnection()) {
			try (PreparedStatement ps = (PreparedStatement) conn.prepareStatement("Select * from students where classId=?;")){
				ps.setObject(1, theClassId);
				try(ResultSet rs = ps.executeQuery()){
					List<Student> list = new ArrayList<>();
					while(rs.next()){
						long id = rs.getLong("id");
						long classId = rs.getLong("class_id");
						String name = rs.getString("name");
						String gender = rs.getString("gender");
						Student std = new Student(id, classId, name, gender);
						list.add(std);

					}
					return list;
				}
			}
		}
		
	}

	static List<Student> getAllStudents() throws SQLException {
		try (Connection conn = getConnection()) {
			try (PreparedStatement ps = (PreparedStatement) conn.prepareStatement("Select * from students where gender=?;")){
				ps.setObject(1, "M");
				try(ResultSet rs = ps.executeQuery()){
					List<Student> list = new ArrayList<>();
					while(rs.next()){
						long id = rs.getLong("id");
						long classId = rs.getLong("class_id");
						String name = rs.getString("name");
						String gender = rs.getString("gender");
						Student std = new Student(id, classId, name, gender);
						list.add(std);
					}
					return list;
				}
			}
		}
		
	}
	static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}
}
