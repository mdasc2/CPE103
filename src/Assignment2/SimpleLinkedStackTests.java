package Assignment2;

/*
 * Andrew Chow
 * CSC 103
 * 10/16/16
 */
import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Test;

public class SimpleLinkedStackTests
{


		@Test(expected = NoSuchElementException.class)
		public void testPeek_Throw()
		{
			SimpleLinkedStack<Integer> ss = new SimpleLinkedStack<Integer>();
			ss.peek();
		}
		@Test
		public void testPushPeek()
		{
			SimpleLinkedStack<Integer> ss = new SimpleLinkedStack<Integer>();
			ss.push(1);
			assertTrue(ss.peek() == 1);
			assertTrue(ss.size() == 1);
		}
		
		@Test(expected = NoSuchElementException.class)
		public void testPushPeek_Throw()
		{
			SimpleLinkedStack<Integer> ss = new SimpleLinkedStack<Integer>();
			ss.push(1);
			ss.pop();
			ss.peek();
		}
		
		@Test(expected = NoSuchElementException.class)
		public void testPop_Throw()
		{
			SimpleLinkedStack<Integer> ss = new SimpleLinkedStack<Integer>();
			ss.pop();
		}
		
		@Test(expected = NoSuchElementException.class)
		public void testPushPop_Throw()
		{
			SimpleLinkedStack<Integer> ss = new SimpleLinkedStack<Integer>();
			ss.push(1);
			ss.pop();
			ss.pop();
		}
		@Test
		public void testPeek()
		{
			SimpleLinkedStack<Integer> ss = new SimpleLinkedStack<Integer>();
			ss.push(6);
			assertTrue(ss.peek() == 6);
			assertTrue(ss.size() == 1);
		}
		@Test
		public void testPeekafterPop()
		{
			SimpleLinkedStack<Integer> ss = new SimpleLinkedStack<Integer>();
			ss.push(5);
			ss.push(6);
			ss.pop();
			assertTrue(ss.peek() == 5);
			assertTrue(ss.size() == 1);
		}
		@Test
		public void testPush()
		{
			SimpleLinkedStack<Integer> ss = new SimpleLinkedStack<Integer>();
			ss.push(3);
			assertTrue(ss.peek() == 3);
			assertTrue(ss.size() == 1);
		}
		@Test
		public void testPop()
		{
			SimpleLinkedStack<Integer> ss = new SimpleLinkedStack<Integer>();
			ss.push(6);
			assertTrue(ss.pop() == 6);
			assertTrue(ss.size() == 0);

		}	
}