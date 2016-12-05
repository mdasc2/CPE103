package Assignment4;
/*
 * Andrew Chow
 * CSC 103
 * 10/11/16
 */

import java.util.NoSuchElementException;

public class SimpleArrayStack<T> implements SimpleStack<T>
{
	private T[] arr;
	private int size;
	

	@SuppressWarnings("unchecked")
	public SimpleArrayStack()
	{
		size = 0;
		arr =(T[])new Object[10];
	}
	
	@Override
	public T peek()
	{		
		if (size == 0)
		{
			throw new NoSuchElementException();
		}
		
		return arr[size-1];
	}
	
	@Override
	public T pop()
	{
		if (size == 0)
		{
			throw new NoSuchElementException();
		}
		
		T holder = arr[size - 1];
		arr[size - 1] = null;
		size--;	
		
		return holder;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void push(T element)
	{	
		if(size == arr.length)
		{
			T[] temp = (T[])new Object[arr.length *2];	
			
			for( int i = 0; i< arr.length; i++)
			{
				temp[i] = arr[i];
			}
			arr = temp;
		}
		size++;
		arr[size-1] = element; 							
	}
	@Override
	public int size()
	{		
		return size;
	}
	
	public int capacity()
	{
		return arr.length;
	}	

}
