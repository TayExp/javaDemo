package bGeneric;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericHelper {
	public static Class<?> ParameterizedTypeofSuperclass(Class<?> clazz){
		Type type = clazz.getGenericSuperclass();
		if(type instanceof ParameterizedType){
			ParameterizedType pt = (ParameterizedType) type;
			Type[] types = pt.getActualTypeArguments();
			return (Class<?>) types[0];
		}
		return null;
		
	}
	

}
