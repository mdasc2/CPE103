package Assignment4;
/*
* Andrew Chow
* CSC 103
* 11/9/2016
* Assignment 4
*/
import static org.junit.Assert.*;

import org.junit.Test;

public class MorseToTextTests
{

	@Test
	public void testSpaceFront()
	{
		MorseToText mToT = new MorseToText();
		assertEquals("HELLO WORLD", mToT.translate("   .... . .-.. .-.. ---  .-- --- .-. .-.. -.."));
	}
	@Test
	public void testSpaceFront2()
	{
		MorseToText mToT = new MorseToText();
		assertEquals("HELLO WORLD", mToT.translate(" .... . .-.. .-.. ---  .-- --- .-. .-.. -.."));
	}
	@Test
	public void testSpaceMid()
	{
		MorseToText mToT = new MorseToText();
		assertEquals("HELLO      WORLD", mToT.translate(".... . .-.. .-.. ---       .-- --- .-. .-.. -.."));
	}
	@Test
	public void test1()
	{
		MorseToText mToT = new MorseToText();
		assertEquals("", mToT.translate(" "));
	}
	
	@Test
	public void test2()
	{
		MorseToText mToT = new MorseToText();
		assertEquals("", mToT.translate(""));
	}
	@Test
	public void test5()
	{
		MorseToText mToT = new MorseToText();
		assertEquals("(  + 5 )" , mToT.translate("-.--.   .-.-.  .....  -.--.-"));	
		
	}
	@Test
	public void test6()
	{
		MorseToText mToT = new MorseToText();
		assertEquals("( 5 + 5 )" , mToT.translate("-.--.  .....  .-.-.  .....  -.--.-"));	
		
	}
	@Test
	public void test7()
	{
		MorseToText mToT = new MorseToText();
		assertEquals("(  + 5 )" , mToT.translate("-.--.  .../..  .-.-.  .....  -.--.-"));
	}
	@Test
	public void test8()
	{
		MorseToText mToT = new MorseToText();
		assertEquals("5 + 5 )" , mToT.translate("-./--.  .....  .-.-.  .....  -.--.-"));
	}
	@Test
	public void test9()
	{
		MorseToText mToT = new MorseToText();
		assertEquals("( 5 + 5" , mToT.translate("-.--.  .....  .-.-.  .....  -.--/.-"));
	}

}
