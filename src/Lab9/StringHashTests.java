package Lab9;
/*
* Andrew Chow
* CSC 103
* 11/5/2016
*/
import static org.junit.Assert.*;

import org.junit.Test;

public class StringHashTests
{

	@Test
	public void test()
	{
		StringHash sh = new StringHash();
		assertTrue(sh.hash("LOL") == 75561);
	}
	
	@Test
	public void test2()
	{
		StringHash sh = new StringHash();
		assertTrue(sh.hash("WHATTHE") == 2027322125);
	}

}
