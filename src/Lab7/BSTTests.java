package Lab7;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BSTTests
{

	@Test
	public void testContains1()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(8);
		bst.insert(-7);
		assertTrue(bst.contains(2));
	}
	@Test
	public void testContains2()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(8);
		bst.insert(-7);
		assertTrue(bst.contains(4));
	}

	@Test
	public void testContains3()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(8);
		bst.insert(-7);
		assertTrue(bst.contains(8));
	}

	@Test
	public void testContains4()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(8);
		bst.insert(-7);
		assertTrue(bst.contains(-7));
		
	}
	@Test
	public void testContains5()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(8);
		bst.insert(-7);
		assertTrue(bst.contains(-3));
		
	}
	@Test
	public void testMin()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(8);
		bst.insert(-7);
		assertTrue(bst.minimum() == -7);
		
	}
	@Test
	public void testMax()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(8);
		bst.insert(-7);
		assertTrue(bst.maximum() == 8);
		
	}
	@Test
	public void testSort()
	{
		BST<Integer> bst = new BST<Integer>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(8);
		bst.insert(-7);
		List<Integer> aw = new ArrayList<Integer>();
		Integer[] arr = {-7,-3,2,4,8};
		
		bst.toSortedList(aw);
		
		for(int i = 0; i < aw.size(); i++)
		{
			assertEquals(arr[i],aw.get(i));
		}
		
	}


}
