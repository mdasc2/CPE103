package Lab9;

/*
* Andrew Chow
* CSC 103
* 11/5/2016
*/
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class HashTools
{
	
	public static <T> int collisions(List<T> list,int tableSize,Hashable<T> hashable)
	{
		int tableSize2 = PrimeTools.nextPrime(tableSize);
		int[] arr =  new int[tableSize2];
		int collisions = 0;
		Iterator<T> iter = list.iterator();
		for(int i = 0 ; i < list.size(); i++)
		{
			int hashValue = Math.abs(hashable.hash(iter.next())) % tableSize2;
			if(arr[hashValue] == 0)
			{
				arr[hashValue] = 1;
			}
			else
			{
				collisions++;
			}
		}
		return collisions;
	}
	
	public static <T> int maxCollisions(List<T> list,int tableSize,Hashable<T> hashable)
    {		
		int tableSize2 = PrimeTools.nextPrime(tableSize);
		int[] arr =  new int[tableSize2];
		int maxCollisions = 0;
		Iterator<T> iter = list.iterator();
		
		for(int i = 0 ; i < list.size(); i++)
		{
			int hashValue = Math.abs(hashable.hash(iter.next())) % tableSize2;
			arr[hashValue] = arr[hashValue] + 1;	
		}
		
		for(int i = 0; i < arr.length ; i++)
		{
			if(arr[i] > maxCollisions)
			{
				maxCollisions = arr[i];
			}
		}
		return maxCollisions;
    }
	public static <T> int unused(List<T> list,int tableSize,Hashable<T> hashable)
    {
		int tableSize2 = PrimeTools.nextPrime(tableSize);
		int[] arr =  new int[tableSize2];
		int used = 0;
		Iterator<T> iter = list.iterator();
		
		for(int i = 0 ; i < list.size(); i++)
		{
			int hashValue = Math.abs(hashable.hash(iter.next())) % tableSize2;
			if(arr[hashValue] == 0)
			{
				arr[hashValue] = 1;
				used++;
			}
		}
		return tableSize2 - used;
    }
	public static <T> double avgCollisions(List<T> list,int tableSize,Hashable<T> hashable)
    {
		int tableSize2 = PrimeTools.nextPrime(tableSize);
		double ls = list.size();
		int[] arr =  new int[tableSize2];
		Iterator<T> iter = list.iterator();
		int used = 0;
		
		for(int i = 0 ; i < list.size(); i++)
		{
			int hashValue = Math.abs(hashable.hash(iter.next())) % tableSize2;
			if(arr[hashValue] == 0)
			{
				arr[hashValue] = 1;
				used++;
			}
		}
		return ls/used;
    }
}
