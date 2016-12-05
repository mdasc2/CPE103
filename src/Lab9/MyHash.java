package Lab9;
/*
* Andrew Chow
* CSC 103
* 11/5/2016
*/
public class MyHash implements Hashable<String>
{
	public int hash(String s) {
	    int hash = 0;
	    int len = s.length();

	    for (int i = 0; i < len; i++) {
	       hash = hash * 29 + (s.charAt(i) -64);
	    }
	    return hash;
	 }
}
