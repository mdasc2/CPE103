package Assignment5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;


public class Huffman
{
	private StringBuilder sbToString = new StringBuilder();
	private HashMap<Character,HuffManChars> hm = new HashMap<Character,HuffManChars>();
	private PriorityQueue<HuffManChars> pq = new PriorityQueue<HuffManChars>();	
	private HuffManChars finalTree;
	
	public Huffman(String fileName)throws FileNotFoundException,IOException
	{		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		int characterHolder = 0;
		char character;
		HuffManChars hc;
		
		while((characterHolder = br.read())!= -1)
		{
			character = (char) characterHolder;					
			if(!hm.containsKey(character))
			{
				hc = new HuffManChars(character,1,character);	
				hm.put(character, hc);
			}
			else
			{
				hm.get(character).incrementFrequencies();
			}	
		}
		br.close();
		for(HuffManChars h: hm.values())
		{
			pq.add(h);
		}
			
		while(pq.size() > 1)
		{
			HuffManChars hc1 = pq.remove();
			HuffManChars hc2 = pq.remove();
			char minCharacter;
			if(hc1.minCharacter.compareTo(hc2.minCharacter) < 0)
			{
				minCharacter = hc1.minCharacter;
			}
			else
			{
				minCharacter = hc2.minCharacter;
			}		
			
			HuffManChars root = new HuffManChars(hc2.frequencies + hc1.frequencies, minCharacter);
			if(hc1.compareTo(hc2) > 0)
			{
				root.left = hc2;
				root.right = hc1;
			}			
			else
			{
				root.left = hc1;
				root.right = hc2;
			}	
			pq.add(root);
		}		
		finalTree = pq.remove();
		preOrderTraversal(finalTree);
		codeSetter(finalTree,"");					
	}
	
	public void compress(String infileName,String outfileName)throws FileNotFoundException,IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(infileName));	
		BufferedWriter bw = new BufferedWriter(new FileWriter(outfileName));
		
		int characterHolder = 0;
		char character;
		while((characterHolder = br.read())!= -1)
		{
			character = (char) characterHolder;	
			bw.write(hm.get(character).code);
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	public void decompress(String infileName,String outfileName)throws FileNotFoundException,IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(infileName));	
		BufferedWriter bw = new BufferedWriter(new FileWriter(outfileName));
		HuffManChars root = finalTree;
		HuffManChars cur = root;
		
		int characterHolder = 0;
		char character;
		
		while((characterHolder = br.read())!= -1)
		{
			character = (char) characterHolder;				
			if(character =='0')
			{
				cur = cur.left;
			}
			else if(character == '1')
			{
				cur = cur.right;
			}	
			
			if(cur.left == null && cur.right == null)
			{
				bw.write(cur.character);
				cur = root;
			}				
		}		
		br.close();
		bw.flush();
		bw.close();
	}

	public String toString()
	{	
		return "|" + sbToString.toString() + "|";
	}
	
	private void preOrderTraversal(HuffManChars hc)
	{				
		if(hc.character != null)
		{
			if(hc.left == null && hc.right == null)
			{
				sbToString.append(hc.character);
			}
		}
		
		if(hc.left != null)
		{
			preOrderTraversal(hc.left);
		}
		if(hc.right != null)
		{
			preOrderTraversal(hc.right);
		}
	}
	private void codeSetter(HuffManChars root, String code)
	{
		if(root != null)
		{
			if(!(root.left == null && root.right == null))
			{
				codeSetter(root.left,code + "0");
				codeSetter(root.right, code +"1");
			}
			else
			{
				hm.get(root.character).setCode(code);
				root.setCode(code);
			}
		}
	}
	private class HuffManChars implements Comparable
	{
		public int frequencies;
		public Character character = null;
		public String code;
		public HuffManChars left = null;
		public HuffManChars right = null;
		public Character minCharacter = (char) 0;

		public HuffManChars(int frequencies, char minCharacter)
		{
			this.frequencies = frequencies;
			this.minCharacter = minCharacter;
		}
		public HuffManChars(char character, int frequencies, char minCharacter)
		{
			this.character = character;
			this.frequencies= frequencies;
			this.minCharacter = minCharacter;
		}
		
		public void setCode(String code)
		{
			this.code = code;
		}

		public void incrementFrequencies()
		{
			frequencies++;
		}
		@Override
		public int compareTo(Object arg)
		{
			HuffManChars temp = (HuffManChars) arg;
			
			if(this.frequencies < temp.frequencies)
			{
				return -1;
			}
			else if(this.frequencies > temp.frequencies)
			{
				return 1;
			}				
			else
			{	
				if(this.minCharacter < temp.minCharacter)
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
		}						
	}
}
