package Assignment3;
/*
 * Andrew Chow
 * CSC 103
 * 10/30/2016
 */
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PriorityQueue<T extends Comparable<? super T>> extends Object implements SimpleQueue<T>
{
	private boolean isMax;
	private ArrayList<T> al;
	
	public PriorityQueue()
	{
		al = new ArrayList<T>();
		al.add(null);
		isMax = false;
	}
	public PriorityQueue(boolean isMax)
	{
		
		al = new ArrayList<T>();
		al.add(null);
		this.isMax = isMax;
	}
	public PriorityQueue(T[] arr,int size)
	{	
		al = new ArrayList<T>();		
		al.add(null);
		isMax = false;
		
		for(int i = 0; i < size; i++)
		{
			enqueue(arr[i]);
		}
			
		
	}
	public PriorityQueue(T[] arr,int size,boolean isMax)
	{
		al = new ArrayList<T>();
		this.isMax = isMax;
		al.add(null);
		
		for(int i = 0; i < size; i++)
		{
			enqueue(arr[i]);
		}	
	}
	@Override
	public T dequeue()
	{
		if(al.size() <= 1)
		{
			throw new NoSuchElementException();
		}
		
		T top = peek();
		
		
		T bottom = (al.remove(al.size() -1));
		
		int size = al.size() - 1;
		if(al.size() > 1)
		{
			al.set(1, bottom);	
		}
		
		if(isMax == false)
		{			
			int i = 1;
			do
			{				
				int left = 2*i;
				int right = 2*i +1;
				int minChild = i;
				//Check if has children left or right ones
				boolean rightSize = (right<=size);
				boolean leftSize = (left<=size);
				if(rightSize)
				{
					if(al.get(right).compareTo(al.get(left)) > 0)
					{
						minChild = left;
					}
					else
					{
						minChild = right;
					}
				}
				else if (leftSize)
				{
					minChild = left;
				}
				
				if(rightSize)
				{
					if(al.get(i).compareTo(al.get(minChild)) > 0)
					{
						T temp = al.get(i);
						al.set(i, al.get(minChild));
						al.set(minChild, temp);
						i = minChild;
					}
					
					else
					{
						break;
					}	
				}
				else if(leftSize)
				{
					if(al.get(i).compareTo(al.get(minChild)) > 0)
					{
						T temp = al.get(i);
						al.set(i, al.get(minChild));
						al.set(minChild, temp);
						i = minChild;
					}
					
					else
					{
						break;
					}	
				}
				else
				{	
					break;
				}
			}while(true);
		}					
		else
		{	
			int i = 1;
			do
			{			
				int left = 2*i;
				int right = 2*i +1;
				int maxChild = i;
				//Check if has children left or right ones
				boolean rightSize = (right<=size);
				boolean leftSize = (left<=size);
				if( rightSize)
				{
					if(al.get(right).compareTo(al.get(left)) < 0)
					{
						maxChild = left;
					}
					else
					{
						maxChild = right;
					}
				}
				else if (leftSize)
				{
					maxChild = left;
				}
				if(rightSize)
				{
					if(al.get(i).compareTo(al.get(maxChild)) < 0)
					{
						T temp = al.get(i);
						al.set(i, al.get(maxChild));
						al.set(maxChild, temp);
						i = maxChild;
					}
					
					else
					{
						break;
					}	
				}
				else if (leftSize)
				{
					if(al.get(i).compareTo(al.get(maxChild)) < 0)
					{
						T temp = al.get(i);
						al.set(i, al.get(maxChild));
						al.set(maxChild, temp);
						i = maxChild;
					}
					
					else
					{
						break;
					}	
				}
				else
				{
					break;
				}
			}while(true);				
		}		
		return top;
	}

	@Override
	public void enqueue(T element)
	{		
		if(isMax == false)
		{
			if(al.size() == 1)
			{
				al.add(element);
			}
			else
			{	
				al.add(element);
				int size = al.size() - 1;
				while(size != 1)
				{					
					if(al.get(size).compareTo(al.get(size/2)) < 0)
					{
						T temp = al.get(size);
						al.set(size, al.get(size/2));
						al.set(size/2, temp);
					}
					size = size/2;
				}
			}			
		}
		else if (isMax == true)
		{
			if(al.size() == 1)
			{
				al.add(element);
			}
			else
			{	
				al.add(element);
				int size = al.size() - 1;
				while(size > 1)
				{					
					if(al.get(size).compareTo(al.get(size/2)) > 0)
					{
						T temp = al.get(size);
						al.set(size, al.get(size/2));
						al.set(size/2, temp);
					}
					size = size/2;
				}
			}	
			
		}
	}

	@Override
	public T peek()
	{
		if(al.size() <= 1)
		{
			throw new NoSuchElementException();
		}
		return al.get(1);
	}

	@Override
	public int size()
	{
		if(al.size() == 0)
		{
			return al.size();
		}
		return al.size() -1;
	}
	
	public static <E extends Comparable<? super E>> void sort(E[] arr,int size)
	{
		PriorityQueue<E> pq = new PriorityQueue<E>();
		
		for(int i = 0; i < size; i++)
		{
			pq.enqueue(arr[i]);
		}
		for(int i = 0; i < size ; i++)
		{
			arr[i] = pq.dequeue();
		}
	}
	public static <E extends Comparable<? super E>> E kth(E[] arr,int size,int k)
	{	
		//min queue
		PriorityQueue<E> pq = null;
		if(k <  size - k +1)
		{
			pq = new PriorityQueue<E>();
			for(int i = 0; i < k; i++)
			{		
				pq.enqueue(arr[i]);
			}
			
			for(int j = k; j < size; j++)
			{
				if(pq.peek().compareTo(arr[j]) < 0)
				{
					pq.dequeue();
					pq.enqueue(arr[j]);
				}
				
			}
		}
		//max queue
		else
		{
			pq = new PriorityQueue<E>(true);	
			for(int i = 0; i < (size- k +1) ; i++)
			{
				pq.enqueue(arr[i]);
			}
			
			for(int j = (size-k+1); j < size; j++)
			{
				if(pq.peek().compareTo(arr[j]) > 0)
				{
					pq.dequeue();
					pq.enqueue(arr[j]);
				}
			}
			
		}
		return pq.peek();
	}	
}
