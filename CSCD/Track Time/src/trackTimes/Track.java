package trackTimes;

import java.util.Arrays;

public class Track
{
	static double mps = 1.0, fps = 3.28084, kph = 3.6, mph = 2.23694;

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(runConversions(5.0)));

		System.out.println(round(15.0 / 100.0));
	}

	public static double[] runConversions(double time)
	{
		double metersPerSecond = time / 100.0;

		double[] times = new double[]
		{ mps * metersPerSecond, fps * metersPerSecond, kph * metersPerSecond, mph * metersPerSecond };

		for (int i = 0; i < times.length; i++)
		{
			times[i] = round(times[i]);
		}

		return times;
	}

	public static double round(double num)
	{
		double a = num % 0.01;
		double x = num - a;

		return a >= .0049 ? x + .01 : x;
	}
}
