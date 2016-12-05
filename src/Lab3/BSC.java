package Lab3;
/*
 * Andrew Chow
 * CSC 103
 * 10/11/16
 */
public class BSC
{	
	public static boolean isBalanced(String balanceMe)
	{
		SimpleArrayStack<String> ss = new SimpleArrayStack<String>();
		String pushDat;
		
		for(int i = 0; i < balanceMe.length(); i++)
		{
			if(balanceMe.charAt(i) == '[' || balanceMe.charAt(i) =='{' || balanceMe.charAt(i) =='<' || balanceMe.charAt(i) =='(')
			{
				pushDat = Character.toString(balanceMe.charAt(i));
				ss.push(pushDat);
			}
			
			else if (balanceMe.charAt(i) == ']' || balanceMe.charAt(i) =='}' || balanceMe.charAt(i) =='>' || balanceMe.charAt(i) ==')')
			{
				if(ss.size() == 0)
				{
					return false;
				}	
				else if(balanceMe.charAt(i) == '}')				
				{
					if(ss.peek().equals( "{"))
					{
						ss.pop();
					}
					else
						return false;
				}
				else if(balanceMe.charAt(i) == ']')				
				{
					if(ss.peek().equals("["))
					{
						ss.pop();
					}
					else
						return false;
					
				}
				else if(balanceMe.charAt(i) == '>')				
				{
					if(ss.peek().equals("<"))
					{
						ss.pop();
					}
					else
						return false;
				}
				else if(balanceMe.charAt(i) == ')')				
				{
					if(ss.peek().equals("("))
					{
						ss.pop();
					}
					else
						return false;
				}
			}
		}	
		if(ss.size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
