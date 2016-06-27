import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
 
public class PriorityQueueTest {
 
	static class PQsort implements Comparator<Integer> {
 
		public int compare(Integer one, Integer two) {
			return two - one;
		}
	}
 
	public static void max3()
	{
		int[] a = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
 
		// use offer() method to add elements to the PriorityQueue pq1
		for (int x : a) {
			pq.offer(x);
		}
		pq.remove();
		pq.remove();
		System.out.println(pq.remove());
	}
	public static void main(String[] args) {
		
		max3();
		
		int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
		Arrays.sort(ia);
		String s[]={"ss","fdgh","fxgh"};
		Arrays.sort(s);
		for(int i=0;i<3;i++)
		{
			System.out.println(s[i]);
		}
		
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
 
		// use offer() method to add elements to the PriorityQueue pq1
		for (int x : ia) {
			pq1.offer(x);
			System.out.println("pq1: " + pq1);
		}
 
		System.out.println("pq1: " + pq1);
//		for(int i=0;i<ia.length;i++)
//			
//		System.out.println(pq1.remove());
		
	PQsort pqs = new PQsort();
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10,pqs);
		// In this particular case, we can simply use Collections.reverseOrder()
		// instead of self-defined comparator
		for (int x : ia) {
			System.out.println("pq2: " + pq2);
			pq2.offer(x);
		}
 
		System.out.println("pq2: " + pq2);
 
		// print size
		System.out.println("size: " + pq2.size());
		// return highest priority element in the queue without removing it
		System.out.println("peek: " + pq2.peek());
		// print size
		System.out.println("size: " + pq2.size());
		// return highest priority element and removes it from the queue
		System.out.println("poll: " + pq2.poll());
		// print size
		System.out.println("size: " + pq2.size());
 
		System.out.print("pq2: " + pq2);
 
	}
}