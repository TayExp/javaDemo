package aReflection;

public class Student extends Person {
	private String address = "Beijing";
	public Student(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public String hello(){
		return ("hello, I am student " + name + ", from " + address);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
