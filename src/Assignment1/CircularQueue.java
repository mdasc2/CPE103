package Assignment1;
/*
 * Andrew Chow
 * CSC 103
 * 10/7/2016
 * A circular queue implementation with a MyExceptionclass
 */
import java.util.NoSuchElementException;

public class CircularQueue<T> implements  SimpleQueue<T> 
{
	private T[] arr;
	public static final int INITIAL_LENGTH = 10;
	private int back;
	private int front;
	private int size ;
	
	//Both constructors start the back from front-1. Front is initialized as 0 and so is size.
	@SuppressWarnings("unchecked")
	public CircularQueue()
	{		
		arr = (T[])new Object[INITIAL_LENGTH];
		back = -1;
		front = 0;
		size = 0;
	}
	
	@SuppressWarnings("unchecked")
	public CircularQueue(int initialCapacity)
	{
		if (initialCapacity <= 0 )
		{
			throw new MyException();
		}		
		
		arr = (T[])new Object[initialCapacity];
		back = -1;
		front = 0;
		size = 0;
	}

	// Enqueues values into the queue, increases by 2x if the queue becomes full.
	@SuppressWarnings("unchecked")
	@Override
	public void enqueue(T element) 
	{					
		if(size == arr.length)
		{		
			T[] temp = (T[])new Object[arr.length *2];
			
			int interator = front;			
			for (int i = 0; i < arr.length;i++)
			{
				temp[i] = arr[interator % arr.length];
				interator++;
			}
			
			front = 0;
			back = arr.length -1;
			arr = temp;			
		}
					
		back++;
		
		if(back == arr.length)
		{
			back = back % arr.length;
		}	
		
		arr[back] = element;		
										
		size++;					
	}	
	@Override
	public T dequeue() 
	{
		if (size == 0 )
		{
			throw new NoSuchElementException();
		}
		
		T temp = arr[front];
		
		front++;
		
		if(front == arr.length)
		{
			front = front % arr.length;
		}
			
		size--;
		
		return temp;
	}

	@Override
	public T peek() 
	{	
		if(size == 0)
		{
			throw new NoSuchElementException();
		}		
		return arr[front];
	}

	@Override
	public int size() 
	{		
		return size;
	}
	
	public static class  MyException extends RuntimeException
	{
		public MyException() 
		{ 
			super(); 
		}
		
		public MyException(String msg)
		{
			super(msg);
		}
	}
	
	public Object[] unusualMethodForTestingPurposesOnly()
	{
		return arr;
	}

}
