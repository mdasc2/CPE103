package Assignment4;
/*
 * Andrew Chow
 * CSC 103
 * 10/11/16
 */

public interface SimpleStack<T>
{
	T peek();
	T pop();
	void push(T element);
	int size();	
}
