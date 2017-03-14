package test;

import java.util.Arrays;

public class TestClass
{
	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(splitInteger(123456789)));
		
		int n = 123;
		
		while(n > 0)
		{
			System.out.println(n % 10);
			n /= 10;
		}
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
