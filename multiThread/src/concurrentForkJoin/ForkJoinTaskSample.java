package concurrentForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Long>{
	static final int THRESHOLD = 500;
	long[] array;
	int start;
	int end;
	
	SumTask(long[] array, int start, int end){
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		// 如果任务足够小直接计算
		if (end - start <= THRESHOLD){
			long sum = 0;
			for (int i = start; i < end; i++){
				sum += this.array[i];
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
				}
			}
			return sum;
		}
		// 任务太大 一分为二
		int middle = (end- start) /2;
		System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d.", start,end,start,middle,middle,end));
		SumTask subtask1 = new SumTask(this.array, start, middle);
		SumTask subtask2 = new SumTask(this.array, middle, end);
		invokeAll(subtask1,subtask2);
		Long subResult1 = subtask1.join();
		Long subResult2 = subtask2.join();
		Long result = subResult1 + subResult2;
		System.out.println("result = " + subResult1 + " + " + subResult2 + " = " + result);
		return result;
	}
	
}
public class ForkJoinTaskSample {

	public static void main(String[] args) {
		long[] array = new long[1000];
		long expenctedSum = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = (long) (Math.random()*1000);
			expenctedSum += array[i];
		}
		System.out.println("Expected sum: " + expenctedSum);
		//fork join
		ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
		long staryTime = System.currentTimeMillis();
		Long result = ForkJoinPool.commonPool().invoke(task);
		long endtime = System.currentTimeMillis();
		System.out.println("fork join sum: " + result + " in " + (endtime-staryTime));
	}

}
