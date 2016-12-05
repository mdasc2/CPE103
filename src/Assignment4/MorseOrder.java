package Assignment4;
/*
* Andrew Chow
* CSC 103
* 11/9/2016
* Assignment 4
*/
public class MorseOrder extends MorseCode implements Comparable<MorseOrder>
{

	protected MorseOrder(Character character, String code)
	{
		super(character, code);
	}
	protected MorseOrder(MorseOrder other)
	{
		super(other);
	}

	@Override
	public int compareTo(MorseOrder arg)
	{
		if(this.getCode().compareTo(arg.getCode()) < 0)
		{
			return -1;
		}
		else if(this.getCode().compareTo(arg.getCode()) > 0)
		{
			return 1;
		}
		else
		{
			return 0;
		}	
	}

}
