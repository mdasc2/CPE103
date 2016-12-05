package Assignment3;

/*
 * Andrew Chow
 * CSC 103
 * 10/30/2016
 */
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;


public class PriorityQueueTests
{
	   @Test
	   public void testPq1()
	   {
		   Integer[] a = new Integer[] {3, 8,55,2,39};
		   PriorityQueue<Integer> pq = new PriorityQueue<Integer>(a, a.length);
		   assertEquals(pq.size(),5);
		   assertEquals(pq.dequeue(), (Integer)2);
		   assertEquals(pq.size(),4);
		   assertEquals(pq.dequeue(), (Integer)3);
		   assertEquals(pq.size(),3);
		   assertEquals(pq.dequeue(), (Integer)8);
		   assertEquals(pq.size(),2);
		   assertEquals(pq.dequeue(), (Integer)39);
		   assertEquals(pq.size(),1);
		   assertEquals(pq.dequeue(), (Integer)55);
	   }
	   @Test
	   public void testPq2()
	   {
		   Integer[] a = new Integer[] {3, 8,55,2,39};
		   PriorityQueue<Integer> pq = new PriorityQueue<Integer>(a, a.length,true);
		   assertEquals(pq.size(),5);
		   assertEquals(pq.dequeue(), (Integer)55);
		   assertEquals(pq.size(),4);
		   assertEquals(pq.dequeue(), (Integer)39);
		   assertEquals(pq.size(),3);
		   assertEquals(pq.dequeue(), (Integer)8);
		   assertEquals(pq.size(),2);
		   assertEquals(pq.dequeue(), (Integer)3);
		   assertEquals(pq.size(),1);
		   assertEquals(pq.dequeue(), (Integer)2);
	   }
	   @Test
	   public void testPq3()
	   {
		   Integer[] a = new Integer[] {-7, 8,55,2,39};
		   PriorityQueue<Integer> pq = new PriorityQueue<Integer>(a, a.length,true);
		   assertEquals(pq.size(),5);
		   assertEquals(pq.dequeue(), (Integer)55);
		   assertEquals(pq.size(),4);
		   assertEquals(pq.dequeue(), (Integer)39);
		   assertEquals(pq.size(),3);
		   assertEquals(pq.dequeue(), (Integer)8);
		   assertEquals(pq.size(),2);
		   assertEquals(pq.dequeue(), (Integer)2);
		   assertEquals(pq.size(),1);
		   assertEquals(pq.dequeue(), (Integer)(-7));
	   }
	   
	   @Test
	   public void testPq4()
	   {
		   Integer[] a = new Integer[] {3, 64,55,2,39};
		   PriorityQueue<Integer> pq = new PriorityQueue<Integer>(a, a.length);
		   assertEquals(pq.size(),5);
		   assertEquals(pq.dequeue(), (Integer)2);
		   assertEquals(pq.size(),4);
		   assertEquals(pq.dequeue(), (Integer)3);
		   assertEquals(pq.size(),3);
		   assertEquals(pq.dequeue(), (Integer)39);
		   assertEquals(pq.size(),2);
		   assertEquals(pq.dequeue(), (Integer)55);
		   assertEquals(pq.size(),1);
		   assertEquals(pq.dequeue(), (Integer)64);
	   }
	   @Test
	   public void testPeek1()
	   {
		   PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		   pq.enqueue(5);
		   assertEquals(pq.peek(),(Integer)5);
	   }
	   @Test
	   public void testPeek2()
	   {
		   PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		   pq.enqueue(5);
		   pq.enqueue(7);
		   assertEquals(pq.peek(),(Integer)5);
	   }
	   @Test
	   public void testPeek3()
	   {
		   PriorityQueue<Integer> pq = new PriorityQueue<Integer>(true);
		   pq.enqueue(5);
		   pq.enqueue(7);
		   assertEquals(pq.peek(),(Integer)7);
	   }
	   @Test(expected = NoSuchElementException.class)
	   public void testPeekEmpty()
	   {
		   PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		   pq.peek();
	   }
	   @Test(expected = NoSuchElementException.class)
	   public void testPeekEmptyafterEnqueue()
	   {
		   PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		   pq.enqueue(1);
		   pq.dequeue();
		   pq.peek();
	   }
	   @Test(expected = NoSuchElementException.class)
	   public void testDequeueEmpty()
	   {
		   PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		   pq.dequeue();
	   }
	   @Test(expected = NoSuchElementException.class)
	   public void testDequeueEmpty2()
	   {
		   PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		   pq.enqueue(1);
		   pq.dequeue();
		   pq.dequeue();
	   }
	   @Test
	   public void testkth1()
	   {
		   Integer[] a = new Integer[] {3, 8,55,2,39};
		   PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		   
		   assertEquals(pq.kth(a, a.length, 5),(Integer) 2);
		   assertEquals(pq.kth(a, a.length, 4),(Integer) 3);
		   assertEquals(pq.kth(a, a.length, 3),(Integer) 8);
		   assertEquals(pq.kth(a, a.length, 2),(Integer) 39);
		   assertEquals(pq.kth(a, a.length, 1),(Integer) 55);
	   }
	   @Test
	   public void testkth2()
	   {
		   Integer[] a = new Integer[] {17,26,-6,100,54};
		   PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		   
		   assertEquals(pq.kth(a, a.length, 5),(Integer) (-6));
		   assertEquals(pq.kth(a, a.length, 4),(Integer) 17);
		   assertEquals(pq.kth(a, a.length, 3),(Integer) 26);
		   assertEquals(pq.kth(a, a.length, 2),(Integer) 54);
		   assertEquals(pq.kth(a, a.length, 1),(Integer) 100);
	   }
	   @Test
	   public void testSort1()
	   {
		   Integer[] a = new Integer[] {-6,17,27,54,100};
		   Integer[] b = new Integer[] {100,27,54,-6,17};
		   PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		   pq.sort(b, b.length);
		   
		   for(int i = 0; i < a.length; i++)
		   {
			   assertEquals(a[i],b[i]);
		   }
	   }
	   @Test
	   public void testSort2()
	   {
		   Integer[] a = new Integer[] {17,27,64,88,100};
		   Integer[] b = new Integer[] {100,27,64,17,88};
		   PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		   pq.sort(b, b.length);
		   
		   for(int i = 0; i < a.length; i++)
		   {
			   assertEquals(a[i],b[i]);
		   }
	   }
}
