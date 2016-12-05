package Lab2;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Test;


public class SimpleLinkedQueueTests 
{

	@Test(expected=NoSuchElementException.class)
	public void testdeQueueWhenEmpty() 
	{
		SimpleLinkedQueue<Integer> aq = new SimpleLinkedQueue<Integer>();
		
		aq.dequeue();
	}

	@Test(expected=NoSuchElementException.class)
	public void testdeQueue() 
	{
		SimpleLinkedQueue<Integer> aq = new SimpleLinkedQueue<Integer>();	
		aq.enqueue(1);
		aq.dequeue();
		aq.dequeue();
	}
	
	@Test
	public void testSizeWhenEmpty(){
		SimpleLinkedQueue<Integer> aq = new SimpleLinkedQueue<Integer>();
		
		assertTrue(aq.size() == 0);
	}
	
	@Test
	public void testSize(){
		SimpleLinkedQueue<Integer> aq = new SimpleLinkedQueue<Integer>();
		
		aq.enqueue(1);
		aq.enqueue(2);
		
		assertTrue(aq.size() == 2);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testPeekWhenEmpty() {
		SimpleLinkedQueue<Integer> aq = new SimpleLinkedQueue<Integer>();
		
		aq.peek();
	}
	
	@Test
	public void testPeek(){
		SimpleLinkedQueue<Integer> aq= new SimpleLinkedQueue<Integer>();
		
		aq.enqueue(10);
		aq.dequeue();
		
		aq.enqueue(25);
		aq.dequeue();
		
		aq.enqueue(3);
		assertTrue(aq.peek() == 3);
	}
}
