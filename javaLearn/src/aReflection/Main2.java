package aReflection;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main2 {

	public static void main(String[] args) throws Exception {
		Student s = new Student();
		Class cls = s.getClass();
		Method m = cls.getMethod("setAddress", String.class);
		printMethodInfo(m);
		m.invoke(s, "shanghai");
		System.out.println(s.hello());
		BeanInfo bi = Introspector.getBeanInfo(cls);
		for (PropertyDescriptor pb : bi.getPropertyDescriptors()){
			System.out.println(pb.getName());
			System.out.println(pb.getReadMethod());
			System.out.println(pb.getWriteMethod());
		}
		
	}

	private static void printMethodInfo(Method m) {
		System.out.println(m);
		System.out.println("method name: " + m.getName());
		System.out.println("return type: " + m.getReturnType());
		System.out.println("parameters: " + Arrays.toString(m.getParameterTypes()));
		System.out.println("method modifier? : " + m.getModifiers());
		
	}

}
