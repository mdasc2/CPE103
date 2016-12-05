package Lab12;
/**
 * Provided starting point for Java-based tsort.
 *
 * @author Hatalsky/Jones - Starting point.
 * @author ? - Completed by.
 *
 * @version CPE 103 Lab 12
 */
import java.io.*;
import java.util.*;

public class TSort {
   // Hides the constructor form javadoc utility and users.
   private TSort() {}

   /**
    * Performs a topological sort of the specified directed acyclic graph.  The
    * graph is given as a string containing pairs of vertices representing
    * edges separated by spaces.  The resulting string will be formatted
    * identically to the Unix utility {@code tsort}.  That is, one vertex per
    * line in topologically sorted order.
    *
    * @param edges the edges of the DAG specified as space separated
    * vertex-pairs
    *
    * @return a topological ordering for the specified DAG
    *
    * @throws IllegalArgumentException if:
    * <ul>
    *   <li>edges is emtpy with the message "input contains no edges"</li>
    *   <li>edges has an odd number of vertices (incomplete pair) with the
    *   message "input contains an odd number of tokens"</li>
    *   <li>the graph contains a cycle (isn't acyclic) with the message "input
    *   contains a loop"</li>
    * </ul>
    */
   public static String tsort(String edges) {
	   HashMap<String, Vertexes> hm = new HashMap<String, Vertexes>();
	   ArrayList<String> orderHolder = new ArrayList<String>();
	   
	   checkIllegalArgument(edges);
	   
	   setUpAdjacentcyTable(edges,orderHolder,hm);
	   
	   return processAdjacentcyList(orderHolder,hm);	   	        
   }

   /**
    * Entry point for the Java-based tsort utility allowing the user to specify
    * a file, redirect a file, or specify the input manually followed by
    * cntl-d to signal the end of input.
    */
   public static void main(String[] args) {
      Scanner scanner = null;

      if (args.length == 0) {
         scanner = new Scanner(System.in);
      } else if (args.length == 1) {
         try {
            scanner = new Scanner(new File(args[0]));
         } catch(FileNotFoundException e) {
            System.out.format("TSort: %s: No such file or directory\n", args[0]);
            System.exit(1);
         }
      } else {
         System.out.format("TSort: extra operand `%s'\n", args[1]);
         System.exit(1);
      }

      StringBuilder input = new StringBuilder();

      while (scanner.hasNext()) {
         input.append(scanner.next() + " ");
      }

      scanner.close();

      try {
         System.out.print(tsort(input.toString()));
      } catch(IllegalArgumentException e) {
         System.out.println("TSort: " + e.getMessage());
         System.exit(1);
      }
   }
   private static class Vertexes
   {
   	   public String vertex;
   	   private ArrayList<String> adjacentcy = new ArrayList<String>();
   	   private int indegrees = 0;
   	   
   	   public Vertexes(String vertex)
   	   {
   		   this.vertex = vertex;
   	   }
   	   public Vertexes(String vertex, String adjacent)
   	   {
   		   this.vertex = vertex;
   		   this.adjacentcy.add(adjacent);
   	   }
   	   
   	   public void increIndegree()
   	   {
   		   this.indegrees++;
   	   }
   	   
   	   public void decreIndegree()
	   {
		   this.indegrees--;
	   }
   	   
   	   public int getIndegree()  
   	   {
   		   return indegrees;
   	   }
   	   
   	   public void addAdjacentcy(String adjacent)
   	   {
   		   if(!adjacentcy.contains(adjacent))
   		   {
   			    adjacentcy.add(adjacent);
   		   }
   	   }
   	   public ArrayList<String> getAdjacentcyList()
	   {
		   return adjacentcy;
	   }
   }
   
