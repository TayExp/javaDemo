package concurrentLock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TaskQueue{
	
	final Queue<String> queue = new LinkedList<>();
	final Lock lock = new ReentrantLock();
	final Condition notEmpty = lock.newCondition();
	
	public String getTask() throws InterruptedException{
		lock.lock();
		try{
			while(this.queue.isEmpty()){
				notEmpty.await();
			}
			return queue.remove();
		} finally {
			lock.unlock();
		}
	}
	
	public void addTask(String name){
		lock.lock();
		try {
			this.queue.add(name);
			notEmpty.signalAll();//唤醒全部等待线程
		} finally{
			lock.unlock();
		}
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

public class Main3 {
	
	
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

