package zassertex;

public class Main {

	public static void main(String[] args) {
		double x = -123.45;
		assert x >= 0 : "x must >= 0 but x = " + x;
		System.out.println(x);
		

	}

}
