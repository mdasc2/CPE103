package Assignment4;

/*
* Andrew Chow
* CSC 103
* 11/9/2016
* Assignment 4
*/
public class CharacterOrder extends MorseCode implements Comparable<CharacterOrder>
{

	protected CharacterOrder(Character character, String code)
	{
		super(character, code);
	}
	protected CharacterOrder(CharacterOrder other)
	{
		super(other);
	}

	@Override
	public int compareTo(CharacterOrder o)
	{
		if(this.getCharacter().compareTo(o.getCharacter()) < 0)
		{
			return -1;
		}
		else if(this.getCharacter().compareTo(o.getCharacter()) > 0)
		{
			return 1;
		}
		else
		{
			return 0;
		}		
	}

}
