package Lab9;
/*
* Andrew Chow
* CSC 103
* 11/5/2016
*/
import static org.junit.Assert.*;

import org.junit.Test;

public class MyHashTests
{

	@Test
	public void test()
	{
		MyHash bh = new MyHash();
		assertTrue(bh.hash("LOL") == 10539);
	}
	
	@Test
	public void tes2()
	{
		MyHash bh = new MyHash();
		assertTrue(bh.hash("WHATTHE") == 961335805);
	}


}
