package cCollections;

import java.util.Objects;

public class Person implements Comparable<Person> {
	public String name;
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
	
	@Override
	public boolean equals(Object obj){
		if (obj == this){
			return true;
		}
		if (obj instanceof Person){
			Person p = (Person) obj;
			return Objects.equals(this.name, p.name) && this.age == p.age;
		}
		return false;
	}
	
	public int hashCode(){
		return Objects.hash(this.name, this.age);
	}
	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
	}
}
