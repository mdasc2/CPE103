package Lab9;
/*
* Andrew Chow
* CSC 103
* 11/5/2016
*/
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.Test;

public class HashToolsTests
{

	@Test
	public void testStringHashCollision()
	{
		HashTools ht = new HashTools();
		BetterHash sh = new BetterHash();
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Wat");
		arr.add("taW");
		arr.add("Wat");
		arr.add("Wat");
		arr.add("Watd");

		assertTrue(ht.collisions(arr, arr.size(), sh) == 2);
	}
	
	@Test
	public void test()
	{
		HashTools ht = new HashTools();
		StringHash sh = new StringHash();
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Wat");
		arr.add("Wat");
		arr.add("Wat");
		arr.add("Wat/");
		arr.add("ta");
		arr.add("WTF");
		assertTrue(ht.collisions(arr, arr.size(), sh) == 2);
	}
	@Test
	public void testUnused()
	{
		HashTools ht = new HashTools();
		StringHash sh = new StringHash();
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Wat");
		arr.add("Wat");
		arr.add("taW");
		arr.add("Wat");
		arr.add("Wat");
		arr.add("Wat");
		assertTrue(ht.unused(arr, arr.size(), sh) == 5);
	}
	@Test
	public void HashTesting () throws Exception
	{
		HashTools ht = new HashTools();
		StringHash sh = new StringHash();
		MyHash mh = new MyHash();
		BetterHash bh = new BetterHash();
		
		File myFile = new File("dictionary");
		Scanner s = new Scanner(myFile);
		LinkedList<String> list = new LinkedList<String>();
		while (s.hasNextLine())
		{
			list.add(s.nextLine());
		}
		s.close();	
		
		System.out.println(ht.collisions(list, list.size(), mh));
		System.out.println(ht.maxCollisions(list, list.size(), mh));
		System.out.println(ht.avgCollisions(list, list.size(), mh));	
		System.out.println(ht.unused(list, list.size(), mh));
		
	}
	@Test
	public void testUnused2()
	{
		HashTools ht = new HashTools();
		StringHash sh = new StringHash();
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Wat");
		arr.add("Wat");
		arr.add("taW");
		arr.add("Wat");
		arr.add("Wat");
		arr.add("Wat");
		assertEquals(ht.avgCollisions(arr, arr.size(), sh), 3.0, .00001);
	}

}
