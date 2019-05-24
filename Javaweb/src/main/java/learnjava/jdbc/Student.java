package learnjava.jdbc;

public class Student {
	
	private long id;
	private long classId;
	private String name;
	private String gender;
	public Student(long id, long classId, String name, String gender){
		this.id = id;
		this.classId = classId;
		this.name = name;
		this.gender = gender;
	}
}
