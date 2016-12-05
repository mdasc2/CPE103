package Lab12;
import static org.junit.Assert.*;

import org.junit.Test;

public class TSortTests
{

	@Test(expected= IllegalArgumentException.class)
	public void test1throw()
	{
		System.out.println(TSort.tsort(" "));
	}
	@Test(expected= IllegalArgumentException.class)
	public void test2ow()
	{
		System.out.println(TSort.tsort("WHWEHWEHW"));
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void test1throw2()
	{
		System.out.println(TSort.tsort("A B C B A"));
	}
	@Test(expected= IllegalArgumentException.class)
	public void test1throw3()
	{
		System.out.println(TSort.tsort("A B B A"));
	}
	@Test
	public void test1()
	{
		assertEquals(TSort.tsort("A B C B A D").trim(), "C\nA\nD\nB");
	}
	@Test
	public void test2()
	{
		assertEquals(TSort.tsort("101 102 102 103 102 225 ").trim(),"101\n102\n225\n103");
	}
	@Test
	public void test3()
	{
		assertEquals(TSort.tsort("101 102 102 103 102 225 103 348 348 349 103 357 225 357 349 430 357 430 430 431 348 445").trim(),"101\n102\n225\n103\n357\n348\n445\n349\n430\n431");
	}
	
	@Test
	public void test4()
	{
		assertEquals(TSort.tsort("blue black red blue red green green blue green purple purple blue").trim(),"red\ngreen\npurple\nblue\nblack");
	}
	@Test
	public void test5()
	{
		assertEquals(TSort.tsort("3 8 3 10 5 11 7 8 7 11 8 9 11 2 11 9 11 10").trim(),"7\n5\n11\n2\n3\n10\n8\n9");
	}
	
	@Test
	public void test6()
	{
		assertEquals(TSort.tsort("1 2 1 9 1 8 9 8 9 10 8 11 10 11 2 3 3 11 3 4 4 7 4 5 7 5 7 13 7 6 6 14 6 12").trim(),"1\n9\n10\n8\n2\n3\n4\n7\n6\n12\n14\n13\n5\n11");
	}

}
