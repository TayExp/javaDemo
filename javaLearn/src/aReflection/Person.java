package aReflection;

public class Person {
	@NotNull
	public String name;
	
	@NotNull
	@Range
	protected int age;
	
	public Person(){
		this.name = "unnamed";
		this.age = -1;
	}
	public Person(String name){
		this.name = name;
		this.age = -1;
	}
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	} 
	
	public String hello(){
		return "hello, I am " + name;
	}
	
	
	
}
