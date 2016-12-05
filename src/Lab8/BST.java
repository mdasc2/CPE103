package Lab8;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * Provided BST class skeleton for students to complete. This class makes use
 * of Object Oriented structural recursion to solve the problem.
 *
 * Original Revision:
 * @author Hatalsky/Jones
 * @version Lab 7
 *
 * Completed By:
 * @author Andrew Chow
 * CSC 103
 * 10/31/16
 */
public class BST<T extends Comparable<? super T>> {
   // Instance variables for BST class.
   // These are the only ones allowed!
   private final BSTNode<T> EMPTY_NODE = new EmptyNode();
   private BSTNode<T> root = EMPTY_NODE;
   private int size;

   // Polymorphic BST node type!
   private interface BSTNode<T> {
      public BSTNode<T> insert(T element);
      public boolean contains(T element);
      public BSTNode<T> remove(T element);
      public int treeHeight();
      public T minimum(T minimum);
      public T maximum(T maximum);
      public void toSortedList(List<T> list);
      public long internalPathLength(long element);
   }

   ////////////////////////////////////////////////////////////////////////////
   // BST class methods...
   //

   /**
    * Inserts an element into the BST.  If the element is already in the BST,
    * the element being inserted is discarded.
    *
    * @param element The element to insert into the BST
    *
    * @throws IllegalArgumentException if the element is null
    */
   public void insert(T element) {
      if (element == null) {
         throw new IllegalArgumentException();
      }

      root = root.insert(element);
   }
   /**
    * Removes an element from the BST.  .
    *
    * @param element The element to remove from the BST
    *
    * @throws NoSuchElement Exception when element is not in the BST
    */
   public void remove(T element)
   {
	   root = root.remove(element);
   }
   
   public int treeHeight()
   {
	   return root.treeHeight();
   }
   
   public long internalPathLength()
   {
	   if(size == 0)
	   {
		   return -1;
	   }
	   else
	   {
		   return root.internalPathLength(0);
	   }
   }

   /**
    * Determines whether or not an element is in the BST.
    *
    * @param element the element to search for in the BST
    *
    * @return true if the element is in the BST, false otherwise
    */

   public boolean contains(T element) {
      if (element == null) {
         return false;
      }

      return root.contains(element);
   }

   /**
    * Finds the minimum element in the BST.
    *
    * @return the minimum element in the BST
    *     
    * @throws NoSuchElementException if the BST is empty
    */
   public T minimum() {
      if (size == 0) {
         throw new NoSuchElementException();
      }

      return root.minimum(((Node)root).element);
   }

   /**
    * Finds the maximum element in the BST.
    *
    * @return the maximum element in the BST
    *
    * @throws NoSuchElementException if the BST is empty
    */
   public T maximum() {
      if (size == 0) {
         throw new NoSuchElementException();
      }

      return root.maximum(((Node)root).element);
   }

   /**
    * Takes the elements in the BST and places them in ascending order into the
    * list.
    *
    * @param list the list in which you will place elements
    */
   public void toSortedList(List<T> list) {
      root.toSortedList(list);
   }

   public int size() {
      return size;
   }

   ////////////////////////////////////////////////////////////////////////////
   // private EmptyNode class...
   //
   private class EmptyNode implements BSTNode<T> {
      // No instance variables needed or allowed!

      public BSTNode<T> insert(T element) {
         Node newNode = new Node(element);
         return newNode;
      }
      public BSTNode<T> remove(T element)
      {
    	  throw new NoSuchElementException();
      }
      
      public int treeHeight()
      {
    	  return -1;
      }
      public long internalPathLength(long element)
      {
    	  return 0;
      }

      public boolean contains(T element) {
         return false;
      }

      public T minimum(T element) {
         return element;
      }

      public T maximum(T element) {
         return element;
      }

      public void toSortedList(List<T> list) {
         return;
      }
   }

   ////////////////////////////////////////////////////////////////////////////
   // private Node class...
   //
   private class Node implements BSTNode<T> {
      // These are the only instance variables needed and the only ones
      // allowed!
      T element;
      BSTNode<T> left, right;
      
      public Node(T element)
      {
    	  this.element = element;
    	  left = EMPTY_NODE;
    	  right = EMPTY_NODE;
    	  size++;
      }

      // You may (and probably want to) write constructor(s)

      public BSTNode<T> insert(T element) 
      {
	      if(element.compareTo(this.element) < 0)
		  {
	    	  this.left = left.insert(element);
		  }
	    	  
	      else if (element.compareTo(this.element) > 0)
	      {
	    	  this.right = right.insert(element);
	      }
	      
	      return this;
	      
      }
      
      public BSTNode<T> remove(T element)
      {
    	  if(element.compareTo(this.element) > 0)
    	  {
    		  this.right = right.remove(element);
    	  }
    	  
    	  else if(element.compareTo(this.element) < 0)
    	  {
    		  this.left = left.remove(element);
    	  }
    	  else
    	  {   		  
    		  if(this.left == EMPTY_NODE && this.right == EMPTY_NODE)
    		  {
    			  size--;
    			  return EMPTY_NODE;
    		  }
    		  else if(this.left == EMPTY_NODE && this.right != EMPTY_NODE)
    		  {
    			  size--;
    			  return this.right;
    		  }
    		  else if(this.right == EMPTY_NODE && this.left != EMPTY_NODE)
    		  {
    			  size--;
    			  return this.left;
    		  }
    		  else
    		  {    			
    			  this.element = right.minimum(element);
    			  this.right = right.remove(this.element);
    		  }
    		  
    	  }
    	  return this;
      }
      
      public int treeHeight()
      {
    	  int max = 0, leftv, rightv;

    	  leftv = left.treeHeight();
    	  rightv = right.treeHeight();
    	  
    	  max = rightv;
    	  if(leftv >= rightv)
    	  {
    		  max = leftv;
    	  }		 
    	  return 1 + max;   	  
      }
      public long internalPathLength(long element)
      {
    	  long sum = element;
    	  
    	  sum += left.internalPathLength(element +1);
    	  sum += right.internalPathLength(element + 1);
    	      	  
    	  return sum;
      }

      public boolean contains(T element) {
    	 boolean contains = false;
         if(element.compareTo(this.element)  < 0)
         {
        	 return left.contains(element);
         }
         else if(element.compareTo(this.element) > 0)
         {
        	 return right.contains(element);
         }
         else
         {
        	 contains = true;
         }
         return contains;          	        	 
      }

      public T minimum(T element) {
    	  return left.minimum(this.element);
      }

      public T maximum(T element) {
         return right.maximum(this.element);
      }

      public void toSortedList(List<T> list) {
    	  
         left.toSortedList(list);
         list.add(this.element);
         right.toSortedList(list);
      }
   }

}



