package Lab9;
/*
* Andrew Chow
* CSC 103
* 11/5/2016
*/
public class BetterHash implements Hashable<String>
{
	public int hash(String s) {
	    int hash = 0;
	    int len = s.length();

	    for (int i = 0; i < len; i++) {
	       // There are 95 displayable ASCII characters, 97 is the next prime...
	       hash = hash * 97 + s.charAt(i);
	    }
	    return hash;
	 }
	 
}
