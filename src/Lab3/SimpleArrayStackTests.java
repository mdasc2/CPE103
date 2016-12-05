package Lab3;

/*
 * Andrew Chow
 * CSC 103
 * 10/11/16
 */
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class SimpleArrayStackTests
{

	@Test(expected = NoSuchElementException.class)
	public void testPeek_Throw()
	{
		SimpleArrayStack<Integer> ss = new SimpleArrayStack<Integer>();
		ss.peek();
	}
	@Test(expected = NoSuchElementException.class)
	public void testPop_Throw()
	{
		SimpleArrayStack<Integer> ss = new SimpleArrayStack<Integer>();
		ss.pop();
	}
	@Test
	public void testPeek()
	{
		SimpleArrayStack<Integer> ss = new SimpleArrayStack<Integer>();
		ss.push(6);
		assertTrue(ss.peek() == 6);
		assertTrue(ss.size() == 1);
	}
	@Test
	public void testPeekafterPop()
	{
		SimpleArrayStack<Integer> ss = new SimpleArrayStack<Integer>();
		ss.push(5);
		ss.push(6);
		ss.pop();
		assertTrue(ss.peek() == 5);
		assertTrue(ss.size() == 1);
	}
	@Test
	public void testBeforeExpo()
	{
		SimpleArrayStack<Integer> ss = new SimpleArrayStack<Integer>();
		ss.push(1);
		ss.push(1);
		ss.push(2);
		ss.push(1);		
		ss.push(4);
		ss.push(6);
		ss.push(6);
		ss.push(6);
		ss.push(6);
		ss.push(6);
		assertTrue(ss.capacity() == 10);
		assertTrue(ss.size() == 10);
	}
	
	@Test
	public void testAfterExpo()
	{

		SimpleArrayStack<Integer> ss = new SimpleArrayStack<Integer>();
		ss.push(1);
		ss.push(1);
		ss.push(2);
		ss.push(1);		
		ss.push(4);
		ss.push(6);
		ss.push(6);
		ss.push(6);
		ss.push(6);
		ss.push(6);
		ss.push(6);
		assertTrue(ss.capacity() == 20);
		assertTrue(ss.size() == 11);
	}
	@Test
	public void testPush()
	{
		SimpleArrayStack<Integer> ss = new SimpleArrayStack<Integer>();
		ss.push(3);
		assertTrue(ss.peek() == 3);
		assertTrue(ss.size() == 1);
	}
	@Test
	public void testPop()
	{
		SimpleArrayStack<Integer> ss = new SimpleArrayStack<Integer>();
		ss.push(6);
		assertTrue(ss.pop() == 6);
		assertTrue(ss.size() == 0);

	}	
}
