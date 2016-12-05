package Lab5;
/*
 * Andrew Chow
 * CSC 103
 * 10/21/2016
 */

import java.util.NoSuchElementException;
public class BinaryHeapUtilities
{
	public static int height(int size)
	{		
		return (int)(Math.log(size)/Math.log(2));
	}
	
	public static <T extends Comparable<? super T>> boolean isHeap(T[] heap, int size)
	{
		if(heap[1] != null)
		{		
			for(int i = 1; i <= (size/2); i++)
			{			
				if(heap[2*i].compareTo(heap[i]) < 0)
				{
					return false;
				}
				
				if(!((2*i+1) > size))
				{
					if(heap[2*i+1].compareTo(heap[i]) < 0)
					{
						return false;
					}				
				}
			}
		}
		else
		{
			return false;
		}
		
		return true;
	}
	
	public static <T extends Comparable<? super T>> T parentOf(int index,T[] heap,int size)
	{
		if(index < 1 || index > size)
		{
			throw new IndexOutOfBoundsException();
		}
		
		if( index/2 < 1)
		{
			throw new NoSuchElementException();
		}
		
		if(!isHeap(heap,size))
		{
			throw new IllegalArgumentException();
		}
		
		return heap[index/2];
		
	}	
	public static <T extends Comparable<? super T>> T leftChildOf(int index,T[] heap,int size)	
	{
		if(index < 1 || index > size)
		{
			throw new IndexOutOfBoundsException();
		}
		
		if(2*index > size)	
		{
			throw new NoSuchElementException();
		}			
		if(!isHeap(heap,size))
		{
			throw new IllegalArgumentException();
		}
		
		return heap[2*index];
	}
	
	public static <T extends Comparable<? super T>> T rightChildOf(int index,T[] heap,int size)
	{
		if(index < 1 || index > size)
		{
			throw new IndexOutOfBoundsException();
		}
		
		if((2*index +1) > size)
		{
			throw new NoSuchElementException();
		}
		
		if(!isHeap(heap,size))
		{
			throw new IllegalArgumentException();
		}
		
		return heap[2*index +1];
	}
	

	public static void main(String[] args)
	{
		Integer[] arr = new Integer[10];
		arr[1] = 1;
		arr[2] = 5;
		arr[3] = 1;
		arr[4] = 6;
		arr[5] = 5;
		arr[6] = 6;
		arr[7] = 5;
		arr[8] = 6;
		arr[9] = 6;
		
		BinaryHeapUtilities bhu = new BinaryHeapUtilities();
		
		System.out.println(bhu.isHeap(arr, arr.length -1));
		System.out.println(bhu.parentOf(2, arr, arr.length -1));
		System.out.println(bhu.leftChildOf(2, arr, arr.length -1));
	}
}
