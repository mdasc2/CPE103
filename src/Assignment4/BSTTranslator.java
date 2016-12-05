
package Assignment4;
/*
* Andrew Chow
* CSC 103
* 11/9/2016
* Assignment 4
*/
public interface BSTTranslator<T extends Comparable<? super T>>
{	
	BST<T> getBST();
	String translate(String s);
}
