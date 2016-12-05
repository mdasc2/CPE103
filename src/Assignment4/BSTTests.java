package Assignment4;
/*
* Andrew Chow
* CSC 103
* 11/9/2016
* Assignment 4
*/
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;
public class BSTTests
{

	@Test(expected = NoSuchElementException.class)
	public void test()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(8);
		bst.insert(-7);
		bst.remove(1);
	}
	@Test(expected = NoSuchElementException.class)
	public void test2()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(8);
		bst.insert(-7);
		bst.remove(4);
		bst.remove(4);
	}	
	@Test
	public void test3()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(8);
		bst.insert(-7);
		bst.remove(8);
		assertTrue(bst.maximum() == 4);
		assertTrue(bst.size() == 4);
	}
	@Test
	public void test4()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(8);
		bst.insert(-7);
		assertTrue(bst.size() == 5);
		assertTrue(bst.maximum() == 8);
	}
	@Test
	public void test5()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(8);
		bst.insert(-7);
		assertTrue(bst.maximum() == 8);
		assertTrue(bst.size() == 5);
		assertTrue(bst.treeHeight() == 3);
	}
	@Test
	public void test6()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(8);
		bst.insert(3);
		assertTrue(bst.maximum() == 8);
		assertTrue(bst.size() == 5);
		assertTrue(bst.treeHeight() == 2);
	}
	@Test
	public void test7()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(8);
		bst.insert(3);
		bst.insert(9);
		assertTrue(bst.maximum() == 9);
		assertTrue(bst.size() == 6);
		assertTrue(bst.treeHeight() == 2);		
	}
	@Test
	public void test8()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(8);
		bst.insert(3);
		bst.insert(9);
		bst.insert(10);
		assertTrue(bst.maximum() == 10);
		assertTrue(bst.size() == 7);
		assertTrue(bst.treeHeight() == 3);		
	}
	@Test
	public void test9()
	{
		BST<Integer> bst = new BST<Integer>();
		assertTrue(bst.treeHeight() == -1);	
	}
	@Test
	public void test10()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(1);
		assertTrue(bst.treeHeight() == 0);	
	}
	@Test
	public void test11()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(1);
		bst.insert(2);
		bst.insert(0);
		assertTrue(bst.treeHeight() == 1);	
	}
	@Test
	public void test12()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(1);
		bst.insert(2);
		assertTrue(bst.treeHeight() == 1);	
	}
	@Test
	public void test13()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(1);
		bst.insert(2);
		bst.insert(0);
		bst.insert(-1);
		bst.insert(-2);
		
		assertTrue(bst.internalPathLength() == 7);
		assertTrue(bst.treeHeight() == 3);	
	}
	@Test
	public void test14()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(1);
		bst.insert(2);
		bst.insert(0);
		bst.insert(3);
		bst.remove(1);
		assertTrue(bst.treeHeight() == 1);	
	}
	@Test
	public void test15()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(1);
		bst.insert(2);
		bst.insert(0);
		bst.insert(-1);
		bst.insert(-2);
		bst.insert(3);
		
		assertTrue(bst.internalPathLength() == 9);
		assertTrue(bst.treeHeight() == 3);	
	}
	@Test
	public void test16()
	{
		BST<Integer> bst = new BST<Integer>();	
		assertTrue(bst.size() == 0);
		assertTrue(bst.internalPathLength() == -1);
	}
	@Test
	public void test17()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(1);
		assertTrue(bst.internalPathLength() == 0);
	}
	@Test
	public void test18()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(1);
		bst.insert(2);
		assertTrue(bst.internalPathLength() == 1);
	}
	@Test
	public void test19()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(1);
		bst.insert(2);
		bst.insert(0);
		assertTrue(bst.internalPathLength() == 2);
		assertTrue(bst.get(0) == 0);
		assertTrue(bst.get(0) == 0);
	}	
	@Test
	public void test21()
	{
		BST<Integer> bst = new BST<Integer>();		
		
		int arr[] = {55,-33, 66, -87, 5, 7, 111, -49, -77, -3, 2, 8, -9};
		
		for(int i =0 ; i < arr.length;i++)
		{
			bst.insert(arr[i]);
		}
		//System.out.println(bst.size());
		bst.remove(55);
		assertTrue(!bst.contains(55));
		assertTrue(bst.size() == 12);
		bst.remove(-33);
		assertTrue(!bst.contains(-33));
		assertTrue(bst.size() == 11);
		bst.remove(66);
		assertTrue(!bst.contains(66));
		assertTrue(bst.size() == 10);
		bst.remove(-87);
		assertTrue(!bst.contains(-87));
		assertTrue(bst.size() == 9);
		bst.remove(111);
		assertTrue(!bst.contains(111));
		assertTrue(bst.size() == 8);
	}
	@Test
	public void test22()
	{
		BST<Integer> bst = new BST<Integer>();		
		
		bst.insert(8);
		bst.insert(6);
		bst.insert(20);
		bst.insert(4);
		bst.insert(7);
		bst.insert(5);
		Iterator<Integer> ar = bst.iterator();
		
		assertEquals(ar.next(),(Integer)4);
		assertTrue(ar.hasNext());
		assertEquals(ar.next(),(Integer)5);
		assertTrue(ar.hasNext());
		assertEquals(ar.next(),(Integer)6);
		assertTrue(ar.hasNext());
		assertEquals(ar.next(),(Integer)7);
		assertTrue(ar.hasNext());
		assertEquals(ar.next(),(Integer)8);
		assertTrue(ar.hasNext());
		assertEquals(ar.next(),(Integer)20);
		assertTrue(!ar.hasNext());
		
	}
	@Test(expected = NoSuchElementException.class)
	public void test23()
	{
		BST<Integer> bst = new BST<Integer>();		
		
		bst.insert(20);
		bst.insert(50);
		bst.insert(4);
		bst.insert(7);
		bst.insert(5);
		Iterator<Integer> ar = bst.iterator();
		
		assertEquals(ar.next(),(Integer)4);
		assertTrue(ar.hasNext());
		assertEquals(ar.next(),(Integer)5);
		assertTrue(ar.hasNext());
		assertEquals(ar.next(),(Integer)7);
		assertTrue(ar.hasNext());
		assertEquals(ar.next(),(Integer)20);
		assertTrue(ar.hasNext());
		assertEquals(ar.next(),(Integer)50);
		assertTrue(!ar.hasNext());
		assertEquals(ar.next(),(Integer)20);		
	}
	@Test(expected = UnsupportedOperationException.class)
	public void test24()
	{
		BST<Integer> bst = new BST<Integer>();		
		Iterator<Integer> ar = bst.iterator();
		ar.remove();
		
	}
	@Test()
	public void testEmpty_Node_Root()
	{
		BST<Integer> bst = new BST<Integer>();		
		Iterator<Integer> ar = bst.iterator();
		assertFalse(ar.hasNext());
		
	}
	@Test(expected = NoSuchElementException.class)
	public void testEmpty_Node_Root2()
	{
		BST<Integer> bst = new BST<Integer>();		
		Iterator<Integer> ar = bst.iterator();
		ar.next();
		
	}
		
			
	

}
