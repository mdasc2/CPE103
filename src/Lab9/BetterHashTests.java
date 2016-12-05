package Lab9;
/*
* Andrew Chow
* CSC 103
* 11/5/2016
*/
import static org.junit.Assert.*;

import org.junit.Test;

public class BetterHashTests
{

	@Test
	public void test()
	{
		BetterHash bh = new BetterHash();
		assertTrue(bh.hash("LOL") == 722823);
	}
	
	@Test
	public void tes2()
	{
		BetterHash bh = new BetterHash();
		assertTrue(bh.hash("WHATTHE") == 931349205);
	}

}
