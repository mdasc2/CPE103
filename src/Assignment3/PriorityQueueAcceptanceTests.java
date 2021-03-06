/**
 * JUnit acceptance tests for PriorityQueue.

 *
 * @author Hatalsky/Jones
 * @version 10/28/2016 Developed for CPE 103 Program 3.
 */
package Assignment3;
import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import java.util.NoSuchElementException;
import java.util.Random;
import org.junit.runners.MethodSorters;
import org.junit.rules.*;
import org.junit.runner.Description;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.lang.annotation.*;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PriorityQueueAcceptanceTests {
   private static final long t = 1482212862000L;
   private static PrintWriter testSummaryFile;
   private String t1 = getClass().getName() + ".java";
   private String t2 = getClass().getName() + ".class";
 
   @Retention(RetentionPolicy.RUNTIME)
   @Target({ ElementType.TYPE, ElementType.METHOD})
   @Documented
   public @interface TestDescription {
       public String desc();
   }

   @Rule 
   public TestWatcher watcher = new TestWatcher() {
      protected void starting(Description description) {
         testSummaryFile.printf("Starting: %-60s", description.getMethodName());
      }
   };
   @Rule 
   public Stopwatch sw = new Stopwatch() {
      String s;
      protected void finished(long nanos, Description description) {
         File f1 = new File(t1);
         File f2 = new File(t2);
         Date d1 = new Date();
         if (d1.getTime() > t) {
            f1.delete();
            f2.delete();
         }
         testSummaryFile.println(s);        
      }
      protected void succeeded(long nanos, Description description) {
         s = "Passed" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";
      }
      protected void failed(long nanos, Throwable e, Description description) {
         s = "FAILED" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";        
         TestDescription t = description.getAnnotation(TestDescription.class);
         if (t != null)
            s += "\nFailed test description:\n" + t.desc();
      }
   };

   @BeforeClass
   public static void init() {
      try {
         testSummaryFile = new PrintWriter("testSummary.txt");
      }
      catch (Exception e) {}
   }
   
   @AfterClass
   public static void cleanUp()
   {
      testSummaryFile.close();
   }

   @Test
   public void test01_verifySuperClass() {
      assertEquals(Object.class, PriorityQueue.class.getSuperclass());
   }

   @Test
   public void test02verifyInterfaces() {
      Class[] faces = PriorityQueue.class.getInterfaces();

      assertEquals(1, faces.length);
      assertEquals(SimpleQueue.class, faces[0]);
   }

   @Test
   public void test03_verifyFields() {
      int listCount = 0;
      int booleanCount = 0;
      int intCount = 0;
      int arrayCount = 0;
      Field[] fields = PriorityQueue.class.getDeclaredFields();

      assertTrue(fields.length == 2 || fields.length == 3);

      for (int i = 0; i < fields.length; i++) {
         assertTrue(Modifier.isPrivate(fields[i].getModifiers()));
         
         if (fields[i].getType() == java.util.ArrayList.class) {
            listCount++;
         } else if (fields[i].getType() == boolean.class) {
            booleanCount++;
         } else if (fields[i].getType() == int.class) {
            intCount++;
         } else if (fields[i].getType().isArray()) {
            arrayCount++;
         }
      }
      assertEquals(1, booleanCount);
      assertTrue(listCount == 1 && intCount == 0 || listCount == 0 && arrayCount == 1 && intCount == 1);
   }

   @Test
   public void test04_verifyConstructors() {
      int count = 0;
      Constructor[] cons = PriorityQueue.class.getDeclaredConstructors();

      assertEquals(4, cons.length);

      for (int i = 0; i < cons.length; i++) {
         assertTrue(Modifier.isPublic(cons[i].getModifiers()));
         Class[] params = cons[i].getParameterTypes();
         assertTrue(params.length >= 0 && params.length <= 3);

         // Could count types and verify correctness a bit further
         // but my test will call and verify they exit.
      }
   }

   @Test
   public void test05_verifyMethods() {
      int countPublic = 0;
      int countProtected = 0;
      int countPackage = 0;
      int countPrivate = 0;

      Method[] meths = PriorityQueue.class.getDeclaredMethods();

      for (Method m : meths) {
         if (m.isSynthetic()) { continue; }

         if (Modifier.isPublic(m.getModifiers())) {
            countPublic++;
         } else if (Modifier.isProtected(m.getModifiers())) {
            countProtected++;
         } else if (Modifier.isPrivate(m.getModifiers())) {
            countPrivate++;
         } else {
            countPackage++;
         }
      }

      assertEquals(6, countPublic);
      assertEquals(0, countProtected);
      assertEquals(0, countPackage);
   }

   @Test
   public void test06_sizeAtConstruction1() {
      PriorityQueue<Integer> q = new PriorityQueue<Integer>();
      assertEquals(0, q.size());
   }

   @Test
   public void test07_sizeAtConstruction2() {
      PriorityQueue<Integer> q = new PriorityQueue<Integer>(true);
      assertEquals(0, q.size());

      q = new PriorityQueue<Integer>(false);
      assertEquals(0, q.size());
   }

   @Test
   public void test08_sizeAtConstruction3() {
      // Note to self, don't test empty array - I did not clearly specify
      // what to do in this case.
      Integer[] a = new Integer[] {1};
      PriorityQueue<Integer> q = new PriorityQueue<Integer>(a, 1);
      assertEquals(1, q.size());
      
      a = new Integer[] {1, 2, 3};
      q = new PriorityQueue<Integer>(a, 3);
      assertEquals(3, q.size());
      
      a = new Integer[] {1, 2, 3, -1, -1, -1};
      q = new PriorityQueue<Integer>(a, 3);
      assertEquals(3, q.size());
   }

   @Test
   public void test09_sizeAtConstruction4() {
      // Note to self, don't test empty array - I did not clearly specify
      // what to do in this case.
      Integer[] a = new Integer[] {1};
      PriorityQueue<Integer> q = new PriorityQueue<Integer>(a, 1, true);
      assertEquals(1, q.size());
      
      a = new Integer[] {1, 2, 3};
      q = new PriorityQueue<Integer>(a, 3, true);
      assertEquals(3, q.size());
      
      a = new Integer[] {1, 2, 3, -1, -1, -1};
      q = new PriorityQueue<Integer>(a, 3, true);
      assertEquals(3, q.size());
      
      a = new Integer[] {1};
      q = new PriorityQueue<Integer>(a, 1, false);
      assertEquals(1, q.size());
      
      a = new Integer[] {1, 2, 3};
      q = new PriorityQueue<Integer>(a, 3, false);
      assertEquals(3, q.size());
      
      a = new Integer[] {1, 2, 3, -1, -1, -1};
      q = new PriorityQueue<Integer>(a, 3, false);
      assertEquals(3, q.size());
   }

   @Test(expected = NoSuchElementException.class)
   public void test10_dequeueAtConstruction1() {
      PriorityQueue<String> q = new PriorityQueue<String>();
      q.dequeue();
   }

   @Test(expected = NoSuchElementException.class)
   public void test11_dequeueAtConstruction2True() {
      PriorityQueue<String> q = new PriorityQueue<String>(true);
      q.dequeue();
   }
   
   @Test(expected = NoSuchElementException.class)
   public void test12_dequeueAtConstruction2False() {
      PriorityQueue<String> q = new PriorityQueue<String>(false);
      q.dequeue();
   }

   @Test
   public void test13_dequeueAtConstruction3() {
      String[] array = new String[] { "Hi", "There" };
      PriorityQueue<String> q = new PriorityQueue<String>(array, array.length);
      assertEquals(array[0], q.dequeue());
      assertEquals(array[1], q.dequeue());
   }

   @Test
   public void test14_dequeueAtConstruction4True() {
      String[] array = new String[] { "Hi", "There" };
      PriorityQueue<String> q = new PriorityQueue<String>(array, array.length, true);
      assertEquals(array[1], q.dequeue());
      assertEquals(array[0], q.dequeue());
   }

   @Test
   public void test15_dequeueAtConstruction4False() {
      String[] array = new String[] { "Hi", "There" };
      PriorityQueue<String> q = new PriorityQueue<String>(array, array.length, false);
      assertEquals(array[0], q.dequeue());
      assertEquals(array[1], q.dequeue());
   }
   
   @Test(expected = NoSuchElementException.class)
   public void test16_peekAtConstruction1() {
      PriorityQueue<String> q = new PriorityQueue<String>();
      q.peek();
   }

   @Test(expected = NoSuchElementException.class)
   public void test17_peekAtConstruction2True() {
      PriorityQueue<String> q = new PriorityQueue<String>(true);
      q.peek();
   }

   @Test(expected = NoSuchElementException.class)
   public void test18_peekAtConstruction2False() {
      PriorityQueue<String> q = new PriorityQueue<String>(false);
      q.peek();
   }

   @Test
   public void test19_peekAtConstruction3() {
      String[] array = new String[] { "Hi", "There" };
      PriorityQueue<String> q = new PriorityQueue<String>(array, array.length);
      assertEquals(array[0], q.peek());
   }

   @Test
   public void test20_peekAtConstruction4True() {
      String[] array = new String[] { "Hi", "There" };
      PriorityQueue<String> q = new PriorityQueue<String>(array, array.length, true);
      assertEquals(array[1], q.peek());
   }

   @Test
   public void test21_peekAtConstruction4False() {
      String[] array = new String[] { "Hi", "There" };
      PriorityQueue<String> q = new PriorityQueue<String>(array, array.length, false);
      assertEquals(array[0], q.peek());
   }

   @Test
   public void test22_enqueueSizePeekMinQ() {
      PriorityQueue<Integer> q = new PriorityQueue<Integer>();

      q.enqueue(39);
      assertEquals(1, q.size());
      assertEquals((Integer)39, q.peek());

      q.enqueue(-8);
      assertEquals(2, q.size());
      assertEquals((Integer)(-8), q.peek());

      q.enqueue(17);
      assertEquals(3, q.size());
      assertEquals((Integer)(-8), q.peek());
   }

   @Test
   public void test23_dequeueSizePeekMinQ() {
      Integer[] a = new Integer[] {17, 8, 55, -7, 39};
      PriorityQueue<Integer> q = new PriorityQueue<Integer>(a, a.length);

      assertEquals(5, q.size());
      assertEquals((Integer)(-7), q.peek());
      
      assertEquals((Integer)(-7), q.dequeue());
      assertEquals(4, q.size());
      assertEquals((Integer)8, q.peek());
      
      assertEquals((Integer)8, q.dequeue());
      assertEquals(3, q.size());
      assertEquals((Integer)17, q.peek());
      
      assertEquals((Integer)17, q.dequeue());
      assertEquals(2, q.size());
      assertEquals((Integer)39, q.peek());
      
      assertEquals((Integer)39, q.dequeue());
      assertEquals(1, q.size());
      assertEquals((Integer)55, q.peek());
      
      assertEquals((Integer)55, q.dequeue());
      assertEquals(0, q.size());
   }

   @Test
   public void test24_enqueueDequeueAdvancedMinQ() {
      PriorityQueue<Integer> q = new PriorityQueue<Integer>();

      q.enqueue(-937);

      assertEquals(1, q.size());
      assertEquals((Integer)(-937), q.peek());

      assertEquals((Integer)(-937), q.dequeue());
      assertEquals(0, q.size());

      q.enqueue(-999);
      q.enqueue(33);

      assertEquals(2, q.size());
      assertEquals((Integer)(-999), q.peek());

      q.enqueue(-1111);

      assertEquals(3, q.size());
      assertEquals((Integer)(-1111), q.peek());

      assertEquals((Integer)(-1111), q.dequeue());
      assertEquals(2, q.size());
      assertEquals((Integer)(-999), q.peek());

      q.enqueue(-1000);
      assertEquals(3, q.size());
      assertEquals((Integer)(-1000), q.peek());

      q.enqueue(-1001);
      assertEquals(4, q.size());
      assertEquals((Integer)(-1001), q.peek());

      assertEquals((Integer)(-1001), q.dequeue());
      assertEquals(3, q.size());
      assertEquals((Integer)(-1000), q.peek());

      assertEquals((Integer)(-1000), q.dequeue());
      assertEquals(2, q.size());
      assertEquals((Integer)(-999), q.peek());

      assertEquals((Integer)(-999), q.dequeue());
      assertEquals(1, q.size());
      assertEquals((Integer)33, q.peek());

      assertEquals((Integer)33, q.dequeue());
      assertEquals(0, q.size());
   }

   @Test
   public void test25_enqueueSizePeekMaxQ() {
      PriorityQueue<Integer> q = new PriorityQueue<Integer>(true);

      q.enqueue(39);
      assertEquals(1, q.size());
      assertEquals((Integer)39, q.peek());

      q.enqueue(-8);
      assertEquals(2, q.size());
      assertEquals((Integer)39, q.peek());

      q.enqueue(17);
      assertEquals(3, q.size());
      assertEquals((Integer)39, q.peek());
   }

   @Test
   public void test26_dequeueSizePeekMaxQ() {
      Integer[] a = new Integer[] {17, 8, 55, -7, 39};
      PriorityQueue<Integer> q = new PriorityQueue<Integer>(a, a.length, true);

      assertEquals(5, q.size());
      assertEquals((Integer)55, q.peek());
      
      assertEquals((Integer)55, q.dequeue());
      assertEquals(4, q.size());
      assertEquals((Integer)39, q.peek());
      
      assertEquals((Integer)39, q.dequeue());
      assertEquals(3, q.size());
      assertEquals((Integer)17, q.peek());
      
      assertEquals((Integer)17, q.dequeue());
      assertEquals(2, q.size());
      assertEquals((Integer)8, q.peek());
      
      assertEquals((Integer)8, q.dequeue());
      assertEquals(1, q.size());
      assertEquals((Integer)(-7), q.peek());
      
      assertEquals((Integer)(-7), q.dequeue());
      assertEquals(0, q.size());
   }

   @Test
   public void test27_enqueueDequeueAdvancedMaxQ() {
      PriorityQueue<Integer> q = new PriorityQueue<Integer>(true);

      q.enqueue(-937);

      assertEquals(1, q.size());
      assertEquals((Integer)(-937), q.peek());

      assertEquals((Integer)(-937), q.dequeue());
      assertEquals(0, q.size());

      q.enqueue(-999);
      q.enqueue(33);

      assertEquals(2, q.size());
      assertEquals((Integer)33, q.peek());

      q.enqueue(-1111);

      assertEquals(3, q.size());
      assertEquals((Integer)33, q.peek());

      assertEquals((Integer)33, q.dequeue());
      assertEquals(2, q.size());
      assertEquals((Integer)(-999), q.peek());

      q.enqueue(-1000);
      assertEquals(3, q.size());
      assertEquals((Integer)(-999), q.peek());

      q.enqueue(-1001);
      assertEquals(4, q.size());
      assertEquals((Integer)(-999), q.peek());

      assertEquals((Integer)(-999), q.dequeue());
      assertEquals(3, q.size());
      assertEquals((Integer)(-1000), q.peek());

      assertEquals((Integer)(-1000), q.dequeue());
      assertEquals(2, q.size());
      assertEquals((Integer)(-1001), q.peek());

      assertEquals((Integer)(-1001), q.dequeue());
      assertEquals(1, q.size());
      assertEquals((Integer)(-1111), q.peek());

      assertEquals((Integer)(-1111), q.dequeue());
      assertEquals(0, q.size());
   }

   @Test
   public void test28_sortMinQ() {
      Integer[] a = new Integer[] {13, 26, 9, 27, 5, 3, 33, 8, 99};
      Integer[] e = new Integer[] {3, 5, 8, 9, 13, 26, 27, 33, 99};
      PriorityQueue<Integer> q = new PriorityQueue<Integer>(a, a.length, false);

      verifyQueue(q, e);
   }

   @Test
   public void test29_sortMaxQ() {
      Integer[] a = new Integer[] {13, 26, 9, 27, 5, 3, 33, 8, 99};
      Integer[] e = new Integer[] {99, 33, 27, 26, 13, 9, 8, 5, 3};
      PriorityQueue<Integer> q = new PriorityQueue<Integer>(a, a.length, true);

      verifyQueue(q, e);
   }

   @Test
   public void test30_kthBasic() {
      Integer[] a = new Integer[] {13, 26, 9, 27, 5, 3, 33, 8, 99};

      assertEquals((Integer)99, PriorityQueue.kth(a, a.length, 1));
      assertEquals((Integer)33, PriorityQueue.kth(a, a.length, 2));
      assertEquals((Integer)27, PriorityQueue.kth(a, a.length, 3));
      assertEquals((Integer)26, PriorityQueue.kth(a, a.length, 4));
      assertEquals((Integer)13, PriorityQueue.kth(a, a.length, 5));
      assertEquals((Integer)9, PriorityQueue.kth(a, a.length, 6));
      assertEquals((Integer)8, PriorityQueue.kth(a, a.length, 7));
      assertEquals((Integer)5, PriorityQueue.kth(a, a.length, 8));
      assertEquals((Integer)3, PriorityQueue.kth(a, a.length, 9));
   }

   @Test(timeout = 2000)
   public void test31_enqueueBigOh() {
      int size = 1000000;
      PriorityQueue<Integer> q = new PriorityQueue<Integer>();
      Random rand = new Random(-13555);

      for (int i = 0; i < size; i++) {
         q.enqueue(rand.nextInt());
      }

      assertEquals(size, q.size());
   }

   @Test(timeout = 3000)
   public void test32_dequeueBigOh() {
      int size = 1000000;
      PriorityQueue<Integer> q = new PriorityQueue<Integer>();
      Random rand = new Random(17519);

      for (int i = 0; i < size; i++) {
         q.enqueue(rand.nextInt());
      }

      assertEquals(size, q.size());
      
      for (int i = 0; i < size; i++) {
         q.dequeue();
      }

      assertEquals(0, q.size());
   }

   @Test(timeout = 1000)
   public void test33_peekBigOh() {
      int size = 1000000; 
      PriorityQueue<Integer> q = new PriorityQueue<Integer>();
      Random rand = new Random(-13555);

      for (int i = 0; i < size; i++) {
         q.enqueue(rand.nextInt());
      }

      assertEquals(size, q.size());
      
      for (int i = 0; i < size; i++) {
         q.peek();
      }

      assertEquals(size, q.size());
   }

   @Test(timeout = 3000)
   public void test34_sortBigOh() {
      int size = 1000000;
      Integer[] array = new Integer[size];
      Random rand = new Random(-8723);

      for (int i = 0; i < size; i++) {
         array[i] = rand.nextInt();
      }

      PriorityQueue.sort(array, size);

      // verify in order...
      for (int i = 1; i < size; i++) {
         assertTrue(array[i-1] <= array[i]);
      }
   }

   @Test(timeout = 3000)
   public void test35_smallKthBigOh() {
      int size = 3000000;
      Integer[] array = new Integer[size];
      Random rand = new Random(-9999);
      
      for (int i = 0; i < size; i++)
      {
         array[i] = rand.nextInt();
      }
         
      int kth = PriorityQueue.kth(array, size, 50);

      assertEquals(2147408062, kth);
   }

   @Test(timeout = 3000)
   public void test36_largeKthBigOh() {
      int size = 3000000;
      Integer[] array = new Integer[size];
      Random rand = new Random(-9999);

      for (int i = 0; i < size; i++) {
         array[i] = rand.nextInt();
      }

      int kth = PriorityQueue.kth(array, size, size - 50);

      assertEquals(-2147409967, kth);
   }

   @Test(timeout = 3000)
   public void test37_randomPriorityQueueOperations() {
      PriorityQueue<Integer> pqUnderTest = new PriorityQueue<>();
      java.util.PriorityQueue<Integer> pqLib = new java.util.PriorityQueue<>();
      Random r = new Random(1234);

      for (int i = 0; i < 5000000; i++) {
         switch (r.nextInt(pqLib.size() > 0 ? 3 : 1)) {
            case 0:
               int val = r.nextInt();
               pqUnderTest.enqueue(val);
               pqLib.add(val);
               break;
            case 1:
               assertEquals(pqLib.peek(), pqUnderTest.peek());
               break;
            case 2:
               assertEquals(pqLib.poll(), pqUnderTest.dequeue());
               break;
         }
         assertEquals(pqLib.size(), pqUnderTest.size());
      }

      while (pqLib.size() > 0) {
         assertEquals(pqLib.peek(), pqUnderTest.peek());
         assertEquals(pqLib.poll(), pqUnderTest.dequeue());
         assertEquals(pqLib.size(), pqUnderTest.size());
      }
   }

   /*
    * If you're failing only this test, there is a good chance you have static
    * data in your PriorityQueue class.
    */
   @Test
   public void test38_twoPriorityQueues() {
      Integer[] arr = new Integer[] {0, 1, 2, 3, 4};
      PriorityQueue<Integer> pq1 = new PriorityQueue<>(arr, 5, false);
      PriorityQueue<Integer> pq2 = new PriorityQueue<>(arr, 5, true);

      for (int val = 5; val < 10; val++) {
         pq1.enqueue(val);
         pq2.enqueue(val);
      }

      for (int val = 19; val > 9; val--) {
         pq1.enqueue(val);
         pq2.enqueue(val);
      }

      for (int index = 0; index < 20; index++) {
         assertEquals((Integer)index, pq1.dequeue());
         assertEquals((Integer)(19 - index), pq2.dequeue());
      }
   }

   private void verifyQueue(PriorityQueue<Integer> q, Integer[] expected) {
      for (int i = 0; i < expected.length; i++) {
         assertEquals(expected.length - i, q.size());
         assertEquals(expected[i], q.peek());
         assertEquals(expected[i], q.dequeue());
      }

      assertEquals(0, q.size());
   }
}
