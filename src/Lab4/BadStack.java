package Lab4;

import java.util.NoSuchElementException;

import Lab3.SimpleArrayStack;

public class BadStack<T> implements SimpleStack<T>
{
	private T[] arr;
	private int size;
	

	@SuppressWarnings("unchecked")
	public BadStack()
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
		
		return arr[0];
	}
	
	@Override
	public T pop()
	{
		if (size == 0)
		{
			throw new NoSuchElementException();
		}
		
		T holder =  arr[0];	
		for(int i = 0; i < size - 1 ; i++)
		{
				arr[i]= arr[i+1];
		}
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
		for(int i = size-1; i > 0;i--)
		{
			 arr[i] = arr[i-1];
		}
		arr[0] = element;
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
	 public static void main(String args[]) {
		 

		  }

}
