package zcommonslogging;

public class Person {
	private String name;
	public Person(String name){
		this.name = name;
	}
	public String hello(){
		return "hello, I am " + name;
	}

}
