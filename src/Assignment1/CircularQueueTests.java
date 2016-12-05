package Assignment1;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class CircularQueueTests 
{

	@Test
	public void test_SizeZero() 
	{
		CircularQueue<Integer> cq = new CircularQueue<Integer>(1);
		assertTrue(cq.size() == 0);
	}
	
	@Test(expected = CircularQueue.MyException.class)
	public void test_InitialCapacityTest()
	{
		CircularQueue<Integer> cq = new CircularQueue<Integer>(0);
	}
	
	@Test(expected = CircularQueue.MyException.class)
	public void test_InitialCapacityTestNeg()
	{
		CircularQueue<Integer> cq = new CircularQueue<Integer>(-1);
	}
	
	@Test
	public void test_ExpoDouble()
	{		
		CircularQueue<Integer> cq = new CircularQueue<Integer>(2);
		cq.enqueue(1);
		cq.enqueue(1);
		cq.enqueue(1);
		
		assertTrue(cq.unusualMethodForTestingPurposesOnly().length == 4);
		assertTrue(cq.size()== 3);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void test_DequeueEmptyQueue()
	{
		CircularQueue<Integer> cq = new CircularQueue<Integer>(2);
		cq.dequeue();		
	}
	
	@Test
	public void test_enQueueAllllDequeueAll()
	{		
		CircularQueue<Integer> cq = new CircularQueue<Integer>(2);
		cq.enqueue(1);
		cq.enqueue(1);
		cq.enqueue(1);
		cq.dequeue();
		cq.dequeue();
		cq.dequeue();		
		
		assertTrue(cq.size()== 0);
	}
	@Test(expected = NoSuchElementException.class)
	public void test_enQueueAllllDequeueAllPlus1()
	{		
		CircularQueue<Integer> cq = new CircularQueue<Integer>(2);
		cq.enqueue(1);
		cq.enqueue(1);
		cq.enqueue(1);
		cq.dequeue();
		cq.dequeue();
		cq.dequeue();	
		cq.dequeue();
	}
	@Test
	public void test_DequeueReturns()
	{		
		CircularQueue<Integer> cq = new CircularQueue<Integer>(2);
		cq.enqueue(1);
		cq.enqueue(2);
		cq.enqueue(3);
		cq.dequeue();
		cq.dequeue();
		
		assertTrue(cq.dequeue() == 3);				
	}
	
	@Test
	public void test_Peek()
	{		
		CircularQueue<Integer> cq = new CircularQueue<Integer>(1);
		cq.enqueue(1);
		assertTrue(cq.peek() == 1);
		
	}	
	@Test
	public void test_PeekafterSomeStuff()
	{		
		CircularQueue<Integer> cq = new CircularQueue<Integer>(1);
		cq.enqueue(1);
		cq.enqueue(2);
		cq.dequeue();
		cq.dequeue();
		cq.enqueue(3);
		
		assertTrue(cq.peek() == 3);		
	}
	
	@Test(expected = NoSuchElementException.class)
	public void test_PeekThrow()
	{		
		CircularQueue<Integer> cq = new CircularQueue<Integer>(1);
		cq.peek();
		
	}
	@Test(expected = NoSuchElementException.class)
	public void test_PeekafterSomeStuffThrow()
	{		
		CircularQueue<Integer> cq = new CircularQueue<Integer>(1);
		
		cq.enqueue(1);
		cq.dequeue();
		cq.enqueue(2);
		cq.dequeue();
				
		cq.peek();	
	}
	

}
