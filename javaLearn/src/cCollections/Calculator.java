package cCollections;

import java.util.Arrays;

public class Calculator {
	
	public int calculate(String expression){
		String[] ss = expression.split("\\+");
		System.out.println(expression + " => " + Arrays.toString(ss));
		int sum = 0;
		for (String s : ss){
			sum = sum + Integer.parseInt(s.trim());
		}
		return sum;
	}
	public static void main(String[] args){
		Calculator c = new Calculator();
		int r = c.calculate("1+2+3");
		System.out.println(r);
	}
//	public Object[] compile(String s){
//		Object[] parsed = parseAsExpression(s);
//		List<Object> output = new LinkedList<>();
//		for (Object e : parsed){
//			if (e instanceof Integer){
//				output.add(e);
//			} else{
//				char ch = (Character) e;
//				switch (ch){
//				case ')':
//					
//				}
//			}
//		}
//		return null;
//	}
//
//	private Object[] parseAsExpression(String s) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public int Calculate(Object[] expression){
//		Deque<Integer> stack = new LinkedList<>();
//		return 0;
//		
//	}
}
