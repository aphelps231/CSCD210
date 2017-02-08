package intFun;

import java.util.Scanner;

public class IntFun
{

	static int integerInput,
			   menuInput;
	
	public static void main(String[] args)
	{
		runProgram();
	}
	
	public static void runProgram()
	{
		System.out.print("Welcome to Integer Fun.\nPlease enter a non-negative integer: ");
		
		if(!gatherInput(false))
		{
			System.out.println("I am sorry, input is invalid.");
			
			runProgram();
		}
		else
		{
			menuChoice();
			if(!gatherInput(true))
			{
				System.out.println("I am sorry, input is invalid.");
			}
			else
			{
				
			}
		}
	}
	
	public static boolean gatherInput(boolean integerInputOverride)
	{
		int input;
		
		Scanner kb = new Scanner(System.in);
		
		input = kb.nextInt();
		
		if(input < 0)
		{
			return false;
		}
		else
		{
			if(!integerInputOverride)
			{
				integerInput = input;
			}
			else
			{
				if(input > 5)
				{
					return false;
				}
				
				menuInput = input;
			}
			
			return true;
		}
	}
	
	public static void menuChoice()
	{
		System.out.println("Please pick from one of the following choices:\n1. Enter a new number\n2. Print the number of odd, even, and zeros in the integer\n3. Print the prime numbers between 2 and the integer\n4. Print the sum of the digits in the integer\n5. Quit the program");
	}
	
	public static String menuFunction(int selection)
	{
		return "";
	}
	
}
