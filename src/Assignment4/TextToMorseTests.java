package Assignment4;
/*
 * Andrew Chow
 * CSC 103
 * 11/9/2016
 * Assignment 4
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class TextToMorseTests
{

	@Test
	public void test()
	{
		TextToMorse ttm = new TextToMorse();
		assertEquals(".-- .... .- -" , ttm.translate("WHAT "));
		
	}
	
	@Test
	public void test1()
	{
		TextToMorse ttm = new TextToMorse();
		assertEquals(".-- .... -" , ttm.translate("WHaT "));
		
	}
	
	@Test
	public void test2()
	{
		TextToMorse ttm = new TextToMorse();
		assertEquals("-.. . - .-. . ." , ttm.translate("DETREE"));
		
	}
	@Test
	public void test3()
	{
		TextToMorse ttm = new TextToMorse();
		assertEquals(".... . .-.. .-.. ---  .-- --- .-. .-.. -.." , ttm.translate(" HELLO WORLD"));
		
	}
	
	@Test
	public void test4()
	{
		TextToMorse ttm = new TextToMorse();
		assertEquals(".  .  .  .  .  .  .   ." , ttm.translate("E E E E E E E  E"));
		
	}
	@Test
	public void test5()
	{
		TextToMorse ttm = new TextToMorse();
		assertEquals(". . . . . . .  ." , ttm.translate("EEEEEEE E"));
		
	}
	
	@Test
	public void testSpaceMid()
	{
		TextToMorse ttm = new TextToMorse();
		assertEquals(".... . .-.. .-.. ---       .-- --- .-. .-.. -.." , ttm.translate("HELLO      WORLD"));
		
	}
	@Test
	public void test6()
	{
		TextToMorse ttm = new TextToMorse();
		assertEquals("-.--.  .....  .-.-.  .....   -.--.-" , ttm.translate("( 5 + 5  )"));		
	}
	@Test
	public void test7()
	{
		TextToMorse ttm = new TextToMorse();
		assertEquals("-.--.  .....  .-.-.  .....  -.--.-" , ttm.translate("( 5 + 5 )"));		
	}
	
	@Test
	public void test8()
	{
		TextToMorse ttm = new TextToMorse();
		assertEquals("-.--.   .-.-.  .....  -.--.-" , ttm.translate("( a + 5 )"));		
	}

}