   /*
    * Check for IllegalArguments in the string passed in
    */
   private static void checkIllegalArgument(String edges)
   {
	   int vertexCount = 0;
	   Scanner scan = new Scanner(edges);
	   
	   if(!edges.contains(" "))
	   {
		   scan.close();
		   throw new IllegalArgumentException();
	   }	   
	   while(scan.hasNext())
	   {
		   scan.next();
		   vertexCount++;		   
	   }	   
	   if(vertexCount % 2 == 1 || vertexCount == 0)
	   {
		   scan.close();
		   throw new IllegalArgumentException();
	   }   
	   scan.close();
   }
   
   /*
    * Sets up an AdjacentcyTable that keeps track of which vertexes have paths to other vertexes, uses a
    * hashmap to hold the vertexes and a ArrayList to hold the order in which the vertexes are listed
    */
   private static void setUpAdjacentcyTable(String edges, ArrayList<String> orderHolder, HashMap<String, Vertexes> hm)
   {
	   Scanner scan = new Scanner(edges);
	   String v1,v2;
	   while(scan.hasNext())
	   {
		   v1 = scan.next();		
		   v2 = scan.next();
		   
		   if(hm.containsKey(v1) && hm.containsKey(v2))	
		   {	   
			   hm.get(v1).addAdjacentcy(v2);
			   hm.get(v2).increIndegree();	
		   }		   
		   else if(!hm.containsKey(v1) && hm.containsKey(v2))
		   {
			   Vertexes vert = new Vertexes(v1);
			   vert.addAdjacentcy(v2);
			   hm.put(v1, vert);
			   hm.get(v2).increIndegree();	
		   }		   
		   else if(hm.containsKey(v1) && !hm.containsKey(v2))
		   {
			   hm.get(v1).addAdjacentcy(v2);
			   Vertexes vert = new Vertexes(v2);
			   vert.increIndegree();
			   hm.put(v2, vert);
		   }
		   else
		   {
			   Vertexes vert1 = new Vertexes(v1,v2);
			   vert1.addAdjacentcy(v2);
			   hm.put(v1, vert1);
			   
			   Vertexes vert2 = new Vertexes(v2);
			   vert2.increIndegree();
			   hm.put(v2, vert2);
		   }
		   if(!orderHolder.contains(v1))
		   {
			   orderHolder.add(v1);
		   }
		   if(!orderHolder.contains(v2))
		   {
			   orderHolder.add(v2);	
		   }
	   }
	   scan.close();
   }
   /*
    * Builds the StringBuilder to output vertexes in the correct order. Also checks for cycles
    */
   
   private static String processAdjacentcyList(ArrayList<String> orderHolder, HashMap<String, Vertexes> hm)
   {
	   Stack <Vertexes> stack = new Stack<Vertexes>();
	   StringBuilder sb = new StringBuilder();
	   ArrayList<String> removedOnes = new ArrayList<String>();
	   
	   for(String s: orderHolder)
	   {
		   Vertexes v = hm.get(s);
		   
		   if(v.getIndegree() == 0)
		   {
			   stack.push(v);
			   removedOnes.add(v.vertex);
		   }
	   }   
	   for(String s: removedOnes)
	   {
		   hm.remove(s);
		   orderHolder.remove(s);
	   }
	   while(!stack.isEmpty())
	   {
		   removedOnes.clear();
		   Vertexes holder = stack.pop();
		   ArrayList<String> as = holder.getAdjacentcyList();	   
		   for(String s: as)
		   {
			   hm.get(s).decreIndegree();
		   }	   
		   for(String s: orderHolder)
		   {
			   Vertexes v = hm.get(s);
			   
			   if(v.getIndegree() == 0)
			   {
				   stack.push(v);
				   removedOnes.add(v.vertex);
			   }
		   }	   
		   for(String s: removedOnes)
		   {
			   hm.remove(s);
			   orderHolder.remove(s);
		   }	   
		   sb.append(holder.vertex + "\n");
	   }   
	   if(!hm.isEmpty())
	   {
		   throw new IllegalArgumentException();
	   }	    	   
	   return sb.toString();  
   }
}


