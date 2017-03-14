package rationalNumbers;

import java.util.Scanner;

/*	Andrew Phelps - Rational Numbers assignment
 * 	March 6th, 2017
 * 	Shortcomings: creating the fraction reduction method, none that affect the final product
 * 	Extra credit: none attempted 
 */

public class RationalDriver
{
	static Rational r0 = new Rational(2, 3);
	static Rational r1 = new Rational(2, 18);
	static Rational r2 = new Rational(3, 12);
	static Rational r3 = new Rational(9, 3);
	static Rational r4 = new Rational(2, 5);
	static Rational r5 = new Rational(22, 7);
	
	static Rational[] r = { r0, r1, r2, r3, r4, r5 };
	
	static String[] menu = { "1. Display the value of a rational", "2. Change the value of a rational", "3. Add two rationals", "4. Subtract two rationals", "5. Sort the array of rationals", "6. Print the array of rationals", "7. Quit" };
	
	static boolean running = true;
	
	static int inputInt;
	static String inputString;
	
	static Scanner kb;
	
	public static void main(String[] args)
	{
		run();
	}
	
	public static void run()
	{
		while(running)
		{
			printArr(menu, true);
			gatherInput(">Please choose an option: ", true);
			runMenu(inputInt);
			System.out.println("----------------------------------------");
		}
	}
	
	public static void printArr(Object[] arr, boolean newLine)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i].toString() + (newLine ? "\n" : (i != (arr.length - 1) ? ", " : "")));
		}
		
		System.out.print("\n");
	}
	
	public static void runMenu(int choice)
	{
		switch(inputInt)
		{
		case 1: //display value of rational
			gatherInput(">Please enter the desired index: ", true);
			
			if(!checkIndexRange(r, inputInt))
			{
				break;
			}
			
			System.out.println(r[inputInt]);
			break;
		case 2: //change value of rational
			gatherInput(">Please enter the desired index: ", true);
			gatherInput(">Please enter the new value \'[numerator]/[denominator]\': ", false);
			
			r[inputInt] = parseRational(inputString);
			break;
		case 3: //add two rationals and display new
			int a, b;
			
			gatherInput(">Please enter the first desired index: ", true);
			a = inputInt;
			
			gatherInput(">Please enter the second desired index: ", true);
			b = inputInt;
			
			System.out.println(r[a].add(r[b]).toString());
			break;
		case 4: //subtract two rationals and display new
			int c, d;
			
			gatherInput(">Please enter the first desired index: ", true);
			c = inputInt;
			
			gatherInput(">Please enter the second desired index: ", true);
			d = inputInt;
			
			System.out.println(r[c].subtract(r[d]).toString());
			break;
		case 5: //sort rationals array
			System.out.println(">Sorting array...");
			
			SearchAndSort.selectionSort(r);
			
			System.out.println(">Done");
			break;
		case 6: //print rationals array
			printArr(r, false);
			break;
		case 7: //quit
			running = false;
			kb.close();
			break;
		default:
			System.out.println(">Invalid input. Try again");
			break;
		}
	}
	
	public static void gatherInput(String message, boolean isInteger)
	{
		kb = new Scanner(System.in);
		
		System.out.print(message);
		
		if(isInteger)
		{
			inputInt = kb.nextInt();
		}
		else
		{
			inputString = kb.nextLine();
		}
		
		System.out.print("\n");
	}
	
	public static boolean checkIndexRange(Object[] arr, int i)
	{
		int a = 0, b = arr.length - 1;
		
		boolean withinRange = ((i >= a) && (i <= b));
		
		if(!withinRange)
		{
			System.out.println(">Sorry, the input index is not within the valid range of [" + a + "," + b + "]");
		}
		
		return withinRange;
	}
	
	public static Rational parseRational(String input)
	{
		String[] r = new String[2];
		
		r = input.split("/");
		
		return new Rational(Integer.parseInt(r[0]), Integer.parseInt(r[1]));
	}
}
