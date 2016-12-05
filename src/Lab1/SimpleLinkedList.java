/*
 * Andrew Chow
 * Csc 103
 * 9/30/16
 */

package Lab1;
public class SimpleLinkedList<T> implements SimpleList<T>{
	
	private int size;
	private Node head;
	private Node tail;
	
	//Default Constructor
	public SimpleLinkedList()
	{
		size = 0;
		head = new Node(null);
		tail = new Node(null);
		tail.prev = head;
		head.next = tail;		
	}
	
	public void add(T element)
	{
		Node newNode = new Node(element);
		
		newNode.prev = tail.prev;
		newNode.next = tail;
		tail.prev.next = newNode;
		tail.prev = newNode;
		
		size++;
				
	}
	
	public void add(int index, T element)
	{

		if(index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException("ERROR ADD");
		}
			
		Node temp = head.next;
			
		Node addNode = new Node(element);
			
		for(int i = 0; i < index; i++)
		{
			temp = temp.next;
		}
			
		addNode.next = temp;
		addNode.prev = temp.prev;
		temp.prev.next = addNode;
		temp.prev = addNode;

		size++;

		
	}
	
	public T get(int index)
	{

		Node temp = head.next;

			if(index < 0 || index >= size)
			{
				throw new IndexOutOfBoundsException("ERROR GET");
			}		
			for(int i = 0; i < index; i++)
			{
				temp = temp.next;
			}
	
		return temp.data;
	}
	
	public T remove(int index)
	{
		Node temp = head.next;
		
			if(index < 0 || index >= size)
			{
				throw new IndexOutOfBoundsException("ERROR REMOVE");
			}
			

			for(int i = 0; i < index; i++)
			{
					temp = temp.next;
			}
			
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			temp.next = null;
			temp.prev = null;
			
			size--;	
			
			return temp.data;
	}
	
 	public int size()
 	{
 		return size;
 	}
 	
	/**
	* Node class - local to SimpleLinkedList
	*/
	private class Node 
	{
		public T data;
	    public Node next;
	    public Node prev;
	    
	    public Node(T data)
	    {
	    	this.data = data;
	        this.next = null;
	        this.prev = null;
	    }
	}

}