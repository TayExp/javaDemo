package bGeneric;

import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Main {

	public static void main(String[] args) {
		Pair<String> p = new Pair<>("xiao", "ming");
		IntPair ip = new IntPair(1, 2);
		System.out.println(p instanceof Pair);
		System.out.println(ip instanceof Pair);
		System.out.println(ip instanceof IntPair);
		System.out.println(GenericHelper.ParameterizedTypeofSuperclass(IntPair.class));

	}


}
