package Lab2;
import java.util.NoSuchElementException;

public class SimpleLinkedQueue<T> implements SimpleQueue<T> 
{
	private int size;
	private Node head;
	private Node tail;
	
	public SimpleLinkedQueue()
	{		
		size = 0;
		
		head = new Node(null);
		tail = new Node(null);		
		head.next = tail;		
	}	
	public T dequeue()
	{
		
		T holder;		
		if(size == 0)
		{
			throw new NoSuchElementException();
		}
		else if(size == 1)
		{
			holder = head.next.data;
			head.next = tail.next;
		}
		else
		{
			holder = head.next.data;
			head.next = head.next.next;
		}
		
		size--;
		
		return holder;
	}
	
	public void enqueue(T element)
	{
		Node addNode = new Node(element);
		
		if(size == 0)
		{
			head.next = addNode;
			tail = addNode;
		}
		else
		{
			tail.next = addNode;
			tail = addNode;
		}
		
		size++;
	}
	
	public T peek()
	{
		if(size == 0)
		{
			throw new NoSuchElementException();
		}
		
		return head.next.data;
	}
	
	public int size()
	{
		return size;
	}
	
	private class Node 
	{
		public T data;
	    public Node next;
	    public Node(T data)
	    {
	    	this.data = data;
	        this.next = null;
	    }
	}
	
	public static void main(String[] args)
	{
		
	}
}