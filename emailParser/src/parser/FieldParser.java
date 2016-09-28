/**
 * 	Author: Justin VanWinkle
 *	Date: 20 December 2015
 *	
 * This class parses out relevant fields from a string object that is passed in.
 *  Once parsed, the fields are reconstructed and output to the file output.html
 *  Additionally, the To, From, Subject, and Date fields are output to console.
 *  
 *	This program was written for a coding practical for hiring consideration by Campus 
 *  Crusade for Christ International
 */

package parser;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FieldParser {
	
	String strFile;
	int lines;
	private String strTo;
	private String strFrom;
	private String strSubject;
	private String strDate;
	
	public FieldParser (String strFile, int lines)
	{
		this.strFile = strFile;
		this.lines = lines;
	}
	
	public void extract() throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter("output.html");
		char c1 = 0xD;	//CR	
		char c2 = 0xA;	//LF
		boolean bTo = false;
		boolean bFrom = false;
		boolean bSubject = false;
		boolean bDate = false;
		
		// split string at every CRLF
		// use "[\\r\\n]+" for regex to exclude blank lines
		String strArray[] = strFile.split("\\r?\\n");
		
		// search for lines with match to regex using top down approach
		// raise flag once collected
		for(int i=0; i<strArray.length; ++i)
		{	
			// get to field
			if (strArray[i].matches("To: (.*)>") && !bTo)
			{
				strTo = strArray[i];
				bTo = true;
				System.out.println(strTo);
			}
			//get from field
			else if (strArray[i].matches("From: (.*)>") && !bFrom)
			{
				strFrom = strArray[i];
				bFrom = true;
				System.out.println(strFrom);
			}	
			// get subject field
			else if(strArray[i].matches("Subject: (.*)") && !bSubject)
			{
				strSubject = strArray[i];
				bSubject = true;
				System.out.println(strSubject);
			}
			// get date field
			else if(strArray[i].matches("Date: (.*)") && !bDate)
			{
				strDate = strArray[i];
				bDate = true;
				System.out.println(strDate);
			}
			// get message content
			// if "<html>" tag found, start outputting message body
			else if(strArray[i].matches("<html>"))
			{
				for(int j=i; j<strArray.length; ++j)
				{
					pw.write(strArray[j] + c1 + c2);
					if(strArray[j].matches("<body(.*)>"))
					{
						pw.write("<p>");
						pw.write(strTo + c1 + c2 + "<br>");
						pw.write(strFrom + c1 + c2 + "<br>");
						pw.write(strDate + c1 + c2 + "<br>");
						pw.write(strSubject + c1 + c2 + "<br>");
						pw.write("</p>" + c1 + c2);
					}	
					if(strArray[j].matches("</html>"))
						break;
				}
			}
		}
		pw.close();
	}
}
