package a;

class Mythread extends Thread{
	
	String name;
	
	public Mythread(String name){
		this.name = name;
	}
	
	@Override
	public void run(){
		for (int i = 0; i < 3; i++){
			System.out.println("Hello, " + name + " !");
		}
	}
}
public class Main{
	public static void main(String[] args) throws InterruptedException{
		Thread t = new Mythread("Bob");
		System.out.println("START");
		t.start();
		t.join(); //等待结束
		System.out.println("t END");
		for (int i = 0; i < 3; i++){
			System.out.println("Main!");
		}
	}
}