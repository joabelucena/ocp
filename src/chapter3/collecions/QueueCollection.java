package chapter3.collecions;

import static lib.TextElements.*;

import java.util.*;


public class QueueCollection {

	public static void main(String[] args) {

		/**
		 * Queue interface has some implementations, here are the most common followed by its 
		 * characteristics:
		 * 
		 *  Implementation	Description
		 * ----------------------------------------------------------------------------------------
		 *  LinkedList		Double-ended queue (has two fronts or two backs). Implements List also
		 *  ArrayDeque		Double-ended pure Queue. It's faster than LinkedList		
		 *    
		 */
		{
			/*
			 * Usage of a Queue as a queue
			 */
			Queue<Integer> queue = new ArrayDeque<>();
			System.out.println(queue.offer(10));
			System.out.println(queue.offer(4));
			
			System.out.println(queue);
			
			System.out.println(queue.peek());
			System.out.println(queue.poll());
			System.out.println(queue.poll());
			System.out.println(queue.peek());
			
			miniSepare();
			
			queue.clear();
			
			System.out.println("Inserting elements in a queue");
			
			miniSepare();
			
			queue.offer(1);		System.out.println(queue);
			queue.offer(2);		System.out.println(queue);
			queue.offer(3);		System.out.println(queue);
			queue.offer(4);		System.out.println(queue);
			queue.offer(5);		System.out.println(queue);
			
			miniSepare();
			System.out.println("removing elements of a queue");
			miniSepare();
			
			queue.poll();		System.out.println(queue);
			queue.poll();		System.out.println(queue);
			queue.poll();		System.out.println(queue);
			queue.poll();		System.out.println(queue);
			queue.poll();		System.out.println(queue);
			
			
			
		}
		
		separe();
		
		{
			/*
			 * Usage of a Queue as a stack
			 */
			ArrayDeque<Integer> stack = new ArrayDeque<>();
			stack.push(10);
			stack.push(4);
			
			System.out.println(stack);
			
			System.out.println(stack.peek());
			System.out.println(stack.poll());
			System.out.println(stack.poll());
			System.out.println(stack.peek());
			
			miniSepare();
			
			stack.clear();
			
			System.out.println("Inserting elements in a stack");
			
			miniSepare();
			
			stack.push(1);		System.out.println(stack);
			stack.push(2);		System.out.println(stack);
			stack.push(3);		System.out.println(stack);
			stack.push(4);		System.out.println(stack);
			stack.push(5);		System.out.println(stack);
			
			miniSepare();
			
			System.out.println("Removing elements of a stack");
			
			miniSepare();
			
			stack.poll();		System.out.println(stack);
			stack.poll();		System.out.println(stack);
			stack.poll();		System.out.println(stack);
			stack.poll();		System.out.println(stack);
			stack.poll();		System.out.println(stack);
			
			
			
		}

		

	}

}
