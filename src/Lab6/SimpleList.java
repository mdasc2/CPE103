/*
 * Andrew Chow
 * Csc 103
 * 9/30/16
 */
package Lab6;
public interface SimpleList<T> {
	
	public void add(T element);
	
	public void add(int index, T element);
	
	public T get(int index);
	
	public T remove(int index);
	
 	public int size();
}
