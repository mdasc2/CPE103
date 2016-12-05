package Lab4;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import Lab3.SimpleArrayStack;

public class BadStackTests
{
	@Test(expected = NoSuchElementException.class)
	public void testPeek_Throw()
	{
		BadStack<Integer> ss = new BadStack<Integer>();
		ss.peek();
	}
	@Test(expected = NoSuchElementException.class)
	public void testPop_Throw()
	{
		BadStack<Integer> ss = new BadStack<Integer>();
		ss.pop();
	}
	@Test
	public void testPeek()
	{
		BadStack<Integer> ss = new BadStack<Integer>();
		ss.push(6);
		assertTrue(ss.peek() == 6);
		assertTrue(ss.size() == 1);
	}
	@Test
	public void testPeekafterPop()
	{
		BadStack<Integer> ss = new BadStack<Integer>();
		ss.push(5);
		ss.push(6);
		ss.pop();
		assertTrue(ss.peek() == 5);
		assertTrue(ss.size() == 1);
	}
	@Test
	public void testBeforeExpo()
	{
		BadStack<Integer> ss = new BadStack<Integer>();
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

		BadStack<Integer> ss = new BadStack<Integer>();
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
		BadStack<Integer> ss = new BadStack<Integer>();
		ss.push(3);
		assertTrue(ss.peek() == 3);
		assertTrue(ss.size() == 1);
	}
	@Test
	public void testPop()
	{
		BadStack<Integer> ss = new BadStack<Integer>();
		ss.push(6);
		assertTrue(ss.pop() == 6);
		assertTrue(ss.size() == 0);

	}	

}
