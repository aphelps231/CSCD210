package trackTimes;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Track
{
	static double mps = 1.0, fps = 3.28084, kph = 3.6, mph = 2.23694, yps = 1.09361;

	static String[] messages = new String[]
	{ " meters per second,", " feet per second,", " kilometers per hour,", " miles per hour," };

	static Scanner s;

	public static void main(String[] args)
	{
		runProgram();
	}

	public static void runProgram()
	{
		s = new Scanner(System.in);
		double input;
		double[] times;

		System.out.print("Please enter the winning time of the race: ");

		input = Double.parseDouble(s.nextLine());

		times = runVelocityConversions(input);
		
		for(int i = 0; i < times.length; i++)
		{
			System.out.println(times[i] + messages[i]);
		}
		
		int minutes;
		double seconds;
		
		times = runTimeConversions(input);
		
		times[0] *= 60.0; //seconds
		minutes = (int) times[0];
		seconds = round(times[0] - minutes);
		
		System.out.println("It would take " + minutes + " minutes and " + seconds + " seconds for the person to run one mile.");
		
		times[1] *= 100.0;
		seconds = round(times[1]);
		
		System.out.println("It would take " + seconds + " seconds for the person to run one hundred yards.");
		
		System.out.println("\nWould you like to start over? Y/N");
		
		String in = s.nextLine();
		
		if(in.contains("Y") || in.contains("y"))
		{
			runProgram();
		}
	}

	public static double[] runVelocityConversions(double time)
	{
		double metersPerSecond = 100.0 / time;

		double[] times = new double[]
		{ mps * metersPerSecond, fps * metersPerSecond, kph * metersPerSecond, mph * metersPerSecond };

		DecimalFormat df = new DecimalFormat("#.00");
		
		for (int i = 0; i < times.length; i++)
		{
			times[i] = Double.parseDouble(df.format(round(times[i])));
		}

		return times;
	}
	
	public static double[] runTimeConversions(double time)
	{
		double	metersPerSecond = 100.0 / time,
				mphN = mph * metersPerSecond,
				ypsN = yps * metersPerSecond,
				hpmN = 1.0 / mphN,
				spyN = 1.0 / ypsN;
		
		return new double[] { hpmN, spyN };
	}

	public static double round(double num)
	{
		double a = (int) (num * 100.0);
		double x = (double) (a / 100);
		
		return num - x >= .005 ? x + .01 : x;
	}
}
