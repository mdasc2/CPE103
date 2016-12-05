package Assignment4;
/*
* Andrew Chow
* CSC 103
* 11/9/2016
* Assignment 4
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MorseToText implements BSTTranslator<MorseOrder>
{
	private BST<MorseOrder> bst = new BST<MorseOrder>();
	
	public MorseToText()
	{
		MorseOrder[] al = new MorseOrder[MorseCode.size()];
		MorseOrder mo;
		
		for(int i = 0; i < MorseCode.size(); i++)
		{
			mo = new MorseOrder(MorseOrder.get(i).getCharacter(), MorseOrder.get(i).getCode());	
			al[i] = mo;
		}
		
		Arrays.sort(al);				
		bstSetUp(al, 0 , MorseOrder.size());				
	}
	private void bstSetUp(MorseOrder[] co, int low, int high)
	{	
		int mid = (low + high )/2;
		bst.insert(co[mid]);
		if(mid == low || mid == high)
		{
			
		}
		else
		{
			bstSetUp(co,low,mid);
			bstSetUp(co,mid,high);
		}
	}
	@Override
	public BST<MorseOrder> getBST()
	{			
		return bst;
	}
	
	@Override
	public String translate(String s)
	{
		StringBuilder sb = new StringBuilder();
		Scanner scan = new Scanner(s).useDelimiter(" ");	
		//Iterator<MorseOrder> iter;
		
		while (scan.hasNext())
		{
			String nextString = scan.next();
			//iter = bst.iterator();
			if(nextString.equals(""))
			{
				sb.append(" ");
			}
			
			else
			{
				try
				{
					MorseOrder mo = new MorseOrder('c', nextString);
					mo = bst.get(mo);				
					sb.append(mo.getCharacter());	
				}
				
				catch (NoSuchElementException e)
				{
					
				}
				
				/*
				while(iter.hasNext())
				{
					MorseOrder mo = iter.next();
					if(mo.getCode().equals(nextString))
					{
						sb.append(mo.getCharacter());
					}		
				}
				*/
			}
		}
		scan.close();
		
		return sb.toString().trim();
	}
	
	
}
