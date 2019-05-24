package concurrentExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class PrintTask implements Runnable{
	String name;
	public PrintTask(String name){
		this.name = name;
	}
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Hello, " + name + " !");
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e){
			}
		}
	}
}

public class ThreadPool {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executor = Executors.newCachedThreadPool();
//		ExecutorService executor = new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue<>());
		executor.submit(new PrintTask("bob"));
		executor.submit(new PrintTask("Alice"));
		executor.submit(new PrintTask("tim"));
		executor.submit(new PrintTask("robot"));
		executor.submit(new PrintTask("jack"));
		Thread.sleep(10000);
		executor.shutdown();
	}

}
