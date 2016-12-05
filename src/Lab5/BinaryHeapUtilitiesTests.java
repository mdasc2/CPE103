package Lab5;

/*
 * Andrew Chow
 * CSC 103
 * 10/21/2016
 */
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class BinaryHeapUtilitiesTests
{

	@Test
	public void test_Height1()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		assertTrue(bhu.height(8) == 3);
	}
	
	@Test
	public void test_Height2()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		assertTrue(bhu.height(4) == 2);
	}
	
	@Test
	public void test_Height3()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		assertTrue(bhu.height(6) == 2);
	}
	@Test
	public void test_Height4()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		assertTrue(bhu.height(15) == 3);
	}
	@Test
	public void test_Height5()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		assertTrue(bhu.height(16) == 4);
	}
	@Test
	public void test_isHeap1()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[10];
		arr[1] = 1;
		arr[2] = 5;
		arr[3] = 1;
		arr[4] = 5;
		arr[5] = 5;
		arr[6] = 6;
		arr[7] = 5;
		arr[8] = 5;
		arr[9] = 6;	
		assertTrue(bhu.isHeap(arr, arr.length-1));
	}
	@Test
	public void test_isHeap2()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[10];
		arr[1] = 1;
		arr[2] = 5;
		arr[3] = 1;
		arr[4] = 5;
		arr[5] = 5;
		arr[6] = 6;
		arr[7] = 0;
		arr[8] = 6;
		arr[9] = 6;	
		assertTrue(!bhu.isHeap(arr, arr.length-1));
	}
	@Test
	public void test_isHeap3()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[2];
		arr[1] = 1;
		assertTrue(bhu.isHeap(arr, arr.length-1));
	}
	@Test
	public void test_isHeap4()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[4];
		arr[1] = 1;
		arr[2] = 0;
		arr[3] = 1;
		assertTrue(!bhu.isHeap(arr, arr.length-1));
	}
	
	@Test
	public void test_isHeap5()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[5];
		arr[1] = 1;
		arr[2] = 5;
		arr[3] = 1;
		arr[4] = 4;
		assertTrue(!bhu.isHeap(arr, arr.length-1));
	}
	@Test
	public void test_isHeap6()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[6];
		arr[1] = 1;
		arr[2] = 5;
		arr[3] = 1;
		arr[4] = 4;
		arr[5] = 5;
		assertTrue(!bhu.isHeap(arr, arr.length-1));
	}
	@Test
	public void test_isHeap7()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[8];
		arr[1] = 1;
		arr[2] = 5;
		arr[3] = 1;
		arr[4] = 5;
		arr[5] = 5;
		arr[6] = 2;
		arr[7] = 2;
		assertTrue(bhu.isHeap(arr, arr.length-1));
	}
	@Test
	public void test_isHeap8()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[5];
		arr[1] = 1;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 0;
		
		assertTrue(!bhu.isHeap(arr, arr.length-1));
	}
	@Test
	public void test_isHeap9()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[4];
		arr[1] = 1;
		arr[2] = 0;
		arr[3] = 5;
		
		assertTrue(!bhu.isHeap(arr, arr.length-1));
	}
	@Test(expected = IllegalArgumentException.class)
	public void test_parentOf1()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[4];
		arr[1] = 1;
		arr[2] = 0;
		arr[3] = 5;
		assertTrue(bhu.parentOf(2, arr, arr.length -1) == 1);
		
	}
	@Test
	public void test_parentOf2()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[4];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 5;
		assertTrue(bhu.parentOf(2, arr, arr.length -1)== 1);
		
	}
	@Test(expected = NoSuchElementException.class)
	public void test_parentOf4()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[4];
		arr[1] = 1;
		arr[2] = 0;
		arr[3] = 5;
		assertTrue(bhu.parentOf(1, arr, arr.length -1) == 1);
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_parentOf5()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[4];
		arr[1] = 1;
		arr[2] = 0;
		arr[3] = 5;
		assertTrue(bhu.parentOf(5, arr, arr.length -1) == 1);
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_parentOf6()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[4];
		arr[1] = 1;
		arr[2] = 0;
		arr[3] = 5;
		assertTrue(bhu.parentOf(0, arr, arr.length -1) == 1);
	}
	@Test(expected = NoSuchElementException.class)
	public void test_leftChild1()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[4];
		arr[1] = 1;
		arr[2] = 0;
		arr[3] = 5;
		assertTrue(bhu.leftChildOf(3, arr, arr.length -1) == 1);
	}
	@Test
	public void test_leftChild2()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[4];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 5;
		assertTrue(bhu.leftChildOf(1, arr, arr.length -1) == 2);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void test_rightChild1()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[4];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 5;
		assertTrue(bhu.rightChildOf(2, arr, arr.length -1) == 1);
	}
	@Test
	public void test_rightChild2()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[4];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 5;
		assertTrue(bhu.rightChildOf(1, arr, arr.length -1) == 5);
	}
	
	@Test
	public void test_rightChild3()
	{
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		Integer[] arr = new Integer[6];
		arr[1] = 1;
		arr[2] = 5;
		arr[3] = 1;
		arr[4] = 6;
		arr[5] = 5;
		assertTrue(bhu.rightChildOf(2, arr, arr.length -1) == 5);
	}


}
