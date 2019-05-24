package concurrentLock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class WorkerThread4 extends Thread{
	BlockingQueue<String> taskQueue;
	
	public WorkerThread4 (BlockingQueue<String> taskQueue) {
		this.taskQueue = taskQueue;
	}
	
	public void run() {
		while(!isInterrupted()){
			String name;
			try{
				name = taskQueue.take();//是一个blocking方法
			} catch (InterruptedException e){
				break;
			}
			String result = "Hello, " + name + " !";
			System.out.println(result);
		}
	}
}

public class Main4 {
	
	
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> taskQueue = new ArrayBlockingQueue<>(100);
		WorkerThread4 worker = new WorkerThread4(taskQueue);
		worker.start();
		
		taskQueue.put("bob");
		Thread.sleep(1000);
		taskQueue.put("alice");
		Thread.sleep(1000);
		taskQueue.put("tim");
		Thread.sleep(1000);
		worker.interrupt();
		worker.join();
		System.out.println("END");
	}

}

