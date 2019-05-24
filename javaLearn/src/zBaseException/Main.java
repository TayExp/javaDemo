package zBaseException;

public class Main {
	public static void main(String[] args){
		try{
			process1();
		} catch (BaseException e){
			//
		} catch (Exception e){
			//
		}
	}
	static void process1(){
		throw new IllegalArgumentException();
	}

}
