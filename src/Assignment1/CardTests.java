package Assignment1;
/*
 * Andrew Chow
 * CSC 103
 * 10/7/2016
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTests
{

	@Test(expected = IllegalArgumentException.class)
	public void testCardRankOver()
	{
		Card c = new Card(14,1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCardRankUnder()
	{
		Card c = new Card(0,1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCardSuitOver()
	{
		Card c = new Card(1,5);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCardSuitUnder()
	{
		Card c = new Card(1,0);
		
	}
	
	@Test
	public void testGetRank()
	{
		Card c = new Card(12,4);
		assertEquals(c.getRank(),"Queen");
	}
	@Test
	public void testGetSuit()
	{
		Card c = new Card(12,4);
		assertEquals(c.getSuit(),"Clubs");
	}
	@Test
	public void testGetRank2()
	{
		Card c = new Card(10,4);
		assertEquals(c.getRank(),"10");
	}
	@Test
	public void testGetSuit2()
	{
		Card c = new Card(12,3);
		assertEquals(c.getSuit(),"Diamonds");
	}
	
	@Test
	public void testToString1()
	{
		Card c = new Card(12,3);
		assertEquals(c.toString(),"Queen of Diamonds");
	}
	@Test
	public void testToString2()
	{
		Card c = new Card(8,2);
		assertEquals(c.toString(),"8 of Hearts");
	}
	@Test
	public void testToString3()
	{
		Card c = new Card(7,1);
		assertEquals(c.toString(),"7 of Spades");
	}
	

}
