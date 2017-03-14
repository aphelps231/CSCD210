package intFun;

import java.util.Arrays;
import java.util.Scanner;

public class IntFun
{

	static int integerInput,
			   menuInput;
	
	static String message = "";
	
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
				System.out.println(menuFunction(menuInput));
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
		switch(selection)
		{
			case 1:
				runProgram();
				break;
			case 2: //EXTRA CREDIT
				int[] tmp = splitInteger(integerInput); System.out.println(Arrays.toString(tmp));
				
				int odds = 0, evens = 0, zeros = 0;
				
				for(int i = 0; i < tmp.length; i++)
				{
					if(tmp[i] == 0)
					{
						zeros++;
					}
					else if(tmp[i] % 2 == 1)
					{
						odds++;
					}
					else
					{
						evens++;
					}
				}
				return "Evens: " + evens + "\nOdds: " + odds + "\nZeros: " + zeros;
			case 3:
				String returnString = "";
				for(int i = 2; i < integerInput; i++)
				{
					for(int j = 2; j <= integerInput / 2; j++)
					{
						if(integerInput % j == 0)
						{
							i++;
						}
					}
					
					returnString += (i + "    ");
				}
				return returnString;
			case 4:
				int[] tmpSum = splitInteger(integerInput);
				int sum = 0;
				
				for(int i = 0; i < tmpSum.length; i++)
				{
					sum += tmpSum[i];
				}
				return "The sum of the digits in the integer are: " + sum;
			case 5:
				return "Goodbye.";
		}
		
		return "";
	}
	
	public static int[] splitInteger(int input)
	{
		int size = (int) (Math.log10(input) + 1);
		int[] returnInt = new int[size];
		
		for(int i = size - 1; i >= 0; i--)
		{
			returnInt[i] = input % 10;
			input /= 10;
		}
		
		return returnInt;
	}
	
}
