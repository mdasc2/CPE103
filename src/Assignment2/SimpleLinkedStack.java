package Assignment2;

/*
 * Andrew Chow
 * CSC 103
 * 10/16/16
 */
import java.util.NoSuchElementException;

public class SimpleLinkedStack<T> implements SimpleStack<T>
{
	private Node top;
	private int size;
	
	public SimpleLinkedStack()	
	{
		top = null;
		size = 0;
	}
		
	@Override
	public T peek()
	{
		if (size == 0)
		{
			throw new NoSuchElementException();
		}
		return top.data;
	}

	@Override
	public T pop()
	{
		if (size == 0)
		{
			throw new NoSuchElementException();
		}
		
		T holder = top.data;
		top = top.next;
		size--;		
		return holder;
	}

	@Override
	public void push(T element)
	{	
		Node newNode = new Node(element);
		
		if( size == 0)
		{			
			top = newNode;
		}
		else
		{
			newNode.next = top;
			top = newNode;
		}
		size++;
		
	}

	@Override
	public int size()
	{
		return size;
	}
	
	private class Node 
	{
		public T data = null;
	    public Node next = null;
	    public Node(T data)
	    {
	    	this.data = data;
	    }
	}

}
