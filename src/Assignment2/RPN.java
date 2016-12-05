/*
 * Andrew Chow
 * CSC 103
 * 10/16/16
 */
package Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class RPN
{
	
	public static double evaluateRPN(String expression)
	{	
		Scanner scan = new Scanner(expression);
		SimpleLinkedStack<Double> ss = new SimpleLinkedStack<Double>();
		double result = 0;
		double dHolder;	
		while(scan.hasNext())
		{			
			if(scan.hasNextInt())
			{
				dHolder = (double)scan.nextInt();
				ss.push(dHolder);
			}		
			else if(scan.hasNextDouble())
			{
				dHolder = scan.nextDouble();
				ss.push(dHolder);
			}
			else if(scan.hasNext())
			{	
				String temp = scan.next();
				if(temp.equals("+") )
				{
					double operand2 = ss.pop();
					double operand1 = ss.pop();
					result = operand1 + operand2;
					ss.push(result);
				}		
				else if(temp.equals("-") )
				{
					double operand2 = ss.pop();
					double operand1 = ss.pop();
					result = operand1 - operand2;
					ss.push(result);
				}
				else if(temp.equals("*") )
				{
					double operand2 = ss.pop();
					double operand1 = ss.pop();
					result = operand1 * operand2;
					ss.push(result);
				}
				else if(temp.equals("/") )
				{
					double operand2 = ss.pop();
					double operand1 = ss.pop();
					result = operand1 / operand2;
					ss.push(result);
				}								
			}
		}
		double finalresult = ss.pop();
		return finalresult;			
	}

	public static String toRPN(String infix)
	{
		Scanner scan = new Scanner(infix);
		SimpleLinkedStack<String> ss = new SimpleLinkedStack<String>();		
		String RPN = "";
		String popHolder = "";
		
		while(scan.hasNext())
		{
			if(scan.hasNextInt())
			{
				int iHolder = scan.nextInt();
				RPN = RPN.concat(iHolder + " ");
			}		
			else if(scan.hasNextDouble())
			{
				double dHolder = scan.nextDouble();
				RPN =RPN.concat(dHolder + " ");
			}
			else
			{
				String temp = scan.next();
				if(temp.equals("+") || temp.equals("-"))
				{	
					if( ss.size() == 0)
					{
						ss.push(temp);
					}
					else
					{	
						while(ss.peek().equals("+") || ss.peek().equals("-") || ss.peek().equals("*") || ss.peek().equals("/"))
							
						{			
							RPN = RPN.concat(ss.pop() + " ");
							if(ss.size() == 0)
							{
								break;
							}
						}
						ss.push(temp);
					}
				}
				else if(temp.equals("/") || temp.equals("*"))
				{
					if( ss.size() == 0)
					{
						ss.push(temp);
					}
					else
					{	
						while(ss.peek().equals("*") || ss.peek().equals("/"))							
						{			
							RPN = RPN.concat(ss.pop() + " ");
							if(ss.size() == 0)
							{
								break;
							}
						}
						ss.push(temp);
					}
				}
				else if(temp.equals("("))
				{
					ss.push(temp);
				}
				else if(temp.equals(")"))
				{
					while(!ss.peek().equals("("))
					{						
						RPN = RPN.concat(ss.pop()+ " ");
						if(ss.size() == 0)
						{
							break;
						}
					}
					ss.pop();
				}						
			}
		}		
		int size = ss.size();
		for( int i = 0 ; i < size; i++)
		{
			if(i == (size-1))
			{
				RPN = RPN.concat(ss.pop() + "");
			}
			else
			{
				RPN = RPN.concat(ss.pop() + " ");
			}
		}	
		if(Character.toString(RPN.charAt(RPN.length() -1)).equals(" "))
		{
			StringBuilder sb = new StringBuilder(RPN);
			sb.deleteCharAt(sb.length() -1);
			RPN = sb.toString();
		}
		return RPN;
	}	
	public static double evaluateInfix(String infix)
	{		
		return evaluateRPN(toRPN(infix));
	}
}
