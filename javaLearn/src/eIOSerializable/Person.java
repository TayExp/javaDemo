package eIOSerializable;

import java.io.Serializable;

public class Person implements Serializable{
	private final String name;
	public Person(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}

	
}
