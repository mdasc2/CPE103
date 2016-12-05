/*
 * Andrew Chow
 * CSC 103
 * 11/5/2016
 */
package Lab9;

public class StringHash implements Hashable<String>
{
	public int hash(String s)
	{
		return s.hashCode();
	}
}

