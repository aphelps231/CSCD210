package arrayTraversal;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	static int userInput;

	static int[] array;

	static double mean, median;

	static boolean running = true;

	static final String[] MENU = 
		{ 	"1. Add a number to the array",
			"2. Display the mean",
			"3. Display the median",
			"4. Print the array to the screen",
			"5. Print the array in reverse order",
			"6. Quit" };

	public static void main(String[] args)
	{
		System.out.println(">Welcome to Andrew's Array Traversal!");
				
		while(running)	// main loop
		{
			printMenu();
			
			if(!gatherInput(">Please make a selection: "))	// check if input is valid
			{
				System.out.println(">I'm sorry, your input is invalid. Please try again");
			}
			else
			{
				processInput();	// process valid input
			}
			
			System.out.println("----------------\n");
		}
	}
	
	public static void printMenu()	// print menu choices to the screen
	{
		for(int i = 0; i < MENU.length; i++)
		{
			System.out.println(MENU[i]);
		}
	}

	public static void quit()	// cause the main loop to terminate
	{
		running = false;

		System.out.println(">Goodbye!");
	}

	public static void printArray(boolean direction)	// display array to screen
	{
		try
		{
			array = SortSearchUtil.sort(array);	// sort array
			
			for (int i = 0; i < array.length; i++)
			{
				// if direction==true, this line will print the the lowest number in the array that hasn't yet been printed, and vice versa if direction==false
				System.out.print(array[direction ? i : array.length - 1 - i]);

				if (i != array.length - 1)	// if we're not at then end of the array, print a "," to separate the digits
				{
					System.out.print(", ");
				}
			}

			System.out.println();
		}
		catch(Exception e)	// attempting to print an uninitialized array will not crash the program, instead the user will be prompted to try again
		{
			System.out.println(">Unable to print array");
		}
	}

	public static boolean calculateMeanMedian()	// calculate mean and median of array
	{
		try
		{
			array = SortSearchUtil.sort(array);	// sort array

			double meantmp = 0, mediantmp;	// tmp objects to hold values

			for (int i = 0; i < array.length; i++)	// create sum of values in array
			{
				meantmp += array[i];
			}

			meantmp /= array.length;	// turn sum of array into mean value

			if (array.length % 2 == 0)	// if array doesn't have an explicit median value, we must calculate it given the mean of the center two values
			{
				mediantmp = (array[(array.length / 2) - 1] + array[array.length / 2]) / 2.0;
			} else	// otherwise the median is the value in the middle of the sorted array
			{
				mediantmp = array[(array.length / 2)];
			}

			mean = meantmp;
			median = mediantmp;
		}
		catch(Exception e)	// attempting to perform calculations on an uninitialized array will not crash the program, instead the user will be prompted to try again
		{
			System.out.println(">Unable to perform calculations on array");
			
			return false;
		}
		
		return true;
	}

	public static void appendArray(int a)	// append a value to the end of the array
	{
		try
		{
			int[] tmp = array;	// create a copy of the array as to not overwrite its original values

			array = new int[tmp.length + 1];	// create a new array with one more slot than the original array

			for (int i = 0; i < array.length - 1; i++)	// fill new array with old values
			{
				array[i] = tmp[i];
			}

			array[array.length - 1] = a;	// add value to end of new array
		}
		catch(Exception e) // attempting to append a value to an uninitialized array will not crash the program, instead the array will be initialized for the first time here
		{
			array = new int[1];
			array[0] = a;
		}
	}

	public static boolean gatherInput(String message)	// gather user input
	{
		try
		{
			System.out.print(message);	// print message for input

			Scanner kb = new Scanner(System.in);

			int input = kb.nextInt();

			if (input < 0) // throw exception when input is invalid
			{
				throw new Exception("Input invalid");
			}

			userInput = input; // store known valid input

			return true;
		} catch (Exception e) // entering invalid input will cause a warning message to be fed back to the user
		{
			return false;
		}
	}
	
	public static void processInput()	// process input and perform menu actions
	{
		switch(userInput)
		{
		case 1:	// append value to array
			if(!gatherInput(">Please enter the number to be appended: "))
			{
				System.out.println(">I'm sorry, your input is invalid. Please try again");
			}
			else
			{
				appendArray(userInput);
			}
			break;
			
		case 2:	// display mean
			if(calculateMeanMedian())
			{
				System.out.println(">The mean is: " + mean);
			}
			
			break;
			
		case 3:	// display median
			if(calculateMeanMedian())
			{
				System.out.println(">The median is: " + median);
			}
			
			break;
			
		case 4:	// display array forwards
			printArray(true);
			break;
			
		case 5:	// display array reverse
			printArray(false);
			break;
			
		case 6:	// quit program
			quit();
			break;
		}
	}
}
