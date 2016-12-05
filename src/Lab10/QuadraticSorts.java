package Lab10;
/*
 * Andrew Chow
 * CSC 103
 * 11/12/2016
 */
public class QuadraticSorts
{

	public static <T extends Comparable<? super T>> void bubbleSort1(T[] array)
	{		
		boolean swapped = true;
		T temp;
		while(swapped)
		{
			swapped = false;
			for( int i = 0; i < array.length -1; i ++)
			{
				if(array[i].compareTo(array[i+1]) > 0)
				{
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					swapped = true;
				}
			}
		}
	}
	
	public static <T extends Comparable<? super T>> void bubbleSort2(T[] array)
	{
		int length = array.length;
		T temp;
		while (length != 0)
		{
			int newn = 0;
			for( int i = 0; i < array.length -1; i ++)
			{
				if(array[i].compareTo(array[i+1]) > 0)
				{
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					newn = i;
				}
			}
			length = newn;
		}
	}
	
	public static <T extends Comparable<? super T>> void selectionSort(T[] array)
	{
		int n = array.length;
		
		for(int j = 0 ; j < n -1 ; j++)
		{
			int indexMin = j;
			
			for(int i = j +1 ; i < n ; i++)
			{
				if(array[i].compareTo(array[indexMin]) < 0)
				{
					indexMin = i;
				}
			}			
			if(indexMin != j)
			{
				T temp = array[j];
				array[j] = array[indexMin];
				array[indexMin] = temp;
			}
		}
	}
	
	public static <T extends Comparable<? super T>> void insertionSort(T[] array)
	{
		
		for( int i = 1; i < array.length; i++)
		{
			int j = i;
			while(j > 0  && array[j-1].compareTo(array[j]) > 0)
			{
				T temp = array[j];
				array[j] = array[j-1];
				array[j-1] = temp;
				j = j - 1;
			}
		}
	}
}
