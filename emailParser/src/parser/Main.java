/**
 * 	Author: Justin VanWinkle
 *	Date: 20 December 2015
 *	
 *	This class gets the path to the file to be parsed
 *   and calls the FileParser class to handle parsing.
 *
 *	This program was written for a coding practical for hiring consideration by Campus 
 *  Crusade for Christ International
 */

package parser;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main 
{

	public static void main(String[] args) 
	{
		FileParser fp = new FileParser(args[0]);
		try
		{
			fp.get();
		}
		catch(IOException ex)
		{
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
