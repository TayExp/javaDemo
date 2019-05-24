package dreadLock;

class SharedObject{
	final Object lockA = new Object();
	final Object lockB = new Object();
	
 	int accountA = 1000;
 	int accountB = 2000;
 	
 	public void a2b (int balance){
 		synchronized (lockA){
 			accountA -= balance;
 			synchronized (lockB){
 				accountB += balance;
 			}
 		}
 	}
 	public void b2a (int balance){
 		synchronized (lockB){
 			accountA -= balance;
 			synchronized (lockA){
 				accountB += balance;
 			}
 		}
 	}
}

class Athread extends Thread{
	public void run(){
		for (int i = 0; i <Main.LOOP; i++){
			Main.shared.a2b(1);
			if (i % 100 == 0){
				System.out.println(".");
			}
		}
	}
}
class Bthread extends Thread{
	public void run(){
		for (int i = 0; i <Main.LOOP; i++){
			Main.shared.b2a(1);
			if (i % 100 == 0){
				System.out.println(".");
			}
		}
	}
}

public class Main {

	final static int LOOP = 10000;
	public static SharedObject shared = new SharedObject();

	public static void main(String[] args) throws Exception {
		Thread t1 = new Athread();
		Thread t2 = new Bthread();
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("END");
	}

}
