package Assignment5;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class HuffmanTests
{

	@Test
	public void testCompare () throws FileNotFoundException,IOException
	{
		String code ="000111110";
		int index = 0;
		int characterHolder = 0;
		char character;
		
		try
		{
			Huffman hm  = new Huffman("textfile.txt");
			hm.compress("textfile.txt", "textfileCompressed.txt");
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}	
		
		BufferedReader br = new BufferedReader(new FileReader("textfileCompressed.txt"));
		
		while((characterHolder = br.read())!= -1)
		{
			character = (char) characterHolder;	
			assertEquals(character, code.charAt(index));
			index++;
		}	
	}
	@Test
	public void testdeCompress () throws FileNotFoundException,IOException
	{
		//original testfile.txt string
		String code ="aaabbc";
		int index = 0;
		int characterHolder = 0;
		char character;
		
		try
		{
			Huffman hm  = new Huffman("textfile.txt");
			hm.decompress("textfileCompressed.txt", "textfileCopy.txt" );
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}			
		BufferedReader br = new BufferedReader(new FileReader("textfileCopy.txt"));
		
		while((characterHolder = br.read())!= -1)
		{
			character = (char) characterHolder;	
			System.out.print(character);
			assertEquals(character, code.charAt(index));
			index++;
		}	
	}
	@Test
	
	public void testCompare2() throws FileNotFoundException,IOException
	{
		String code ="11011011000011011010011010011";
		BufferedReader br = new BufferedReader(new FileReader("file0_compressed_solution.txt"));
		int index = 0;
		int characterHolder = 0;
		char character;
		
		try
		{
			Huffman hm  = new Huffman("file0.txt");
			hm.compress("file0.txt", "file0_compressed_solution.txt");
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}	
		
		while((characterHolder = br.read())!= -1)
		{
			character = (char) characterHolder;	
			assertEquals(character, code.charAt(index));
			index++;
		}	
	}

}
