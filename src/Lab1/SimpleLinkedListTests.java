
/*
 * J unit tests. Originally by Brian Jones
 * Modified by Andrew Chow
 * Csc 103
 * 9/30/16
 */
package Lab1;
import org.junit.*;
import static org.junit.Assert.*;

public class SimpleLinkedListTests {
   @Test
   public void testSize_empty() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      assertTrue(list.size() == 0);
   }
   
   @Test(expected=IndexOutOfBoundsException.class)
   public void testAdd_atConstuctionOutOfBounds() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(25, null);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testRemove_atConstruction() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.remove(0);
   }
   
   @Test(expected=IndexOutOfBoundsException.class)
   public void testRemove_OutofBounds() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.remove(25);
   }

   @Test
   public void testAddSize() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();

      list.add(5);
      list.add(10);
      list.add(15);
      list.add(20);
      assertTrue(listEquals(list, new int[] {5, 10, 15, 20}));
      assertTrue(list.size() == 4);
   }

   private boolean listEquals(SimpleLinkedList<Integer> list, int[] a) {
      if (list.size() != a.length) {
         return false;
      }

      for (int i = 0; i < a.length; i++) {
         if (list.get(i) != a[i]) {
            return false;
         }
      }

      return true;
   }
   
   @Test
   public void testAddMiddle() {
	   SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
	   
	      list.add(5);
	      list.add(10);
	      list.add(20);
	      list.add(25);
	      
	      list.add(2, 15);
	      //assertTrue(list.get(2) == 15);
	      assertTrue(listEquals(list, new int[] {5, 10, 15, 20, 25}));
	      assertTrue(list.size() == 5);
   }
   
   @Test
   public void testAddtoFront() {
	   SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
	   
	      list.add(10);
	      list.add(15);
	      list.add(20);
	      list.add(25);
	      
	      list.add(0, 5);
	      assertTrue(list.get(0) == 5);
   }
   @Test
   public void testAddtoBack() {
	   SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
	   
	      list.add(10);
	      list.add(15);
	      list.add(20);
	      list.add(25);
	      
	      list.add(4, 5);
	      assertTrue(list.get(4) == 5);
   }
   
   @Test
   public void testAddIndexWhenEmpty()  {
	   SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
	   
	   list.add(0, null);
	   
	   assertTrue(list.get(0) == null);
   }
   
   @Test
   public void testRemoveAll(){
	   SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
	   list.add(5);
	   list.add(10);
	   list.add(15);
	   list.add(20);
	   list.add(25);
	   int holder = list.size();
	   
	   for(int i = 0; i < holder; i++) {
		   list.remove(0);	   
	   }
	   assertTrue(list.size() == 0);
	   
   }
   @Test(expected=IndexOutOfBoundsException.class)
   public void testRemoveAllPlusOne(){
	   SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
	   list.add(5);
	   list.add(10);
	   list.add(15);
	   list.add(20);
	   list.add(25);
	   int holder = list.size();
	   
	   for(int i = 0; i < holder+1; i++) {
		   list.remove(0);	   
	   }
	   assertTrue(list.size() == 0);
	   
   }
   

}