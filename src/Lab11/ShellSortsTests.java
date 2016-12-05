package Lab11;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class ShellSortsTests
{
	Random rand = new Random();
	@Test
	public void test2500Timesshell()
	{
		Integer[] arr = new Integer[1000];
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(Integer.MAX_VALUE -1);
		}
		
		long start = System.currentTimeMillis();
		ShellSorts.shell(arr);
		long stop = System.currentTimeMillis();
		for(int i = 0 ; i < arr.length -1; i++)
		{
			assertTrue(arr[i] <= arr[i +1]);
		}
		
		System.out.println(stop - start + "ms");		
	}
	@Test
	public void test2500Timesheap()
	{
		Integer[] arr = new Integer[2500];
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(Integer.MAX_VALUE -1);
		}
		
		long start = System.currentTimeMillis();
		ShellSorts.heapSort(arr);
		long stop = System.currentTimeMillis();
		for(int i = 0 ; i < arr.length -1; i++)
		{
			assertTrue(arr[i] <= arr[i +1]);
		}
		
		System.out.println(stop - start + "ms");		
	}
	@Test
	public void test2500Timessedgewick()
	{
		Integer[] arr = new Integer[2500];
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(Integer.MAX_VALUE -1);
		}
		
		long start = System.currentTimeMillis();
		ShellSorts.sedgewick(arr);
		long stop = System.currentTimeMillis();
		for(int i = 0 ; i < arr.length -1; i++)
		{
			assertTrue(arr[i] <= arr[i +1]);
		}
		
		System.out.println(stop - start + "ms");		
	}
	@Test
	public void test2500Timeshibbard()
	{
		Integer[] arr = new Integer[2500];
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(Integer.MAX_VALUE -1);
		}
		
		long start = System.currentTimeMillis();
		ShellSorts.hibbard(arr);
		long stop = System.currentTimeMillis();
		for(int i = 0 ; i < arr.length -1; i++)
		{
			assertTrue(arr[i] <= arr[i +1]);
		}
		
		System.out.println(stop - start + "ms");		
	}


}
