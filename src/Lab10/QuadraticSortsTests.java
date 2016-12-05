package Lab10;

/*
 * Andrew Chow
 * CSC 103
 * 11/12/2016
 */
import static org.junit.Assert.*;
import java.util.Random;

import org.junit.Test;

public class QuadraticSortsTests
{
	Random rand = new Random();
	@Test
	public void test()
	{
		Integer[] arr= {54,52,7,151,25,71,26,46,89,12};
		QuadraticSorts.bubbleSort1(arr);

		for(int i = 0 ; i < arr.length -1; i++)
		{
			assertTrue(arr[i] < arr[i +1]);
		}
	}
	@Test
	public void test2()
	{
		Integer[] arr= {54,52,7,151,25,71,26,46,89,12};
		QuadraticSorts.bubbleSort2(arr);

		for(int i = 0 ; i < arr.length -1; i++)
		{
			assertTrue(arr[i] < arr[i +1]);
		}
	}
	@Test
	public void test3()
	{
		Integer[] arr= {54,52,7,151,25,71,26,46,89,12};
		QuadraticSorts.selectionSort(arr);
		/*
		for(int i = 0; i < arr.length; i ++)
		{
			System.out.println(arr[i]);
		}
		*/
		for(int i = 0 ; i < arr.length -1; i++)
		{
			assertTrue(arr[i] < arr[i +1]);
		}
	}
	@Test
	public void test4()
	{
		Integer[] arr= {54,52,7,151,25,71,26,46,89,12};
		QuadraticSorts.insertionSort(arr);
		for(int i = 0 ; i < arr.length -1; i++)
		{
			assertTrue(arr[i] <= arr[i +1]);
		}
	}
	@Test
	public void test2500Timesbubble1()
	{
		Integer[] arr = new Integer[20000];
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(Integer.MAX_VALUE -1);
		}
		
		long start = System.currentTimeMillis();
		QuadraticSorts.bubbleSort1(arr);
		long stop = System.currentTimeMillis();
		for(int i = 0 ; i < arr.length -1; i++)
		{
			System.out.println(i + "/" + arr[i] + "/" + arr[i+1]);
			assertTrue(arr[i] <= arr[i +1]);
		}
		
		System.out.println(stop - start + "ms");		
	}
	@Test
	public void test2500Timesbubble2()
	{
		Integer[] arr = new Integer[20000];
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(Integer.MAX_VALUE -1);
		}
		
		long start = System.currentTimeMillis();
		QuadraticSorts.bubbleSort2(arr);
		long stop = System.currentTimeMillis();
		
		for(int i = 0 ; i < arr.length -1; i++)
		{
			System.out.println(i + "/" + arr[i] + "/" + arr[i+1]);
			assertTrue(arr[i] <= arr[i +1]);
		}
		
		System.out.println(stop - start + "ms");
		
		
	}
	@Test
	public void test2500TimesSelection()
	{
		Integer[] arr = new Integer[20000];
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(Integer.MAX_VALUE -1);
		}
		
		long start = System.currentTimeMillis();
		QuadraticSorts.selectionSort(arr);
		long stop = System.currentTimeMillis();
		for(int i = 0 ; i < arr.length -1; i++)
		{
			System.out.println(i + "/" + arr[i] + "/" + arr[i+1]);
			assertTrue(arr[i] <= arr[i +1]);
		}
		
		System.out.println(stop - start + "ms");
		
		
	}
	
	@Test
	public void test2500TimesInsertion()
	{
		Integer[] arr = new Integer[20000];
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(Integer.MAX_VALUE -1);
		}
		
		long start = System.currentTimeMillis();
		QuadraticSorts.insertionSort(arr);
		long stop = System.currentTimeMillis();
		for(int i = 0 ; i < arr.length -1; i++)
		{
			System.out.println(i + "/" + arr[i] + "/" + arr[i+1]);
			assertTrue(arr[i] <= arr[i +1]);
		}
		
		System.out.println(stop - start + "ms");				
	}
	

}
