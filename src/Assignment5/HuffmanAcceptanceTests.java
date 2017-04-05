package Assignment5;
/**
 * JUnit test for Huffman coding.
 *
 * @author Hatalsky/Jones
 * @version 12/06/2016 Developed for CPE 103 Program 6
 */
import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import java.util.NoSuchElementException;
import java.util.*;
import org.junit.runners.MethodSorters;
import org.junit.rules.*;
import org.junit.runner.Description;
import static org.hamcrest.CoreMatchers.*;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.*;
import java.lang.annotation.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HuffmanAcceptanceTests {
   private static Huffman h;
   //private final PrintWriter console = System.console().writer();
   private static PrintWriter testSummaryFile;
   private static final long t = 1482212862000L;
   private String t1 = getClass().getName() + ".java";
   private String t2 = getClass().getName() + ".class";

   
   @Retention(RetentionPolicy.RUNTIME)
   @Target({ ElementType.TYPE, ElementType.METHOD})
   @Documented
   public @interface TestDescription {
       public String desc();
   }
   @Rule
   public TestRule watcher = new TestWatcher() {
      protected void starting(Description description) {
         //console.printf("\b\bStarting: %-60s", description.getMethodName());
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
         //console.println(s);
         testSummaryFile.println(s);
      }
      protected void succeeded(long nanos, Description description) {
         s = " Passed" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";
      }
      protected void failed(long nanos, Throwable e, Description description) {
         s = " FAILED" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";
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
   public static void cleanUp() throws IOException {
      testSummaryFile.close();
      Runtime.getRuntime().exec("rm file0_compressed.txt file0_copy.txt");
      Runtime.getRuntime().exec("rm file1_compressed.txt file1_copy.txt");
      Runtime.getRuntime().exec("rm file2_compressed.txt file2_copy.txt");
      Runtime.getRuntime().exec("rm file3_compressed.txt file3_copy.txt");
      Runtime.getRuntime().exec("rm file_War_And_Peace_compressed.txt file_War_And_Peace_copy.txt");
   }
     
   @Test(timeout=10000)
   public void test01_verifyFields() {
      Field[] fields = Huffman.class.getDeclaredFields();

      for (Field f : fields) {
         assertTrue(Modifier.isPrivate(f.getModifiers()));
      }
   }
   @Test(timeout=10000)
   public void test02_verifyMethods() {
      int countPublic = 0;
      Method[] meths = Huffman.class.getDeclaredMethods();
      for (Method m : meths) {
         if (m.isSynthetic()) { continue; }
         int mod = m.getModifiers();
         if (Modifier.isPublic(mod)) {
            countPublic++;
         } else {
            assertTrue(Modifier.isPrivate(mod));
         }
      }

      assertEquals(3, countPublic);
   }

   @Test(timeout=10000)
   public void test03_verifyInnerClass() {
      Class[] classes = Huffman.class.getDeclaredClasses();
      for (Class c : classes) {
         if (c.isSynthetic()) { continue; }
         assertTrue(Modifier.isPrivate(c.getModifiers()));
      }
   }
   @Test(timeout=10000)
   public void test04a_createHuffman_file0() throws FileNotFoundException, IOException {
      h = new Huffman("file0.txt");
      String s = h.toString();
      assertEquals("| bdca|", s);
   }
   @Test(timeout=10000)
   public void test04b_compress_file0() throws FileNotFoundException, IOException {
      h.compress("file0.txt", "file0_compressed.txt");
      Process proc = Runtime.getRuntime().exec("diff file0_compressed_solution.txt file0_compressed.txt");
      assertEquals(-1, proc.getInputStream().read());
      assertEquals(-1, proc.getErrorStream().read());
   }
   @Test(timeout=10000)
   public void test04c_decompress_file0() throws FileNotFoundException, IOException {
      h.decompress("file0_compressed.txt", "file0_copy.txt");
      Process proc = Runtime.getRuntime().exec("diff file0.txt file0_copy.txt");
      assertEquals(-1, proc.getInputStream().read());
      assertEquals(-1, proc.getErrorStream().read());
   }
   @Test(timeout=10000)
   public void test05a_createHuffman_file1() throws FileNotFoundException, IOException {
          
      h = new Huffman("file1.txt");
      String s = h.toString();
      assertEquals("| tfl.Tadnihoxw\nes|", s);
   }
   @Test(timeout=10000)
   public void test05b_compress_file1() throws FileNotFoundException, IOException {
      h.compress("file1.txt", "file1_compressed.txt");
      Process proc = Runtime.getRuntime().exec("diff file1_compressed_solution.txt file1_compressed.txt");
      assertEquals(-1, proc.getInputStream().read());
      assertEquals(-1, proc.getErrorStream().read());
   }
   @Test(timeout=10000)
   public void test05c_decompress_file1() throws FileNotFoundException, IOException {
      h.decompress("file1_compressed.txt", "file1_copy.txt");
      Process proc = Runtime.getRuntime().exec("diff file1.txt file1_copy.txt");
      assertEquals(-1, proc.getInputStream().read());
      assertEquals(-1, proc.getErrorStream().read());
   }
   @Test(timeout=1600)
   public void test06a_createHuffman_file2() throws FileNotFoundException, IOException {
          
      h = new Huffman("file2.txt");
      String s = h.toString();
      assertEquals("|\n eht|", s);
   }
   @Test(timeout=4000)
   public void test06b_compress_file2() throws FileNotFoundException, IOException {
      h.compress("file2.txt", "file2_compressed.txt");
      Process proc = Runtime.getRuntime().exec("diff file2_compressed_solution.txt file2_compressed.txt");
      assertEquals(-1, proc.getInputStream().read());
      assertEquals(-1, proc.getErrorStream().read());
   }
   @Test(timeout=4000)
   public void test06c_decompress_file2() throws FileNotFoundException, IOException {
      h.decompress("file2_compressed.txt", "file2_copy.txt");
      Process proc = Runtime.getRuntime().exec("diff file2.txt file2_copy.txt");
      assertEquals(-1, proc.getInputStream().read());
      assertEquals(-1, proc.getErrorStream().read());
   }
   @Test(timeout=10000)
   public void test07a_createHuffman_file3() throws FileNotFoundException, IOException {
          
      h = new Huffman("file3.txt");
      String s = h.toString();
      assertEquals("|\neduahfgbcmltowiykjpvrsn|", s);
   }
   @Test(timeout=10000)
   public void test07b_compress_file3() throws FileNotFoundException, IOException {
      h.compress("file3.txt", "file3_compressed.txt");
      Process proc = Runtime.getRuntime().exec("diff file3_compressed_solution.txt file3_compressed.txt");
      assertEquals(-1, proc.getInputStream().read());
      assertEquals(-1, proc.getErrorStream().read());
   }
   @Test(timeout=10000)
   public void test07c_decompress_file3() throws FileNotFoundException, IOException {
      h.decompress("file3_compressed.txt", "file3_copy.txt");
      Process proc = Runtime.getRuntime().exec("diff file3.txt file3_copy.txt");
      assertEquals(-1, proc.getInputStream().read());
      assertEquals(-1, proc.getErrorStream().read());
   }
   @Test(timeout=800)
   public void test08a_createHuffman_file_WAP() throws FileNotFoundException,
          IOException {
          
      h = new Huffman("file_War_And_Peace.txt");
      String s = h.toString();
      assertEquals("|eshinoygla\nvPSWK82L!MRftwmdcTEx-b.A'IB:97Z/0Fur\"HjCqzNp,kV;DO)(Y61GJ5*^Q}_=|{%[\\~$]&4X3U? |", s);
   }
   @Test(timeout=2400)
   public void test08b_compress_file_WAP() throws FileNotFoundException,
          IOException {
      h.compress("file_War_And_Peace.txt", "file_War_And_Peace_compressed.txt");
      Process proc = Runtime.getRuntime().exec("diff file_War_And_Peace_compressed_solution.txt file_War_And_Peace_compressed.txt");
      assertEquals(-1, proc.getInputStream().read());
      assertEquals(-1, proc.getErrorStream().read());
   }
   @Test(timeout=2800)
   public void test08c_decompress_file_WAP() throws FileNotFoundException,
          IOException {
      h.decompress("file_War_And_Peace_compressed.txt", "file_War_And_Peace_copy.txt");
      Process proc = Runtime.getRuntime().exec("diff file_War_And_Peace.txt file_War_And_Peace_copy.txt");
      assertEquals(-1, proc.getInputStream().read());
      assertEquals(-1, proc.getErrorStream().read());
   }

   @Test(timeout=10000)
   public void test09_multiple_huffmans() throws FileNotFoundException,
          IOException {
      Huffman h1 = new Huffman("file0.txt");
      Huffman h2 = new Huffman("file1.txt");
      assertEquals("| bdca|", h1.toString());
      assertEquals("| tfl.Tadnihoxw\nes|", h2.toString());
   }
} 
