package concurrentExecutor;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class HelloTask implements Runnable{
	String name;
	public HelloTask(String name){
		this.name = name;
	}
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Hello, " + name + " ! It is "+ LocalTime.now());
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e){
			}
		}
	}
}

public class Schedule {

	public static void main(String[] args) throws InterruptedException {
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
		executor.scheduleAtFixedRate(new HelloTask("bob"),2, 5, TimeUnit.SECONDS);
		executor.scheduleWithFixedDelay(new HelloTask("Alice"),2, 5, TimeUnit.SECONDS);
		Thread.sleep(10000);
		executor.shutdown();
	}

}

