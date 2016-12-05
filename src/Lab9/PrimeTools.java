package Lab9;
/*
* Andrew Chow
* CSC 103
* 11/5/2016
*/
public class PrimeTools
{
	public static boolean isPrime(int value)
	{
		
		for(int i = 2 ; i <= value/2; i++)
		{
			if(value % i == 0)
			{
				return false;
			}
		}	
		
		if(value == 1 || value < 0)
		{
			return false;
		}
		return true;
	}
	public static int nextPrime(int value)
	{
		
		int prime = 0;
		if (value < 0)
		{
			throw new IllegalArgumentException();
		}
		
		if(isPrime(value))
		{
			return value;
		}	
		else
		{
			if(value > Integer.MAX_VALUE/2)
			{				
				for(int i = value + 1; i <= Integer.MAX_VALUE; i++)
				{		
					if(isPrime(i))
					{			
						prime = i;
						break;
					}								
				}				
			}
			else
			{
				for(int i = value + 1; i <= value *2; i++)
				{		
					if(isPrime(i))
					{			
						prime = i;
						break;
					}								
				}
			}
		}
		
		return prime;
	}
		
}
