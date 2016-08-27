package chapter7.concurrency.management;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

@SuppressWarnings("all")
public class WeighAnimalTask extends RecursiveTask<Double> {
	
	private int start;
	private int end;
	private Double[] weights;
	
	public WeighAnimalTask(Double[] weights, int start, int end) {
		super();
		this.start = start;
		this.end = end;
		this.weights = weights;
	}

	@Override
	protected Double compute() {
		
		if(end-start <= 3) {
			double sum = 0;
			//Base Case
			for(int i = start; i < end; i++) {
				weights[i] = (double) new Random().nextInt(100);
				System.out.println("Animal Weighed: " + i);
				
				sum += weights[i];
				
			}
			return sum;

		} else {
			
			//Recursive Case
			int middle = start+((end-start)/2);
			System.out.println(""
					+ "[start = " + start + ", middle = " + middle + ", end = " + end + "]");
			
			RecursiveTask<Double> otherTask = new WeighAnimalTask(weights, start, middle);
			
			// submit()'s the thread in the pool
			otherTask.fork();
					
					// Here the current thread begins a subtask
			return new WeighAnimalTask(weights, middle, end).compute()
					
					// Called after fork and causes this thread to wait for getting the
					// results and so adds with the result of main thread
					+ otherTask.join();
		}

	}

	public static void main(String[] args) {
		Double[] weights = new Double[10];
		
		ForkJoinTask<Double> task = new WeighAnimalTask(weights, 0, weights.length);
		
		ForkJoinPool pool = new ForkJoinPool();
		
		Double sum = pool.invoke(task);
		
		//Print results
		System.out.println();
		System.out.println("Weights: ");
		Arrays.asList(weights).stream()
			.forEach(s -> System.out.print(s.intValue() + " "));
		
		System.out.println();
		System.out.println("Sum: " + sum);

	}

}
