package aReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main3 {

	public static void main(String[] args) throws Exception {
		
		Class cls = Student.class;
		Constructor c = cls.getDeclaredConstructor(String.class,int.class);
		printConstructorInfo(c);
		c.setAccessible(true);
		Student s = (Student) c.newInstance("xioaming",12);
			
		System.out.println(s.hello());
		
	}

	private static void printConstructorInfo(Constructor c) {
		System.out.println(c);
		System.out.println("parameters: " + Arrays.toString(c.getParameterTypes()));
		System.out.println("method modifier? : " + c.getModifiers());

	}

}
