package rentalRates;

import java.text.SimpleDateFormat;
// Rental rates assignment
// Pre-set main for testing (see DEBUG constant)
// Required methods to be added: calcAge(...), calcRateClass(...) and displayResult(...)
// Also, insert code into main as indicated.
import java.util.*;

public class RentalRates
{
	private static final boolean DEBUG = false;

	private static final String UNDERAGE = "Sorry, the renter is not 25 years of age or older";
	private static final String BEST_RATE = "Best rate - $40.00 per day or $200.00 per week.";
	private static final String RISK_RATE_1 = "Risk rate 1 - $50.00 per day or $255.00 per week.";
	private static final String RISK_RATE_2 = "Risk rate 2 - $57.00 per day or $285.00 per week.";
	private static final String RISK_RATE_3 = "Risk rate 3 - $%d.00 per day or $%d.00 per week.";

	public static void main(String[] args)
	{
		int curMonth = 0;
		int curDay = 0;
		int curYear = 0;
		int birthMonth = 0;
		int birthDay = 0;
		int birthYear = 0;
		String gender = "";
		int age = 0;
		String rateResult;

		// Testing mode...
		if (DEBUG == true)
		{
			// Establish a 'current' date for testing...
			curMonth = 2;
			curDay = 1;
			curYear = 2016;

			System.out.println("First test case: Renter is not old enough to rent...");
			birthMonth = 2;
			birthDay = 2;
			birthYear = 1991;
			gender = "m";
			age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
			rateResult = calcRateClass(age, gender);
			displayResults(gender, age, rateResult);

			System.out.println("\n\n\n\nSecond test case: Renter is barely old enough (57/285)...");
			birthMonth = 2;
			birthDay = 1;
			birthYear = 1991;
			gender = "m";
			age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
			rateResult = calcRateClass(age, gender);
			displayResults(gender, age, rateResult);

			System.out.println("\n\n\n\nThird test case: Renter is 35 and male (40/200)...");
			birthMonth = 1;
			birthDay = 1;
			birthYear = 1981;
			gender = "m";
			age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
			rateResult = calcRateClass(age, gender);
			displayResults(gender, age, rateResult);

			System.out.println("\n\n\n\nFourth test case: Renter is 35 and female (40/200)...");
			birthMonth = 1;
			birthDay = 1;
			birthYear = 1981;
			gender = "f";
			age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
			rateResult = calcRateClass(age, gender);
			displayResults(gender, age, rateResult);

			System.out.println("\n\n\n\nFifth test case: Renter is 30 and male (57/285)...");
			birthMonth = 1;
			birthDay = 1;
			birthYear = 1986;
			gender = "m";
			age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
			rateResult = calcRateClass(age, gender);
			displayResults(gender, age, rateResult);

			System.out.println("\n\n\n\nSixth test case: Renter is 30 and female (40/200)...");
			birthMonth = 1;
			birthDay = 1;
			birthYear = 1986;
			gender = "f";
			age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
			rateResult = calcRateClass(age, gender);
			displayResults(gender, age, rateResult);

			System.out.println("\n\n\n\nSeventh test case: Renter is 76 and male (62/255)...");
			birthMonth = 1;
			birthDay = 1;
			birthYear = 1940;
			gender = "m";
			age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
			rateResult = calcRateClass(age, gender);
			displayResults(gender, age, rateResult);

			System.out.println("\n\n\n\nEighth test case: Renter is 76 and female (68/270)...");
			birthMonth = 1;
			birthDay = 1;
			birthYear = 1940;
			gender = "f";
			age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
			rateResult = calcRateClass(age, gender);
			displayResults(gender, age, rateResult);
		} else
		{
			Scanner kb = new Scanner(System.in);
			System.out.println("Welcome to the car renter's rate finder.");

			// If you're not attempting the EC, get today's date from the
			// user...
			// Your code goes here...

			// If you are attempting the EC, use the Calendar class to get
			// today's date...
			// Your code goes here...
			
			int[] tmpDate = getDate();
			
			curMonth = tmpDate[0]; //EXTRA CREDIT
			curDay = tmpDate[1];
			curYear = tmpDate[2];
			
			System.out.printf("Today's date is %d/%d/%d\n", curMonth, curDay, curYear);

			// Get the gender...
			// Your code goes here...
			
			System.out.print("Please enter the renter's gender: ");
			
			gender = kb.nextLine();

			// Get the date of birth...
			// Your code goes here...
			
			System.out.print("Please enter the renter's date of birth (mm dd yyyy): ");
			
			String[] tmpBday = kb.nextLine().split(" ");
			
			birthMonth = Integer.parseInt(tmpBday[0]);
			birthDay = Integer.parseInt(tmpBday[1]);
			birthYear = Integer.parseInt(tmpBday[2]);

			// Get age...
			
			age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);

			// Get the rental rate...
			
			rateResult = calcRateClass(age, gender);

			// Display the results...
			
			displayResults(gender, age, rateResult);
		}
	}
	
	public static int calcAge(int curMonth, int curDay, int curYear, int birthMonth, int birthDay, int birthYear)
	{
		int years;
		
		years = curYear - birthYear;
		
		if(curMonth < birthMonth || ((curMonth == birthMonth) && (curDay < birthDay)))
		{
			years--;
		}
		
		return years;
	}
	
	public static String calcRateClass(int age, String gender)
	{
		if(gender.toLowerCase() == "m")
		{
			if(age < 25)
			{
				return UNDERAGE;
			}
			else if(age < 33)
			{
				return RISK_RATE_2;
			}
			else if(age < 66)
			{
				return BEST_RATE;
			}
			else
			{
				return RISK_RATE_3;
			}
		}
		else
		{
			if(age < 25)
			{
				return UNDERAGE;
			}
			else if(age < 30)
			{
				return RISK_RATE_1;
			}
			else if(age < 63)
			{
				return BEST_RATE;
			}
			else
			{
				return RISK_RATE_3;
			}
		}
	}
	
	public static void displayResults(String gender, int age, String rateResult)
	{
		System.out.println("Thank you.");
		System.out.printf("The %s renter is %d years old.\n", gender.toLowerCase().contains("m") ? "male" : "female", age);
		System.out.print("The rate class is: ");
		
		int daily = 40;
		int weekly = 200;
		
		daily += gender.toLowerCase().contains("m") ? 2 * (age - 65) : 2 * (age - 62);
		weekly += gender.toLowerCase().contains("m") ? 5 * (age - 65) : 5 * (age - 62);
		
		System.out.printf(rateResult, daily, weekly);
	}
	
	public static int[] getDate()
	{
		String[] tmp = new SimpleDateFormat("MM/dd/yyy").format(Calendar.getInstance().getTime()).split("/");
		
		int[] tmpInt = { Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]) };
		
		return tmpInt;
	}
}