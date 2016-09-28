/**
 * 	Author: Justin VanWinkle
 *	Date: 18 December 2015
 *  This class parses an entire file to a string and calls the FieldParser class
 *   to extract relevant fields from the string.
 *	
 *	This program was written for a coding practical for hiring consideration by Campus 
 *  Crusade for Christ International
 */

/**
 * @author Justin VanWinkle
 * This class parses an entire file to a string and calls the FieldParser class
 *  to extract relevant fields from the string.
 */

package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
	String filename;
	
	public FileParser (String args)
	{
		filename = args;
	}
	
	public void get() throws IOException
	{
		File file = new File(filename);
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		char c1 = 0xD;	//CR
		char c2 = 0xA;	//LF
		int lines = 0;
		
		// pull the file in as a string
		try
		{
			br = new BufferedReader(new FileReader(file));
			String text = null;
			
			// read each line
			while((text = br.readLine()) != null)
			{
				if(text.endsWith("="))
				{
					text = text.substring(0, text.length()-1);
					sb.append(text);
				}
				else
				{
					sb.append(text).append(c1).append(c2);
					++lines;
				}
			}
		} 
		catch (FileNotFoundException ex)
		{
			ex.printStackTrace();
		} 
		catch (IOException ex)
		{
			ex.printStackTrace();
		} 
		finally
		{
			try
			{
				if (br != null)
					br.close();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		String strFile = sb.toString();
		
		FieldParser fp = new FieldParser(strFile, lines);
		fp.extract();
	}
}
