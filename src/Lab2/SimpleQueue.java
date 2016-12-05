package Lab2;
public interface SimpleQueue<T> 
{
	//Removes and returns the element at the front of this queue.
	T dequeue();
	
	//Adds the element to end of queue
	void enqueue(T element);
	
	//Returns element at front of queue
	T peek();
	
	//Returns size of queue
	int size();
}
