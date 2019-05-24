package threadWait;

import java.util.LinkedList;
import java.util.Queue;

class TaskQueue{
	
	final Queue<String> queue = new LinkedList<>();
	
	public synchronized String getTask() throws InterruptedException{
		while(this.queue.isEmpty()){
			this.wait();
		}//通常在while中wait
		return queue.remove();
	}
	
	public synchronized void addTask(String name){
		this.queue.add(name);
		this.notifyAll();//唤醒全部等待线程
	}
}

class WorkerThread extends Thread{
	TaskQueue taskQueue;
	public WorkerThread(TaskQueue taskqueue){
		this.taskQueue = taskqueue;
	}
	
	public void run() {
		while(!isInterrupted()){
			String name;
			try{
				name = taskQueue.getTask();
			} catch (InterruptedException e){
				break;
			}
			String result = "Hello, " + name + " !";
			System.out.println(result);
		}
	}
}

public class Main {
	
	
	public static void main(String[] args) throws InterruptedException {
		TaskQueue taskQueue = new TaskQueue();
		WorkerThread worker = new WorkerThread(taskQueue);
		worker.start();
		
		taskQueue.addTask("bob");
		Thread.sleep(1000);
		taskQueue.addTask("alice");
		Thread.sleep(1000);
		taskQueue.addTask("tim");
		Thread.sleep(1000);
		worker.interrupt();
		worker.join();
		System.out.println("END");
	}

}
