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

public class TextToMorse implements BSTTranslator<CharacterOrder>
{
	private BST<CharacterOrder> bst = new BST<CharacterOrder>();	
	
	public TextToMorse()
	{	
		CharacterOrder[] al = new CharacterOrder[MorseCode.size()];
		CharacterOrder co;
		
		for(int i = 0; i < CharacterOrder.size(); i++)
		{
			co = new CharacterOrder(CharacterOrder.get(i).getCharacter(), CharacterOrder.get(i).getCode());	
			al[i] = co;
		}		
		Arrays.sort(al);
		bstSetUp(al, 0 , CharacterOrder.size());
	}
	
	private void bstSetUp(CharacterOrder[] co, int low, int high)
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
	public BST<CharacterOrder> getBST()
	{
		return bst;
	}

	@Override
	public String translate(String s)
	{
		StringBuilder sb = new StringBuilder();
		char nextChar;
		//Iterator<CharacterOrder> iter;
		for(int i = 0 ; i < s.length(); i ++)
		{
			//iter = bst.iterator();
			nextChar = s.charAt(i);
			
			if(nextChar == ' ')
			{
				sb.append(" ");
			}
			else
			{
				try
				{
					CharacterOrder co = new CharacterOrder(nextChar, " ");
					co = bst.get(co);				
					sb.append(co.getCode() + " ");	
				}
				catch (NoSuchElementException e)
				{
					
				}
								
				/*
				while(iter.hasNext())
				{
					
					//CharacterOrder co = iter.next();				
					if(nextChar == co.getCharacter())
					{
						sb.append(co.getCode() + " ");	
					}
				}
				*/				
			}
		}
		
		return sb.toString().trim();
	}
	
}
