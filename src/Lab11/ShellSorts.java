package Lab11;

public class ShellSorts
{
	
	public static <T extends Comparable<? super T>> void shell(T[] array)
	{
		int[] classic = {128, 64, 32, 16, 8, 4, 2, 1};
		int n = array.length;
		T temp;
		
		for(int gap : classic)
		{
			for(int i = gap; i < n; i++)
			{
				temp = array[i];				
				int j;
				
				for(j = i; j >= gap && array[j-gap].compareTo(temp) > 0 ; j -=gap)
				{
					array[j] = array[j-gap];
				}			
				array[j] = temp;
			}
		}	
	}
	
	public static <T extends Comparable<? super T>> void hibbard(T[] array)
	{
		int[] hibbard =  {255,127,63, 31, 15, 7, 3, 1} ;
		int n = array.length;
		T temp;
		
		for(int gap : hibbard)
		{
			for(int i = gap; i < n; i++)
			{
				temp = array[i];				
				int j;
				
				for(j = i; j >= gap && array[j-gap].compareTo(temp) > 0 ; j -=gap)
				{
					array[j] = array[j-gap];
				}			
				array[j] = temp;
			}
		}	
	}
	
	public static <T extends Comparable<? super T>> void sedgewick(T[] array)
	{
		int[] sedgewick=  {16577,4193,1073,281, 77, 23, 8, 1};
		int n = array.length;
		T temp;
		
		for(int gap : sedgewick)
		{
			for(int i = gap; i < n; i++)
			{
				temp = array[i];				
				int j;
				
				for(j = i; j >= gap && array[j-gap].compareTo(temp) > 0 ; j -=gap)
				{
					array[j] = array[j-gap];
				}			
				array[j] = temp;
			}
		}	
	}
	
	public static <T extends Comparable<? super T>> void heapSort(T[] array)
	{
		PriorityQueue.sort(array, array.length);
	}
}
