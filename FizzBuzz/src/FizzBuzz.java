/**
 * 	Author: Justin VanWinkle
 *	Date: 20 December 2015
 *	Purpose: Outputs values from 1 to 100 (inclusive), but outputs "Fizz" for multiples
 *			 of 3 and "Buzz" for multiples of 5.  For values that are multiples of 3
 *			 and 5, the output is "FizzBuzz"
 *	
 *	This program was written for a coding practical for hiring consideration by Campus 
 *  Crusade for Christ International
 */

public class FizzBuzz {


	public static void main(String[] args) 
	{
		// we want to print 100 values
		for(int i=0; i<100; ++i)
		{
			// print the return from check
			System.out.println(check(i+1));
		}
	}

	private static String check(int num)
	{
		// if mult of 3 and 5, return FizzBuzz
		if(num % 3 == 0 && num % 5 == 0)
			return "FizzBuzz";
		// if mult of 3, return Fizz
		else if(num % 3 == 0)
			return "Fizz";
		// if mult of 5, return Buzz
		else if(num % 5 == 0)
			return "Buzz";
		// not a mult of 3 or 5; return num as string
		else
			return Integer.toString(num);
		
	}
	

}
