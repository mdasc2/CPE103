package Lab3;
/*
 * Andrew Chow
 * CSC 103
 * 10/11/16
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class BSCTests
{
	@Test
	public void test1()
	{
		BSC bsc = new BSC();
		assertTrue(bsc.isBalanced("( [ { < ( ) <( ){}>> } ] )"));
	}	
	@Test
	public void test2()
	{
		BSC bsc = new BSC();
		assertTrue(bsc.isBalanced("[(Hello) {W}orld!]"));
	}
	@Test
	public void test3()
	{
		BSC bsc = new BSC();
		assertFalse(bsc.isBalanced("{{})}"));
	}
	@Test
	public void test4()
	{
		BSC bsc = new BSC();
		assertTrue(bsc.isBalanced("[]{}"));
	}
	@Test
	public void test5()
	{
		BSC bsc = new BSC();
		assertFalse(bsc.isBalanced(":)"));
	}
	@Test
	public void test6()
	{
		BSC bsc = new BSC();
		assertTrue(bsc.isBalanced("FU(CK) THI{{[] S G}< > }AME"));
	}
	@Test
	public void test7()
	{
		BSC bsc = new BSC();
		assertTrue(bsc.isBalanced(""));
	}
	@Test
	public void test8()
	{
		BSC bsc = new BSC();
		assertTrue(bsc.isBalanced("YO WHATS UP HOMIE I'M BALANCED AF"));
	}
	
	@Test
	public void test9()
	{
		BSC test = new BSC();	
		assertTrue(test.isBalanced("<<<((((<{[]}>))))>>>"));
	}
	@Test
	public void test10()
	{
		BSC bsc = new BSC();
		assertTrue(bsc.isBalanced("[]"));
	}
	@Test
	public void test11()
	{
		BSC bsc = new BSC();
		assertTrue(bsc.isBalanced("{}"));
	}
	
	@Test
	public void test12()
	{
		BSC bsc = new BSC();
		assertTrue(bsc.isBalanced("<>"));
	}
	@Test
	public void test13()
	{
		BSC bsc = new BSC();
		assertTrue(bsc.isBalanced("()"));
	}
	@Test
	public void test14()
	{
		BSC bsc = new BSC();
		assertFalse(bsc.isBalanced("}}"));
	}
	@Test
	public void test15()
	{
		BSC bsc = new BSC();
		assertFalse(bsc.isBalanced("FAWFAWGAG>"));
	}
	@Test
	public void test16()
	{
		BSC bsc = new BSC();
		assertFalse(bsc.isBalanced("(><)"));
	}
}
