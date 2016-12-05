package Lab9;
/*
* Andrew Chow
* CSC 103
* 11/5/2016
*/
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class PrimeToolsTests
{

	@Test
	public void test1()
	{
		PrimeTools tl = new PrimeTools();
		assertTrue(PrimeTools.isPrime(199));
	}
	@Test
	public void test2()
	{
		PrimeTools tl = new PrimeTools();
		assertFalse(PrimeTools.isPrime(1));
	}
	@Test
	public void test3()
	{
		PrimeTools tl = new PrimeTools();
		assertTrue(PrimeTools.isPrime(2));
	}
	@Test
	public void test5()
	{
		PrimeTools tl = new PrimeTools();
		assertTrue(PrimeTools.isPrime(3));
	}
	
	@Test
	public void test4()
	{
		PrimeTools tl = new PrimeTools();
		assertFalse(PrimeTools.isPrime(4));
	}
	
	@Test
	public void test6()
	{
		PrimeTools tl = new PrimeTools();
		assertTrue(PrimeTools.nextPrime(6) == 7);
	}
	
	@Test
	public void test7()
	{
		PrimeTools tl = new PrimeTools();
		assertTrue(PrimeTools.nextPrime(6) == 7);
	}
	
	@Test
	public void test8()
	{
		PrimeTools tl = new PrimeTools();
		assertTrue(PrimeTools.nextPrime(1) == 2);
	}
	@Test
	public void test9()
	{
		PrimeTools tl = new PrimeTools();
		assertTrue(PrimeTools.nextPrime(2) == 2);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionThrow1()
	{
		PrimeTools tl = new PrimeTools();
		assertTrue(PrimeTools.nextPrime(-1) == 2);
	}
	@Test
	public void testExceptionThrow2()
	{
		PrimeTools tl = new PrimeTools();
		assertTrue(PrimeTools.nextPrime(Integer.MAX_VALUE -1) == Integer.MAX_VALUE);
	}

}
